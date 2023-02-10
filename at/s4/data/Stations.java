package upf.at.s4.data;


import java.util.List;

public class Stations {
	private List<Station> stations;

	public Stations(List<Station> stations) {
		super();
		this.setStations(stations);
	}

	public Stations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	@Override
	public String toString() {
		String st = null;
		for (int i=0; i<stations.size(); i++) {
			st = st + stations.get(i).toString();
		}
		return st;
	}
	public String av_statToString() {
		String st = null;
		for (int i=0; i<stations.size(); i++) {
			st = st + stations.get(i).av_stat();
		}
		return st;
	}
	


	
}