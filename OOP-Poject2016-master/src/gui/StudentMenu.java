package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import services.DBConnection;
import services.FileProcess;

import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.sql.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;


public class StudentMenu{

	private JFrame studentMenu;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMenu window = new StudentMenu();
					window.studentMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn=null;
	private JTable table;
	
	public StudentMenu() {
		initialize();
		clock();
		conn=DBConnection.dbConnector();
		
	}
	public void load() {
		try {
			StudentMenu window = new StudentMenu();
			window.studentMenu.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void live() {
		try {
			StudentMenu window = new StudentMenu();
			window.studentMenu.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clock(){
		Thread clock=new Thread()
		{
			public void run()
			{
				try{
					for(;;){
					Calendar now = new GregorianCalendar();
					int day = now.get(Calendar.DAY_OF_MONTH);
					int month=now.get(Calendar.MONTH);
					int year =now.get(Calendar.YEAR);
					/*int seconds = now.get(Calendar.SECOND);
					int minutes=now.get(Calendar.MINUTE);
					int hour=now.get(Calendar.HOUR);
			*/
					//date.setText(month+"/"+day+"/"+year);
					sleep(1000);
					}
				}catch(Exception e){
					
				}
			}
		};
		clock.start();
	}
	public void clear(){
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		studentMenu = new JFrame();
		studentMenu.setTitle("STAFF MENU");
		studentMenu.setResizable(false);
		studentMenu.getContentPane().setBackground(new Color(0, 102, 255));
		studentMenu.setBounds(100, 100, 757, 476);
		studentMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		studentMenu.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(12, 12, 212, 421);
		studentMenu.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(39, 0, 130, 44);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("View Program Details");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(12, 143, 188, 25);
		panel.add(btnNewButton);
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				studentMenu.dispose();
				AddCourse ad = new AddCourse();
				ad.load();
			}
		});
		btnAddCourse.setBounds(12, 195, 188, 25);
		panel.add(btnAddCourse);
		
		JButton btnGenerateFee = new JButton("Generate Fee Breakdown");
		btnGenerateFee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerateFee gf = new GenerateFee();
				studentMenu.dispose();	
				gf.load();
				
			}
		});
		btnGenerateFee.setBounds(12, 249, 188, 25);
		panel.add(btnGenerateFee);
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				studentMenu.dispose();	
				log.run();
			}
		});
		btnNewButton_1.setBounds(39, 384, 117, 25);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(236, 35, 507, 375);
		studentMenu.getContentPane().add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 125, 370, 200);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Load Courses");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Used to generate the CourseTable from the database and display it in the jtable
				// its not working because its layout so just insert the exact table name in the database
				try{
					String query="Select * from CourseRecords";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					
				}
				
			}
		});
		btnNewButton_2.setBounds(194, 85, 125, 25);
		panel_1.add(btnNewButton_2);
		
		JLabel lblProgramDetails = new JLabel("Program Details");
		lblProgramDetails.setFont(new Font("Dialog", Font.BOLD, 20));
		lblProgramDetails.setForeground(Color.WHITE);
		lblProgramDetails.setBounds(180, 13, 161, 25);
		panel_1.add(lblProgramDetails);
		
	}	
}
