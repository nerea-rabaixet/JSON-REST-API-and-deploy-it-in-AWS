package upf.at.s4.covid;

import java.util.Date;

public class Covid {
	
	private String nom;
	private int codi; 
	private String data_ini; 
	private String data_fi; 
	private String residencia;
	private double iepg_confirmat; 
	private double r0_confirmat_m;
	private double taxa_casos_confirmat;
	private int casos_confirmat;
	private double taxa_pcr;
	private int pcr;
	private double perc_pcr_positives;
	private int ingressos_total;
	private int ingressos_critic;
	private int exitus;
	

	public Covid(String nom, int codi, String data_ini, String data_fi, String residencia, double iepg_confirmat,
			double r0_confirmat_m, double taxa_casos_confirmat, int casos_confirmat, double taxa_pcr, int pcr,
			double perc_pcr_positives, int ingressos_total, int ingressos_critic, int exitus) {
		super();
		this.nom = nom;
		this.codi = codi;
		this.data_ini = data_ini;
		this.data_fi = data_fi;
		this.residencia = residencia;
		this.iepg_confirmat = iepg_confirmat;
		this.r0_confirmat_m = r0_confirmat_m;
		this.taxa_casos_confirmat = taxa_casos_confirmat;
		this.casos_confirmat = casos_confirmat;
		this.taxa_pcr = taxa_pcr;
		this.pcr = pcr;
		this.perc_pcr_positives = perc_pcr_positives;
		this.ingressos_total = ingressos_total;
		this.ingressos_critic = ingressos_critic;
		this.exitus = exitus;
	}

	public Covid() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public String toString() {
		return "Covid [nom=" + nom + ", codi=" + codi + ", data_ini=" + data_ini + ", data_fi=" + data_fi
				+ ", residencia=" + residencia + ", iepg_confirmat=" + iepg_confirmat + ", r0_confirmat_m="
				+ r0_confirmat_m + ", taxa_casos_confirmat=" + taxa_casos_confirmat + ", casos_confirmat="
				+ casos_confirmat + ", taxa_pcr=" + taxa_pcr + ", pcr=" + pcr + ", perc_pcr_positives="
				+ perc_pcr_positives + ", ingressos_total=" + ingressos_total + ", ingressos_critic=" + ingressos_critic
				+ ", exitus=" + exitus + "]";
	}

	
	public String getData_ini() {
		return data_ini;
	}
	public void setData_ini(String data_ini) {
		this.data_ini = data_ini;
	}
	
	public double getIepg_confirmat() {
		return iepg_confirmat;
	}
	public void setIepg_confirmat(double iepg_confirmat) {
		this.iepg_confirmat = iepg_confirmat;
	}
	public double getR0_confirmat_m() {
		return r0_confirmat_m;
	}
	public void setR0_confirmat_m(double r0_confirmat_m) {
		this.r0_confirmat_m = r0_confirmat_m;
	}
	public double getTaxa_casos_confirmat() {
		return taxa_casos_confirmat;
	}
	public void setTaxa_casos_confirmat(double taxa_casos_confirmat) {
		this.taxa_casos_confirmat = taxa_casos_confirmat;
	}
	public int getCasos_confirmat() {
		return casos_confirmat;
	}
	public void setCasos_confirmat(int casos_confirmat) {
		this.casos_confirmat = casos_confirmat;
	}
	public double getTaxa_pcr() {
		return taxa_pcr;
	}
	public void setTaxa_pcr(double taxa_pcr) {
		this.taxa_pcr = taxa_pcr;
	}
	public int getPcr() {
		return pcr;
	}
	public void setPcr(int pcr) {
		this.pcr = pcr;
	}
	public double getPerc_pcr_positives() {
		return perc_pcr_positives;
	}
	public void setPerc_pcr_positives(double perc_pcr_positives) {
		this.perc_pcr_positives = perc_pcr_positives;
	}
	public int getIngressos_total() {
		return ingressos_total;
	}
	public void setIngressos_total(int ingressos_total) {
		this.ingressos_total = ingressos_total;
	}
	public int getIngressos_critic() {
		return ingressos_critic;
	}
	public void setIngressos_critic(int ingressos_critic) {
		this.ingressos_critic = ingressos_critic;
	}
	public int getExitus() {
		return exitus;
	}
	public void setExitus(int exitus) {
		this.exitus = exitus;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCodi() {
		return codi;
	}

	public void setCodi(int codi) {
		this.codi = codi;
	}

	public String getData_fi() {
		return data_fi;
	}

	public void setData_fi(String data_fi) {
		this.data_fi = data_fi;
	}

	public String getResidencia() {
		return residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}
}