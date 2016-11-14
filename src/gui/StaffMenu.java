package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JPanel;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
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
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class StaffMenu{

	private JFrame frmStaffMenu;
	private JTextField fname;
	private JTextField lname;
	private JTextField id;
	private JTextField contact;
	private JTextField add1;
	private JTextField add2;
	private JTextField add3;
	private JTextField date;
	private JTextField enrolstat;
	private JTextField progcode;
	private String name;
	private String depart;
	private String fac;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffMenu window = new StaffMenu();
					window.frmStaffMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn=null;
	private JTextField pass;
	
	public StaffMenu() {
		initialize();
		clock();
		conn=DBConnection.dbConnector();
		
	}
	
	public void load() {
		try {
			StaffMenu window = new StaffMenu();
			window.frmStaffMenu.setVisible(true);
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
					date.setText(month+"/"+day+"/"+year);
					sleep(1000);
					}
				}catch(Exception e){
					
				}
			}
		};
		clock.start();
	}
	public void clear(){
		id.setText("");
		fname.setText("");
		lname.setText("");
		contact.setText("");
		add1.setText("");
		add2.setText("");
		add2.setText("");
		add3.setText("");
		progcode.setText("");
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStaffMenu = new JFrame();
		frmStaffMenu.setTitle("STAFF");
		frmStaffMenu.setResizable(false);
		frmStaffMenu.getContentPane().setBackground(new Color(0, 102, 255));
		frmStaffMenu.setBounds(100, 100, 757, 569);
		frmStaffMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStaffMenu.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(12, 31, 212, 461);
		frmStaffMenu.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(44, 0, 130, 44);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("REGISTER STUDENT");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(12, 171, 188, 25);
		panel.add(btnNewButton);
		
		JButton btnCreateProgramme = new JButton("CREATE PROGRAMME");
		btnCreateProgramme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStaffMenu.dispose();
				CreateProgramme rs = new CreateProgramme();
				rs.load();
			}
		});
		btnCreateProgramme.setBounds(12, 223, 188, 25);
		panel.add(btnCreateProgramme);
		
		JButton btnModifyPrgramme = new JButton("MODIFY PRGRAMME");
		btnModifyPrgramme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModifyPrgramme.setBounds(12, 277, 188, 25);
		panel.add(btnModifyPrgramme);
		
		JButton btnGenerateStudentList = new JButton("STUDENT LIST");
		btnGenerateStudentList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStaffMenu.dispose();
				StudentList sl =new StudentList();
				sl.load();
			}
		});
		btnGenerateStudentList.setBounds(12, 329, 188, 25);
		panel.add(btnGenerateStudentList);
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				frmStaffMenu.dispose();	
				log.run();
			}
		});
		btnNewButton_1.setBounds(44, 424, 117, 25);
		panel.add(btnNewButton_1);
		
		JLabel StaffName = new JLabel("New label");
		StaffName.setFont(new Font("Bitstream Charter", Font.BOLD, 18));
		StaffName.setForeground(Color.WHITE);
		StaffName.setBounds(50, 135, 112, 24);
		panel.add(StaffName);
		Login in =new Login();
		FileProcess fp = new FileProcess();
		String getid = in.getid();
		String[]info = new String[3];
		info=fp.getUserinfo(getid);
		try{
			name=info[0];
			depart=info[1];
			fac=info[2];
		}
		catch(Exception e){
			
		}
		StaffName.setText(name);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("person.png"));
		lblNewLabel_2.setBounds(44, 33, 146, 97);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(236, 12, 507, 496);
		frmStaffMenu.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 191, 93, 15);
		panel_1.add(lblNewLabel_1);
		
		fname = new JTextField();
		fname.setBounds(103, 189, 392, 19);
		panel_1.add(fname);
		fname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setBounds(12, 236, 88, 15);
		panel_1.add(lblLastName);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(103, 234, 392, 19);
		panel_1.add(lname);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(12, 14, 25, 15);
		panel_1.add(lblId);
		
		id = new JTextField();
		id.setEditable(false);
		id.setColumns(10);
		id.setBounds(39, 12, 123, 19);
		panel_1.add(id);
		
		JLabel lblContact = new JLabel("Contact #:");
		lblContact.setForeground(Color.WHITE);
		lblContact.setBounds(12, 301, 93, 15);
		panel_1.add(lblContact);
		
		contact = new JTextField();
		contact.setColumns(10);
		contact.setBounds(103, 299, 392, 19);
		panel_1.add(contact);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setBounds(12, 346, 93, 15);
		panel_1.add(lblAddress);
		
		add1 = new JTextField();
		add1.setColumns(10);
		add1.setBounds(103, 344, 392, 19);
		panel_1.add(add1);
		
		add2 = new JTextField();
		add2.setColumns(10);
		add2.setBounds(103, 375, 392, 19);
		panel_1.add(add2);
		
		add3 = new JTextField();
		add3.setColumns(10);
		add3.setBounds(103, 406, 392, 19);
		panel_1.add(add3);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(481, 277, -468, -24);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 274, 483, 15);
		panel_1.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 34, 483, 15);
		panel_1.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(12, 164, 483, 15);
		panel_1.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(12, 437, 483, 15);
		panel_1.add(separator_4);
		
		JButton btnNewButton_2 = new JButton("REGISTER STUDENT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "INSERT INTO studentinfo(IDNumber,FName,LName,Contact,Address1,Address2,Address3,ProgrammeCode,EnrolStat,DateEnrol)VALUES(?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1,id.getText());
					pst.setString(2, fname.getText());
					pst.setString(3, lname.getText());
					pst.setString(4, contact.getText());
					pst.setString(5, add1.getText());
					pst.setString(6, add2.getText());
					pst.setString(7, add3.getText());
					pst.setString(8, progcode.getText());
					pst.setString(9, enrolstat.getText());
					pst.setString(10, date.getText());
					pst.execute();
					pst.close();
					FileProcess fp = new FileProcess();
					String name = new String(fname.getText()+" "+lname.getText());
					String usr = id.getText();
					String department = "";
					String fac = "";
					String passwrd = new String(pass.getText());
					String confirmPasswrd = new String(pass.getText());
					String type = "STUDENT";
					clear();
					
					fp.validate(name, usr, passwrd, confirmPasswrd, "NO", type,department,fac);
					
					JOptionPane.showMessageDialog(null, "Student Registered!");
				}catch(Exception err){
					System.out.println(err);
				}
			}
		});
		btnNewButton_2.setBounds(131, 448, 311, 25);
		panel_1.add(btnNewButton_2);
		
		JLabel label = new JLabel("Date Enrolled:");
		label.setForeground(Color.WHITE);
		label.setBounds(12, 49, 133, 15);
		panel_1.add(label);
		
		date = new JTextField();
		date.setEditable(false);
		date.setColumns(10);
		date.setBounds(143, 49, 328, 19);
		panel_1.add(date);
		
		JLabel label_1 = new JLabel("Enrolment Status:");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(12, 92, 133, 15);
		panel_1.add(label_1);
		
		enrolstat = new JTextField();
		enrolstat.setEditable(false);
		enrolstat.setText("0");
		enrolstat.setColumns(10);
		enrolstat.setBounds(143, 90, 328, 19);
		panel_1.add(enrolstat);
		
		JLabel label_2 = new JLabel("Programme Code:");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(12, 136, 133, 15);
		panel_1.add(label_2);
		
		progcode = new JTextField();
		progcode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String numOfRecords = null;
				String q="SELECT COUNT(FName) FROM studentinfo";
				try {
					PreparedStatement get = conn.prepareStatement(q);
					ResultSet rs = get.executeQuery();
					Calendar now = new GregorianCalendar();
					int year =now.get(Calendar.YEAR);
					if(rs.next()){
						numOfRecords=rs.getString(1);
						System.out.println(numOfRecords);
					}
					System.out.println("num: "+numOfRecords);
					int count = Integer.parseInt(numOfRecords);
					System.out.println("count: "+count);
					if(count<1){
						id.setText(year%100+"0"+progcode.getText());
						get.close();
					}else
					{
						String a = Integer.toString(count);
						id.setText(year%100+a+progcode.getText());
						get.close();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1);
				}
			}
		});
		progcode.setColumns(10);
		progcode.setBounds(143, 133, 328, 19);
		panel_1.add(progcode);
		
		JLabel lblDefaultPassword = new JLabel("Default Password:");
		lblDefaultPassword.setForeground(Color.WHITE);
		lblDefaultPassword.setBounds(209, 14, 139, 15);
		panel_1.add(lblDefaultPassword);
		
		pass = new JTextField();
		pass.setText("12345678Q");
		pass.setEnabled(false);
		pass.setEditable(false);
		pass.setColumns(10);
		pass.setBounds(348, 12, 123, 19);
		panel_1.add(pass);
		
		JMenuBar menuBar = new JMenuBar();
		frmStaffMenu.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnAccount = new JMenu("Account Settings");
		menuBar.add(mnAccount);
		
		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		mntmChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword cp = new ChangePassword();
				cp.start();
			}
		});
		mnAccount.add(mntmChangePassword);
		
		JSeparator separator_7 = new JSeparator();
		mnAccount.add(separator_7);
		
		JMenuItem mntmAccountInformation = new JMenuItem("Account Information");
		mnAccount.add(mntmAccountInformation);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmSystem = new JMenuItem("Project");
		mntmSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Runtime.getRuntime().exec("CIT2004 - SEM1 - Programming Project 2016-2017.pdf");
				}catch(Exception err){
					try{
						Desktop d = java.awt.Desktop.getDesktop ();
						d.open (new java.io.File ("CIT2004 - SEM1 - Programming Project 2016-2017.pdf"));
					}catch(Exception err2){
						System.out.println(err2);
					}
				}
			}
		});
		mnAbout.add(mntmSystem);
		}
	public void setStaffMenuEnabled(boolean enabled) {
		frmStaffMenu.setEnabled(enabled);
	}
}
