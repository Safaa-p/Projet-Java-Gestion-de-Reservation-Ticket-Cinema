package cine;
public abstract class Person{
	private String nom;
	private String prenom;
	
	public Person(String nom,String prenom) {
		this.nom=nom;
		this.prenom=prenom;
		
	}
	public void setNom(String nom1) {
		this.nom=nom1;
	}
	public void setPrenom(String Pnom1) {
		this.prenom=Pnom1;
	}

	
	public String getNom( ) {
		return this.nom;
	}
	public String getPrenom() {
		return  this.prenom;
	}
	
	
	public void affiche()
	{
		
	}
}