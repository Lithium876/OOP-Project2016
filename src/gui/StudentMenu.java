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

public class StudentMenu extends StudentRecords{

	private JTextField stuProgramme;
	private JTextField maxCourses;
	private JTextField stuId;
	private JTextField stuName;
	private JTextField stuEnrolstat;
	private JTextField stuEnroldate;
	private String getid; 
	private JFrame student;
	private String name;
	Connection conn=null;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMenu window = new StudentMenu();
					window.student.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void live() {
		try {
			StudentMenu window = new StudentMenu();
			window.student.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public StudentMenu() {
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
							stuProgramme.setText(loginfo[6]);
							stuEnrolstat.setText(loginfo[7]);
							stuEnroldate.setText(loginfo[8]);
						
							pst2.setString(1,stuProgramme.getText());
							rs2 = pst2.executeQuery();
							rsmd2 = rs2.getMetaData();
							int columnsNumber1 = rsmd2.getColumnCount();
							String[] proginfo=new String[columnsNumber1+1];
							while (rs2.next()) {
								for (int i = 1; i <= columnsNumber1; i++) {
									proginfo[i]=rs2.getString(i);
							        //System.out.print(proginfo[i]+"\n");
							    }
							}
							maxCourses.setText(proginfo[3]);
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
		btnAddCourse.setEnabled(false);
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
		
		JLabel lblNewLabel = new JLabel("PROGRAMME:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(82, 132, 132, 15);
		panel_1.add(lblNewLabel);
		
		stuProgramme = new JTextField();
		stuProgramme.setEditable(false);
		stuProgramme.setBounds(226, 128, 200, 19);
		panel_1.add(stuProgramme);
		stuProgramme.setColumns(10);
		
		JLabel lblName = new JLabel("ID NUMBER:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblName.setBounds(82, 67, 114, 15);
		panel_1.add(lblName);
		
		stuId = new JTextField();
		stuId.setEditable(false);
		stuId.setColumns(10);
		stuId.setBounds(226, 66, 200, 19);
		panel_1.add(stuId);
		
		JLabel lblFullName = new JLabel("FULL NAME:");
		lblFullName.setForeground(Color.WHITE);
		lblFullName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFullName.setBounds(82, 102, 132, 15);
		panel_1.add(lblFullName);
		
		stuName = new JTextField();
		stuName.setEditable(false);
		stuName.setColumns(10);
		stuName.setBounds(226, 97, 200, 19);
		panel_1.add(stuName);
		
		JLabel lblEnrollmentStatus = new JLabel("ENROL STATUS: ");
		lblEnrollmentStatus.setForeground(Color.WHITE);
		lblEnrollmentStatus.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnrollmentStatus.setBounds(82, 163, 158, 15);
		panel_1.add(lblEnrollmentStatus);
		
		stuEnrolstat = new JTextField();
		stuEnrolstat.setEditable(false);
		stuEnrolstat.setColumns(10);
		stuEnrolstat.setBounds(226, 159, 200, 19);
		panel_1.add(stuEnrolstat);
		
		JLabel lblEnrolDate = new JLabel("ENROL DATE: ");
		lblEnrolDate.setForeground(Color.WHITE);
		lblEnrolDate.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnrolDate.setBounds(82, 191, 158, 15);
		panel_1.add(lblEnrolDate);
		
		stuEnroldate = new JTextField();
		stuEnroldate.setEditable(false);
		stuEnroldate.setColumns(10);
		stuEnroldate.setBounds(226, 187, 200, 19);
		panel_1.add(stuEnroldate);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 246, 483, 2);
		panel_1.add(separator_1);
		
		JLabel lblCoursesAvailable = new JLabel("COURSES AVAILABLE");
		lblCoursesAvailable.setForeground(Color.WHITE);
		lblCoursesAvailable.setFont(new Font("Bitstream Charter", Font.BOLD, 20));
		lblCoursesAvailable.setBounds(150, 256, 209, 28);
		panel_1.add(lblCoursesAvailable);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 283, 483, 2);
		panel_1.add(separator_2);
		
		JLabel lblNumberOfCourses = new JLabel("MAX NO. OF COURSES:");
		lblNumberOfCourses.setForeground(Color.WHITE);
		lblNumberOfCourses.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNumberOfCourses.setBounds(82, 219, 216, 15);
		panel_1.add(lblNumberOfCourses);
		
		maxCourses = new JTextField();
		maxCourses.setEditable(false);
		maxCourses.setColumns(10);
		maxCourses.setBounds(294, 218, 132, 19);
		panel_1.add(maxCourses);
		
		JMenuBar menuBar = new JMenuBar();
		student.setJMenuBar(menuBar);
		
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
}