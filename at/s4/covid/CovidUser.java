package upf.at.s4.covid;
public class CovidUser {
	
	private String nom;
	private int phone;
	
	
	public CovidUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CovidUser(String nom, int phone) {
		super();
		this.nom = nom;
		this.phone = phone;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "CovidUser [nom=" + nom + ", phone=" + phone + "]";
	}
	
}