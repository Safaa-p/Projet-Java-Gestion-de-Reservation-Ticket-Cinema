package cine;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.swing.JOptionPane;
public class Reservation{
	private int ligne_Place;
	private int NumPlace;
	private film film;
	private String type;
	private int NbreplaceDispo=15;
	private int  Nbreplace;
	private Date date_Res ; 
	private Horaire horaire;
	private int prix;
	public Reservation(film film,String type, int Nbreplace, Date date_Res,Horaire horaire ) {
		setNbreplaceDispo(getNbreplaceDispo() - Nbreplace);
		this.film=film;
		this.type=type;
		this.Nbreplace=Nbreplace;
		this.date_Res=date_Res;
		this.horaire= horaire ;
	}

	public void setNbreplace(int Nbreplace1) {
		this.Nbreplace=Nbreplace1;
	}
	public void setdate_Res(Date date_Res1) {
		this.date_Res=date_Res1;
	}
	
	public int getNbreplace() {
		return this.Nbreplace;
	}
	public Date getdate_Res() {
		return this.date_Res;
	}
	public void affiche()
	{
	
		System.out.println("Nombre de place :"+this.Nbreplace);
		System.out.println("Date de Reservetion  :"+this.date_Res);
		System.out.println(this.type);
	}
	
	public int getLigne_Place() {
		return ligne_Place;
	}
	public void setLigne_Place(int ligne_Place) {
		this.ligne_Place = ligne_Place;
	}
	public int getNumPlace() {
		return NumPlace;
	}
	public void setNumPlace(int numPlace) {
		NumPlace = numPlace;
	}
	
	public film getFilm() {
		return film;
	}
	public void setFilm(film film) {
		this.film = film;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Horaire getHoraire() {
		return horaire;
	}
	public void setHoraire(Horaire horaire) {
		this.horaire = horaire;
	}
	
	public int  Reservation1(Reservation a) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/films","root1","Qor_11111");
			Statement stm=con.createStatement();
			String sql="Select * from film where NomFilm='"+a.getFilm().getTitre()+"'";
			ResultSet res=stm.executeQuery(sql);
			if (res.next()) {
				if (type=="VIP") {
					prix=res.getInt("Prix_VIP");
				}
				else {prix=res.getInt("Prix_Normal");}
				
				
				}
			
			else {JOptionPane.showMessageDialog(null, "film non existant");}
		}
		catch(Exception re) 
		{
			System.out.println(re);
			
		}
		
		return prix;
		
		
	}

	public int getNbreplaceDispo() {
		return NbreplaceDispo;
	}

	public void setNbreplaceDispo(int nbreplaceDispo) {
		NbreplaceDispo = nbreplaceDispo;
	}
	
}