package upf.at.s4.client;

import javax.ws.rs.core.MediaType;

import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;

import upf.at.s4.covid.Covid;
import upf.at.s4.data.*;
import upf.at.s4.server.Services;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import upf.at.s4.message.Message;
import upf.at.s4.message.User;
import upf.at.s4.message.Users;
public class RestClient {
	public RestClient() {
	}
	public static List<Station> stations = new ArrayList<Station>();
	public static List<User> users = new ArrayList<User>();
	public static List<Covid> covids = new ArrayList<Covid>();
	static String bicingURL = "https://api.bsmsa.eu/";
	static String bicingPath = "ext/api/bsm/gbfs/v2/en/station_status";
	static String AWSinstance = "ec2-user@ec2-54-146-182-136.compute-1.amazonaws.com";
	static String covidURL = "https://analisi.transparenciacatalunya.cat/";
	static String covidPath = "resource/jvut-jxu8.json";
	
	public static void main(String[] args) throws Exception {
		
		//get from the web all stations using threads
	
		Runnable runnable = new Runnable() {
			public void run() {
				while (true) {
					// We do an infinite loop
					try {
												
						// We save the stations info in the cache
						Stations newStat = new Stations();
						Client client = ClientBuilder.newClient();
						WebTarget targetGet = client.target(bicingURL).path(bicingPath);
						// Add stations
						Data stations_status = targetGet.request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<Data>() {});
						newStat = stations_status.getData();
						
						System.out.println("Stations are downloading");
						for(Iterator<Station> iterator = stations_status.getData().getStations().iterator();iterator.hasNext();) {
							Station station = iterator.next();
							//System.out.println(station.toString());
						}
						Services.stations = newStat.getStations();
						Thread.sleep(12000);
						// This code above is executed every 12000 miliseconds
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread hilo = new Thread(runnable);
		hilo.start();		
	}
		
	// Send message function given a message since the chatID and the TOKEN are always the same.
		public static void sendMessage(String texto) {
			long chatID = 5175901731L;
			String TOKEN = "5189701658:AAFJ6jrRniRwyB_xnQI1Dm_sq_JWbI_InVw";
			Message message = new Message(chatID, texto);
			Client client2 = ClientBuilder.newClient();
			WebTarget targetSendMessage = client2.target("https://api.telegram.org").path("/bot"+TOKEN+ "/sendMessage");
			String response = targetSendMessage.request().post(Entity.entity(message, MediaType.APPLICATION_JSON_TYPE), String.class);
			System.out.println( message + "has been sended with response " + response);
		}
	
}