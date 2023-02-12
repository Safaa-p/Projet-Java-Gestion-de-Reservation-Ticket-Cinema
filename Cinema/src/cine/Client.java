package cine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.EventQueue;
import  java.sql.*;
import javax.swing.JOptionPane;

public class Client extends Person implements Recherche{
	private String Email;
	private String Password;
	private int Age;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client e=new Client("s","b",8,"f","a");
					  e.RechercherparTitre("mon roi");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
   
	public Client(String nom, String prenom, int Age ,String Email,String Password) {
		super(nom, prenom);
		this.Age=Age;
		// TODO Auto-generated constructor stub
		this.setEmail(Email);
		this.setPassword(Password);
	}
	public int getAge() {
		return this.Age;
	}
	public void setAge(int Age) {
		this.Age=Age;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	public void RechercherparTitre(String Titre) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/films","root1","Qor_11111");
			Statement stm=con.createStatement();
			String sql="Select * from film where NomFilm='"+Titre+"'";
			ResultSet res=stm.executeQuery(sql);
			if (res.next()) {
				
				String f1=res.getString("NomFilm");
				String f2=res.getString("Genre");
				int f3=res.getInt("AgeRating");
				film ff=new film(f1,f3,f2);
				ff.affiche();
				
				}
			else {JOptionPane.showMessageDialog(null, "film non existant");}
		}
		catch(Exception re) 
		{
			System.out.println(re);
			
		}
		
	}
	public void  RechercherparGenre(String genre) {
		
		String[][] data = new String[4][5];
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/films","root1","Qor_11111");
			Statement stm=con.createStatement();
			String sql="Select NomFilm,AgeRating,Prix_Normal,Prix_VIP from film where Genre='"+genre+"'";
			ResultSet res=stm.executeQuery(sql);
			int i=0;
			if (res.next()) {
				for(int j=1;j<5;j++) {
					 System.out.print(res.getString("NomFilm"));
					data[i][j]=res.getString(j);
				}
				i=i+1;}
			else {JOptionPane.showMessageDialog(null, "film non existant");}
			for (int x=0;x<data.length;x++) {
				for (int y=0;(data[x]!= null && y <data[x].length);y++) {
						 System.out.print(data[x][y] + " ");
					 }
					 System.out.println();
				 }
				String f1=res.getString("NomFilm");
				String f2=res.getString("Genre");
				int f3=res.getInt("AgeRating");
				film ff=new film(f1,f3,f2);
				}
			
		
		catch(Exception re) 
		{
			System.out.println(re);
			
		}
		
		
	};
		
		
	
	
}