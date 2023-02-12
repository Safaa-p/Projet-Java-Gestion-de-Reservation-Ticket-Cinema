package cine;
public class Date{
	private int jour;
	private String mois;
	private int année;
	public Date(int jour,String mois,int année) {
		this.jour =jour;
		this.mois=mois;
		this.année=année;
	}
	public int getJour() {
		return jour;
	}
	public void setJour(int jour) {
		this.jour = jour;
	}
	public String getMois() {
		return mois;
	}
	public void setMois(String mois) {
		this.mois = mois;
	}
	public int getAnnée() {
		return année;
	}
	public void setAnnée(int année) {
		this.année = année;
	}
}