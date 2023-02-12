package cine;
public class Horaire{
	private int heure;
	private int minute;
	public Horaire(int heure,int minute){
		this.heure=heure;
		this.minute=minute;
	}
	public int getHeure() {
		return heure;
	}
	public void setHeure(int heure) {
		this.heure = heure;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
}