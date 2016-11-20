package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JPanel;


import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import domain.StudentRecords;
import net.proteanit.sql.DbUtils;

public class ProgrammeDetails extends StudentRecords{

	private JTextField progCode;
	private JTextField maxCourses;
	private JTextField stuId;
	private JTextField stuName;
	private String getid; 
	private JFrame student;
	private String name;
	Connection conn=null;
	private JTextField progName;
	private JTextField award;
	private JTextField accreditation;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgrammeDetails window = new ProgrammeDetails();
					window.student.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void live() {
		try {
			ProgrammeDetails window = new ProgrammeDetails();
			window.student.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ProgrammeDetails() {
		initialize();
		clock();
		conn=DBConnection.dbConnector();
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
					int hour=now.get(Calendar.HOUR);*/
					//date.setText(month+"/"+day+"/"+year);
					sleep(1000);
					}
				}catch(Exception e){
					
				}
			}
		};
		clock.start();
	}
	
	private void initialize() {
		student = new JFrame();
		student.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try{
					Login in = new Login();
					String pass = in.getpswrd();
					if(pass.equals("12345678Q")){
						JOptionPane.showMessageDialog(null, "You have logged in with the default password, please change it!");
						ChangePassword cp = new ChangePassword();
						cp.start();
						student.dispose();
						in.run();
					}else{
						try{
							ResultSet rs;
							ResultSet rs2;
							ResultSetMetaData rsmd;
							ResultSetMetaData rsmd2;
							String q = "SELECT * FROM studentinfo WHERE IDNumber=?";
							String q2 = "SELECT * FROM programmeinfo WHERE ProgrammeCode=?";
							PreparedStatement pst= conn.prepareStatement(q);
							PreparedStatement pst2= conn.prepareStatement(q2);
							
							pst.setString(1,getid);
							rs = pst.executeQuery();
							rsmd = rs.getMetaData();
							int columnsNumber = rsmd.getColumnCount();
							String[] loginfo = new String[columnsNumber+1];
							while (rs.next()) {
								for (int i = 1; i <= columnsNumber; i++) {
							         loginfo[i]=rs.getString(i);
							    }
							}
							stuId.setText(loginfo[1]);
							stuName.setText(loginfo[2]+" "+loginfo[3]);
							progCode.setText(loginfo[6]);
						
							pst2.setString(1,progCode.getText());
							rs2 = pst2.executeQuery();
							rsmd2 = rs2.getMetaData();
							int columnsNumber1 = rsmd2.getColumnCount();
							String[] proginfo=new String[columnsNumber1+1];
							while (rs2.next()) {
								for (int i = 1; i <= columnsNumber1; i++) {
									proginfo[i]=rs2.getString(i);
							    }
							}
							progName.setText(proginfo[2]);
							maxCourses.setText(proginfo[3]);
							award.setText(proginfo[4]);
							accreditation.setText(proginfo[5]);
							
						}catch(Exception err){
							System.out.println(err);
						}
					}
				}catch(Exception err){
				
				}
			}
		});
		student.setTitle("STUDENT");
		student.setResizable(false);
		student.getContentPane().setBackground(new Color(0, 102, 255));
		student.setBounds(100, 100, 757, 569);
		student.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		student.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(12, 31, 212, 461);
		student.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("LOGOUT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				student.dispose();	
				log.run();
			}
		});
		btnNewButton.setBounds(41, 424, 117, 25);
		panel.add(btnNewButton);
		
		JLabel label = new JLabel("Welcome");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 24));
		label.setBounds(44, 12, 130, 44);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("person.png"));
		label_1.setBounds(44, 45, 146, 97);
		panel.add(label_1);
		
		JLabel studentName = new JLabel("<dynamic>");
		studentName.setForeground(Color.WHITE);
		studentName.setFont(new Font("Bitstream Charter", Font.BOLD, 18));
		studentName.setBounds(50, 147, 112, 24);
		panel.add(studentName);
		Login in =new Login();
		FileProcess fp = new FileProcess();
		getid = in.getid();
		String[]info = new String[3];
		info=fp.getUserinfo(getid);
		try{
			name=info[0];
		}
		catch(Exception e){
			
		}
		studentName.setText(name);
		
		JButton btnViewProgrammeDetails = new JButton("PROGRAMME DETAILS");
		btnViewProgrammeDetails.setEnabled(false);
		btnViewProgrammeDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProgrammeDetails pd = new ProgrammeDetails();
				pd.live();
				student.dispose();
			}
		});
		btnViewProgrammeDetails.setBounds(12, 238, 188, 25);
		panel.add(btnViewProgrammeDetails);
		
		JButton btnAddCourse = new JButton("ADD COURSE");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentMenu sm = new StudentMenu();
				sm.live();
				student.dispose();
			}
		});
		btnAddCourse.setBounds(12, 183, 188, 25);
		panel.add(btnAddCourse);
		
		JButton btnFeeBreakdown = new JButton("FEE BREAKDOWN");
		btnFeeBreakdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//GenerateFee gf = new GenerateFee();
				//student.dispose();	
				//gf.load();
			}
		});
		btnFeeBreakdown.setBounds(12, 290, 188, 25);
		panel.add(btnFeeBreakdown);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(236, 12, 507, 496);
		student.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEnrolForSemester = new JLabel("ENROL FOR SEMESTER");
		lblEnrolForSemester.setFont(new Font("Bitstream Charter", Font.BOLD, 24));
		lblEnrolForSemester.setForeground(Color.WHITE);
		lblEnrolForSemester.setBounds(131, 12, 273, 28);
		panel_1.add(lblEnrolForSemester);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 52, 483, 2);
		panel_1.add(separator);
		
		JLabel lblNewLabel = new JLabel("PROGRAMME CODE:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(35, 218, 188, 15);
		panel_1.add(lblNewLabel);
		
		progCode = new JTextField();
		progCode.setEditable(false);
		progCode.setBounds(241, 214, 200, 19);
		panel_1.add(progCode);
		progCode.setColumns(10);
		
		JLabel lblName = new JLabel("ID NUMBER:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName.setBounds(87, 67, 114, 15);
		panel_1.add(lblName);
		
		stuId = new JTextField();
		stuId.setEditable(false);
		stuId.setColumns(10);
		stuId.setBounds(225, 66, 200, 19);
		panel_1.add(stuId);
		
		JLabel lblFullName = new JLabel("FULL NAME:");
		lblFullName.setForeground(Color.WHITE);
		lblFullName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFullName.setBounds(87, 98, 132, 15);
		panel_1.add(lblFullName);
		
		stuName = new JTextField();
		stuName.setEditable(false);
		stuName.setColumns(10);
		stuName.setBounds(225, 97, 200, 19);
		panel_1.add(stuName);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 310, 483, 2);
		panel_1.add(separator_1);
		
		JLabel lblCoursesAvailable = new JLabel("COURSES OFFERED");
		lblCoursesAvailable.setForeground(Color.WHITE);
		lblCoursesAvailable.setFont(new Font("Bitstream Charter", Font.BOLD, 20));
		lblCoursesAvailable.setBounds(162, 324, 209, 28);
		panel_1.add(lblCoursesAvailable);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 364, 483, 2);
		panel_1.add(separator_2);
		
		JLabel lblNumberOfCourses = new JLabel("MAX NO. OF COURSES:");
		lblNumberOfCourses.setForeground(Color.WHITE);
		lblNumberOfCourses.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNumberOfCourses.setBounds(35, 280, 216, 15);
		panel_1.add(lblNumberOfCourses);
		
		maxCourses = new JTextField();
		maxCourses.setEditable(false);
		maxCourses.setColumns(10);
		maxCourses.setBounds(241, 279, 200, 19);
		panel_1.add(maxCourses);
		
		JLabel label_2 = new JLabel("PROGRAMME NAME:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Dialog", Font.BOLD, 16));
		label_2.setBounds(35, 251, 188, 15);
		panel_1.add(label_2);
		
		progName = new JTextField();
		progName.setEditable(false);
		progName.setColumns(10);
		progName.setBounds(241, 245, 200, 19);
		panel_1.add(progName);
		
		JLabel lblaward = new JLabel("AWARD:");
		lblaward.setForeground(Color.WHITE);
		lblaward.setFont(new Font("Dialog", Font.BOLD, 16));
		lblaward.setBounds(97, 133, 99, 15);
		panel_1.add(lblaward);
		
		award = new JTextField();
		award.setEditable(false);
		award.setColumns(10);
		award.setBounds(225, 132, 200, 19);
		panel_1.add(award);
		
		JLabel lblAccreditation = new JLabel("ACCREDITATION:");
		lblAccreditation.setForeground(Color.WHITE);
		lblAccreditation.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAccreditation.setBounds(35, 191, 162, 15);
		panel_1.add(lblAccreditation);
		
		accreditation = new JTextField();
		accreditation.setEditable(false);
		accreditation.setColumns(10);
		accreditation.setBounds(241, 183, 200, 19);
		panel_1.add(accreditation);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 169, 483, 2);
		panel_1.add(separator_3);
		
		JMenuBar menuBar = new JMenuBar();
		student.setJMenuBar(menuBar);
		
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
}