package upf.at.s4.server;
import upf.at.s4.client.*;
import upf.at.s4.covid.Covid;
import upf.at.s4.covid.CovidUser;
import upf.at.s4.data.*;
import upf.at.s4.message.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/bicing")
public class Services {
	//cache 
	public static List<Station> stations = new ArrayList<Station>();
	public static List<User> users = new ArrayList<User>();
	public static List<Covid> covids = new ArrayList<Covid>();
	//URLs
	static String bicingURL = "https://api.bsmsa.eu/";
	static String bicingPath = "ext/api/bsm/gbfs/v2/en/station_status";
	static String covidURL = "https://analisi.transparenciacatalunya.cat/";
	static String covidPath = "resource/jvut-jxu8.json";
	
	//static String AWSinstance = "ec2-user@ec2-54-146-182-136.compute-1.amazonaws.com";
	
	// Bicing		
	//In this method we check if we have the stations in cache and if not we save them.
	@GET
	@Path("/getStations")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Station> get_Stations(){
		if (stations.isEmpty()) {
			Client client = ClientBuilder.newClient();
			WebTarget targetGet = client.target(bicingURL).path(bicingPath); 
			@SuppressWarnings("unused")
			Data stations_status = targetGet.request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<Data>(){});
			stations = stations_status.getData().getStations();
			return stations;
		}
		return stations;
	}	
	
	//add a user:
	//This method is used to create users and subscribe them to Bicing stations. For this
	//purpose, the service must receive the phone number of the client, the list of stations ids the client wants to be
	//subscribed and the Telegram data (token) required to send a Telegram message.
	@POST
	@Path("/subscribe")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response subscribe(User newUser) {
		for(int i = 0; i<users.size(); i++) {
			if(users.get(i).getPhone() == newUser.getPhone()) {
				users.remove(i);
			}
		}
		users.add(newUser);
		return Response.status(200).entity(newUser).build();
	}
		
	//get user: returns the list of users registered
	@GET
	@Path("/getUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return users;
	}
	
	// this method returns the stations in which you have subscribed
	@POST
	@Path("/getMyStations")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Stations myStat(User u1) {
		List<Station> stat1 = new ArrayList<Station>();
		User u = new User();
		Stations stat = new Stations(stat1);
		Station st = new Station();
		//check if the user is subscribed, if not, adds it to the cache
		for(int i = 0; i<users.size(); i++) {
			if(users.get(i).getPhone() == u1.getPhone()) {
				u = users.get(i);
			}
		}
		//check if the stations of the users correspond with the ones registered, if not updates them.
		for(int k = 0; k<stations.size(); k++) {
			if(u.getSubstribed_Stations().contains(stations.get(k).getStation_id())) {
				st = stations.get(k);
				stat1.add(st);
			}
		}
		//check if the user exists and if so, it sends the message via Telegram with the inforamtion of the stations
		for(int j = 0; j<users.size(); j++) {
			u = users.get(j);
			if(u1.getPhone() == u.getPhone()) {
				String m = stat.av_statToString();
				RestClient.sendMessage(m);
				return stat;
			}
		}
		return null;
	}
	
	// Method to get the information of covid
	@GET
	@Path("/getCovidInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Covid> get_Covid(){
		//we first check if the information is already saved in the cache, if not, we upload it.
		if (covids.isEmpty()) {
			Client client = ClientBuilder.newClient();
			WebTarget targetGet = client.target(covidURL).path(covidPath); 
			@SuppressWarnings("unused")
			List<Covid> covid_status = targetGet.request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<List<Covid>>(){});
			covids = covid_status;
			return covids;
		}
		return covids;
	}
		
	// Get My Covid method returns the information of Covid in a region given a CovidUser user with fields: Phone and Region
	@POST
	@Path("/getMyCovid")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Covid myCovid(CovidUser user) throws ParseException {
		List<Covid> stat = new ArrayList<Covid>();
		List<String> semana = new ArrayList<String>(); // semana contains all days of a week
		semana.add("2022-03-07T00:00:00.000");
		semana.add("2022-03-06T00:00:00.000");
		semana.add("2022-03-05T00:00:00.000");
		semana.add("2022-03-04T00:00:00.000");
		semana.add("2022-03-03T00:00:00.000");
		semana.add("2022-03-02T00:00:00.000");
		semana.add("2022-03-01T00:00:00.000");
		
		Covid c = new Covid();
		Covid s = new Covid();
		User u = new User();
		//
		for(int k = 0; k<covids.size(); k++) {
			c = covids.get(k);
			if(user.getNom().equals(c.getNom())) {
				stat.add(c);
			}
		}
		for(int i = 0; i<stat.size(); i++) {
			if(semana.contains(stat.get(i).getData_fi())) {
				s = stat.get(i);
			}
		}
		//if el phone existeix
		for(int j = 0; j<users.size(); j++) {
			u = users.get(j);
			if(user.getPhone() == u.getPhone()) {
				String m = s.toString();
				RestClient.sendMessage(m);
				return s;
			}
		}
		return null;
	}
}


