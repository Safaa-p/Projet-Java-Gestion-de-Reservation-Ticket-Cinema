package cine;
import  java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private String nom;
	private int age;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Je m'identifie ");
		lblNewJgoodiesLabel.setForeground(Color.BLUE);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewJgoodiesLabel.setBounds(154, 21, 120, 14);
		contentPane.add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Mon Email ");
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewJgoodiesLabel_1.setForeground(new Color(0, 0, 0));
		lblNewJgoodiesLabel_1.setBounds(25, 65, 92, 14);
		contentPane.add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Password");
		lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewJgoodiesLabel_2.setBounds(25, 102, 92, 14);
		contentPane.add(lblNewJgoodiesLabel_2);
		
		JButton btnNewButton = new JButton("Je m'identifie");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/films","root1","Qor_11111");
					Statement stm=con.createStatement();
					String sql="Select * from login where Email='"+textField.getText()+"' and Password ='"+passwordField.getText().toString()+"'";
					ResultSet res=stm.executeQuery(sql);
					if (res.next()) {
						JOptionPane.showMessageDialog(null, "Login successful...");
						String nom=res.getString("nom");
						int age=res.getInt("age");
						
						MainFrame b1=new MainFrame();
						b1.setAge(age);
						b1.setVisible(true);
						dispose();
						}
					else {JOptionPane.showMessageDialog(null, "Email ou mot de passe incorrecte");}
				}
				catch(Exception re) 
				{
					System.out.println(re);
				}
				}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(146, 158, 142, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(154, 62, 166, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(154, 99, 166, 20);
		contentPane.add(passwordField);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
