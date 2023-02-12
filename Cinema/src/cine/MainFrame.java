package cine;

import java.awt.EventQueue;
import  java.sql.*;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.CardLayout;
import javax.swing.JTextPane;
import java.awt.Point;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel BackgroundPanel;
	private JTextField textField;
	private JTextField textField1;
	private int Age;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;
	private JComboBox comboBox_5;
	private JComboBox comboBox_6;
	private JComboBox comboBox_7;
	private JRadioButton j1 ;
	private JRadioButton j1_1;
	private String titre;
	private String type;
	private int ageRating;
	private String genre;
	private String mois;
	private int jour;
	private int année;
	private film z;
	private Date tt;
	private int heure;
	private int minute;
	private int Nbreplace;
	private Horaire rr;
	private Reservation a;
	private int prix;
	private JLabel Label_13;
	private ImageIcon at;
	private ImageIcon b;
	private ImageIcon c;
	private ImageIcon d;
	private ImageIcon ee;
	private ImageIcon f;
	/**
	 * Launch the application.
	 */
	
	public  static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					
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
	public MainFrame() {
		setTitle("MainFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 514);
		BackgroundPanel = new JPanel();
		BackgroundPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(BackgroundPanel);
		BackgroundPanel.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Reservation Ticket");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewJgoodiesLabel.setForeground(Color.BLUE);
		lblNewJgoodiesLabel.setBounds(243, 11, 155, 28);
		BackgroundPanel.add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Nom Film :");
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewJgoodiesLabel_1.setBounds(28, 66, 205, 14);
		BackgroundPanel.add(lblNewJgoodiesLabel_1);
		
		textField = new JTextField();
		textField.setBounds(95, 63, 255, 20);
		BackgroundPanel.add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}});
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Genre :");
		lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewJgoodiesLabel_2.setBounds(28, 91, 92, 14);
		BackgroundPanel.add(lblNewJgoodiesLabel_2);
		
		  comboBox = new JComboBox();
		  comboBox.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		if(e.getSource()==comboBox) {
		 			 genre=comboBox.getSelectedItem().toString();
		 		}
		  	}
		  });
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"romance", "action", "comedy", "cartoon"}));
		comboBox.setBounds(95, 87, 255, 22);
		BackgroundPanel.add(comboBox);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Age Rating :");
		lblNewJgoodiesLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewJgoodiesLabel_3.setBounds(28, 116, 92, 14);
		BackgroundPanel.add(lblNewJgoodiesLabel_3);
		
		 j1 = new JRadioButton("18");
		 j1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(e.getSource()==j1) {
		 			 ageRating=Integer.parseInt(j1.getText());
		 		}
		 	}
		 });
		j1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		j1.setBounds(105, 112, 109, 23);
		BackgroundPanel.add(j1);
		
		 j1_1 = new JRadioButton("16");
		 j1_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(e.getSource()==j1_1) {
		 			 ageRating=Integer.parseInt(j1_1.getText());
		 		}
		 	}
		 });
		j1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		j1_1.setBounds(213, 112, 109, 23);
		BackgroundPanel.add(j1_1);
		
		JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("Type Ticket :");
		lblNewJgoodiesLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewJgoodiesLabel_4.setBounds(28, 141, 92, 14);
		BackgroundPanel.add(lblNewJgoodiesLabel_4);
		
		 comboBox_1 = new JComboBox();
		 comboBox_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(e.getSource()==comboBox_1) {
		 			type=comboBox_1.getSelectedItem().toString();
		 		}
		 	}
		 });
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Choose", "VIP", "Normal"}));
		comboBox_1.setBounds(115, 142, 231, 22);
		BackgroundPanel.add(comboBox_1);
		
		 JLabel lblNewJgoodiesLabel_5 = DefaultComponentFactory.getInstance().createLabel("Place :");
		lblNewJgoodiesLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewJgoodiesLabel_5.setBounds(28, 178, 92, 14);
		BackgroundPanel.add(lblNewJgoodiesLabel_5);
		
		 comboBox_2 = new JComboBox();
		 comboBox_2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(e.getSource()==comboBox_2) {
		 			 Nbreplace=Integer.parseInt(comboBox_2.getSelectedItem().toString());
		 		}
		 	}
		 });
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15","16","17","18"}));
		comboBox_2.setBounds(109, 175, 105, 22);
		BackgroundPanel.add(comboBox_2);
		
		JLabel lblNewJgoodiesLabel_6 = DefaultComponentFactory.getInstance().createLabel("Date et Horaire :");
		lblNewJgoodiesLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewJgoodiesLabel_6.setBounds(24, 219, 122, 14);
		BackgroundPanel.add(lblNewJgoodiesLabel_6);
		
		JLabel lblNewJgoodiesLabel_7 = DefaultComponentFactory.getInstance().createLabel("Date de Projection :");
		lblNewJgoodiesLabel_7.setBounds(24, 244, 122, 14);
		BackgroundPanel.add(lblNewJgoodiesLabel_7);
		
		JLabel lblNewJgoodiesLabel_8 = DefaultComponentFactory.getInstance().createLabel("Horaire :");
		lblNewJgoodiesLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewJgoodiesLabel_8.setBounds(28, 329, 92, 20);
		BackgroundPanel.add(lblNewJgoodiesLabel_8);
		
		 comboBox_3 = new JComboBox();
		 comboBox_3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(e.getSource()==comboBox_3) {
		 			 jour=Integer.parseInt(comboBox_3.getSelectedItem().toString());
		 		}
		 	}
		 });
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"1 ", "2", "3", "4","5","6" ,"7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		comboBox_3.setBounds(28, 296, 47, 22);
		BackgroundPanel.add(comboBox_3);
		
		comboBox_4 = new JComboBox();
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==comboBox_4) {
		 			 mois=comboBox_4.getSelectedItem().toString();
		 		}
			}
		});
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Janvier", "février", "avril", "mai", "juin", "juillet", "août ", "septembre", "octobre", "novembre", "décembre "}));
		comboBox_4.setBounds(95, 296, 92, 22);
		BackgroundPanel.add(comboBox_4);
		
		comboBox_5 = new JComboBox();
		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==comboBox_5) {
		 			année=Integer.parseInt(comboBox_5.getSelectedItem().toString());
		 		}
			}
		});
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] { "2023"}));
		comboBox_5.setBounds(198, 296, 65, 22);
		BackgroundPanel.add(comboBox_5);
		
		comboBox_6 = new JComboBox();
		comboBox_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==comboBox_6) {
		 			 heure=Integer.parseInt(comboBox_6.getSelectedItem().toString());
		 		}
			}
			
		});
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] { "9", "8", "7", "6","4", "3", "2", "1"}));
		comboBox_6.setBounds(28, 374, 65, 22);
		BackgroundPanel.add(comboBox_6);
		
		comboBox_7 = new JComboBox();
		comboBox_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==comboBox_7) {
		 			 minute=Integer.parseInt(comboBox_7.getSelectedItem().toString());
		 		}
			}
		});
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4 ","5","6","7", "8", "9", "10", "11", "12", "13", "14", "15", "16"}));
		comboBox_7.setBounds(132, 374, 82, 22);
		BackgroundPanel.add(comboBox_7);
		
		JButton btnNewButton = new JButton("Reserver");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(501, 404, 89, 23);
		BackgroundPanel.add(btnNewButton);
		JLabel lblNewJgoodiesLabel_9 = DefaultComponentFactory.getInstance().createLabel("Details Ticket :");
		lblNewJgoodiesLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewJgoodiesLabel_9.setBounds(503, 66, 133, 14);
		BackgroundPanel.add(lblNewJgoodiesLabel_9);
		JLabel lblNewJgoodiesLabel_10 = DefaultComponentFactory.getInstance().createLabel("jour");
		lblNewJgoodiesLabel_10.setBounds(24, 269, 47, 14);
		BackgroundPanel.add(lblNewJgoodiesLabel_10);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Mois");
		lblNewJgoodiesTitle.setBounds(95, 267, 92, 14);
		BackgroundPanel.add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesTitle_1 = DefaultComponentFactory.getInstance().createTitle("Année");
		lblNewJgoodiesTitle_1.setBounds(203, 269, 92, 14);
		BackgroundPanel.add(lblNewJgoodiesTitle_1);
		
		JLabel lblNewJgoodiesLabel_11 = DefaultComponentFactory.getInstance().createLabel("heure");
		lblNewJgoodiesLabel_11.setBounds(28, 349, 92, 14);
		BackgroundPanel.add(lblNewJgoodiesLabel_11);
		
		JLabel lblNewJgoodiesLabel_12 = DefaultComponentFactory.getInstance().createLabel("minute");
		lblNewJgoodiesLabel_12.setBounds(141, 349, 92, 14);
		BackgroundPanel.add(lblNewJgoodiesLabel_12);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a.getNbreplaceDispo()<Nbreplace)
				// Override Method
				{JOptionPane.showMessageDialog(null, "Pas de place diponible");
					
					
	         
			}
				else{JOptionPane.showMessageDialog(null, "Reservation successful");}
			}});
				
		
		JButton btnNewButton_1 = new JButton("Confirmer ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(80, 404, 107, 23);
		BackgroundPanel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Age<ageRating ) {
					JOptionPane.showMessageDialog(null, "Vous ne pouvez pas reservez ce film");
					}
				else {
					
				    titre=textField.getText();
				    if (titre.equals("france")) {
				    	Label_13.setIcon(at);
			            
			            }
				    else if (titre.equals("mon roi")) {
			        	  Label_13.setIcon(b);
			            }
				    else  if (titre.equals("Purple Hearsts")) {
			        	  Label_13.setIcon(f);
			              }
				    else  if (titre.equals("SpiderMan1")) {
			        	  Label_13.setIcon(c);
			             }
				    else if (titre.equals("taken")) {
			        	  Label_13.setIcon(d);
			             }
				    else if (titre.equals("the man from toronto")) {
				    	Label_13.setIcon(ee);
			             }
				     z =new film(titre,ageRating,genre);
					 tt=new Date(jour,mois,année);
					  rr=new Horaire(heure,minute);
	                  a=new Reservation(z,type,Nbreplace,tt,rr);
	                  
	                 prix=a.Reservation1(a);
	                 String ls = System.lineSeparator();
	                 textField1.setText(" "+z.getTitre()+ls+z.getGenre()+ls+a.getType()+ls+prix);
	                
	         		}}});
				// Override Method
				
		Label_13 = new JLabel();
		at=new ImageIcon(MainFrame.class.getResource("/cine/download-_6_.jpg"));
		b=new ImageIcon(MainFrame.class.getResource("/cine/download-_7_.png"));
		c=new ImageIcon(MainFrame.class.getResource("/cine/download-_8_.png"));
		d=new ImageIcon(MainFrame.class.getResource("/cine/download-_9_.png"));
		ee=new ImageIcon(MainFrame.class.getResource("/cine/download-_10_.png"));
		f=new ImageIcon(MainFrame.class.getResource("/cine/purple-hearts-netflix.jpg"));
		
		
		Label_13.setBounds(378, 91, 289, 215);
     	BackgroundPanel.add(Label_13);	
     	
		textField1 = new JTextField();
		textField1.setBounds(412, 317, 224, 79);
		BackgroundPanel.add(textField1);
		textField.setColumns(10);
		
		
		
		
		
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre1) {
		titre = titre1;
	}
	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}
}
