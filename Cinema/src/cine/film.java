package cine;
import java.time.LocalDate;
public class film {
	private String Titre;
	private int AgeRating; 
	private boolean type3D;
	private String genre;
	private String Pays;
	public film(String Titre, int ageRating, String genre) {
		this.Titre=Titre;
		AgeRating = ageRating;
		this.genre=genre;
		
		
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	public int getAgeRating() {
		return AgeRating;
	}
	public void setAgeRating(int ageRating) {
		AgeRating = ageRating;
	}
	public boolean isType3D() {
		return type3D;
	}
	public void setType3D(boolean type3d) {
		type3D = type3d;
	}
    public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPays() {
		return Pays;
	}
	public void setPays(String pays) {
		Pays = pays;
	}
	public void affiche() {
		System.out.println("le titre du film est : "+this.Titre);
	    System.out.println("Genre :"+this.genre);
		System.out.println("AgeRating "+this.AgeRating);
		
	}
	
	
}