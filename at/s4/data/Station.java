package upf.at.s4.data;
public class Station {
	
	private int station_id;
	private int num_bikes_available; 
	private int num_docks_available; 
	private long last_reported;
	private boolean is_charging_station;
	private String status; 
	private int is_installed;
	private int is_renting;
	private int is_returning;
	private String traffic;

	public Station(int station_id, int num_bikes_available, int num_docks_available, long last_reported,
			boolean is_charging_station, String status, int is_installed, int is_renting, int is_returning,
			String traffic) {
		super();
		this.station_id = station_id;
		this.num_bikes_available = num_bikes_available;
		this.num_docks_available = num_docks_available;
		this.last_reported = last_reported;
		this.is_charging_station = is_charging_station;
		this.status = status;
		this.is_installed = is_installed;
		this.is_renting = is_renting;
		this.is_returning = is_returning;
		this.traffic = traffic;
	}

	
	public Station() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Station [station_id=" + station_id + ", num_bikes_available=" + num_bikes_available
				+ ", num_docks_available=" + num_docks_available + ", last_reported=" + last_reported
				+ ", is_charging_station=" + is_charging_station + ", status=" + status + "]";
	}
	public String av_stat() {
		return "Station [station_id=" + station_id 
				+ ", num_docks_available=" + num_docks_available + "]";
	}

	public int getNum_bikes_available() {
		return num_bikes_available;
	}

	public void setNum_bikes_available(int num_bikes_available) {
		this.num_bikes_available = num_bikes_available;
	}

	public int getNum_docks_available() {
		return num_docks_available;
	}

	public void setNum_docks_available(int num_docks_available) {
		this.num_docks_available = num_docks_available;
	}

	public long getLast_reported() {
		return last_reported;
	}

	public void setLast_reported(long last_reported) {
		this.last_reported = last_reported;
	}

	public boolean isIs_charging_station() {
		return is_charging_station;
	}

	public void setIs_charging_station(boolean is_charging_station) {
		this.is_charging_station = is_charging_station;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStation_id() {
		return station_id;
	}

	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}

	public int getIs_installed() {
		return is_installed;
	}

	public void setIs_installed(int is_installed) {
		this.is_installed = is_installed;
	}

	public int getIs_renting() {
		return is_renting;
	}

	public void setIs_renting(int is_renting) {
		this.is_renting = is_renting;
	}

	public int getIs_returning() {
		return is_returning;
	}

	public void setIs_returning(int is_returning) {
		this.is_returning = is_returning;
	}

	public String getTraffic() {
		return traffic;
	}

	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}
}
