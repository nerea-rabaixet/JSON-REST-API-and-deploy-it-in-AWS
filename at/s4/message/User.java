package upf.at.s4.message;
import java.util.List;

public class User {
	private int phone;
	private long chatID;
	private List<Integer> substribed_Stations;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public User(int phone, long chatID, List<Integer> substribed_Stations) {
		super();
		this.phone = phone;
		this.chatID = chatID;
		this.substribed_Stations = substribed_Stations;
	}



	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public long getChatID() {
		return chatID;
	}

	public void setChatID(long chatID) {
		this.chatID = chatID;
	}

	public List<Integer> getSubstribed_Stations() {
		return substribed_Stations;
	}

	public void setSubstribed_Stations(List<Integer> substribed_Stations) {
		this.substribed_Stations = substribed_Stations;
	}

	@Override
	public String toString() {
		return "User [phone=" + phone + ", chatID=" + chatID + ", substribed_Stations=" + substribed_Stations
				 + "]";
	}
	
}