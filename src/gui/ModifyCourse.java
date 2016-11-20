package gui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
//import java.util.Calendar;
//import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import services.DBConnection;
import services.FileProcess;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import domain.CourseRecords;
import domain.ProgrammeRecords;
import domain.StudentRecords;
import net.proteanit.sql.DbUtils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextArea;

public class ModifyCourse extends ProgrammeRecords{

	private JFrame modifycourse;
	private JTextField find;
	private String name;
	private String depart;
	private String fac;
	private String programmeCode;
	private String programmeName;
	private String programmeAward;
	private String programmeAccreditation;
	private String programmemaxCourses;
	private JTextField course2;
	private JTextField course3;
	private JTextField course4;
	private JTextField course1;
	private JTextField course5;
	private JTextField course6;
	private JTextField course7;
	private JTextField course8;
	private JTextField textField_6;
	private JTextField cred1;
	private JTextField cred2;
	private JTextField cred3;
	private JTextField cred4;
	private JTextField cred5;
	private JTextField cred6;
	private JTextField cred7;
	private JTextField cred8;
	private JTextField pre1;
	private JTextField pre2;
	private JTextField pre3;
	private JTextField pre4;
	private JTextField pre5;
	private JTextField pre6;
	private JTextField pre7;
	private JTextField pre8;
	private JTextField cde1;
	private JTextField cde2;
	private JTextField cde3;
	private JTextField cde4;
	private JTextField cde5;
	private JTextField cde6;
	private JTextField cde7;
	private JTextField cde8;
	private JTextField awardtxt;
	private JTextArea description;
	Connection conn=null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyCourse window = new ModifyCourse();
					window.modifycourse.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void load() {
		try {
			ModifyCourse window = new ModifyCourse();
			window.modifycourse.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ModifyCourse() {
		initialize();
		conn=DBConnection.dbConnector();
	}
	
	public ModifyCourse(String code, String name, int maxCourse, String award, String accreditation,CourseRecords course) {
		super(code, name, maxCourse, award, accreditation, course);
	}
	
	public void setEditable(boolean arg){
		course1.setEditable(arg);
		course2.setEditable(arg);
		course3.setEditable(arg);
		course4.setEditable(arg);
		course5.setEditable(arg);
	}
	
	public void clock(){
		Thread clock=new Thread()
		{
			public void run()
			{
				try{
					for(;;){
				/*	Calendar now = new GregorianCalendar();
					int day = now.get(Calendar.DAY_OF_MONTH);
					int month=now.get(Calendar.MONTH);
					int year =now.get(Calendar.YEAR);
					int seconds = now.get(Calendar.SECOND);
					int minutes=now.get(Calendar.MINUTE);
					int hour=now.get(Calendar.HOUR);*/
					
					//lblNewLabel_1.setText(hour+":"+minutes+":"+seconds);
					sleep(1000);
					}
				}catch(Exception e){
					
				}
			}
		};
		clock.start();
	}
	
	public void updateCertificate(String code) {
		try{
			String CourseCode= cde1.getText()+" "+cde2.getText()+" "+cde3.getText()+" "+cde4.getText();
			String CourseName = course1.getText()+" "+course2.getText()+" "+course3.getText()+" "+course4.getText();
			String credit =  cred1.getText()+" "+cred2.getText()+" "+cred3.getText()+" "+cred4.getText();
			int CourseCredit = Integer.parseInt(cred1.getText())+Integer.parseInt(cred2.getText())+Integer.parseInt(cred3.getText())+Integer.parseInt(cred4.getText());
			String CourseDescription = description.getText();
			String CoursePrerequisite = pre1.getText()+" "+ pre2.getText()+" "+ pre3.getText()+" "+ pre4.getText();
			
			CourseRecords course = new CourseRecords(CourseCode,CourseName,CourseDescription,CourseCredit,CoursePrerequisite);
			ProgrammeRecords pr = new ModifyCourse(programmeCode,programmeName,Integer.parseInt(programmemaxCourses),programmeAward,programmeAccreditation,course);
			pr.display();
			
			String[] cName = course.getName().split("\\s");
			String[] cCode = course.getCode().split("\\s");
			String[] cCredit = credit.split("\\s");
			String[] cPrerequisite = course.getPreRequisite().split("\\s");
			
			String query="UPDATE certificate SET CourseName1=?,CourseName2=?,CourseName3=?,CourseName4=?,Code1=?,Code2=?,Code3=?,Code4=?,Credits1=?,Credits2=?,Credits3=?,Credits4=?,Prereq1=?,Prereq2=?,Prereq3=?,Prereq4=?, Description=? WHERE ProgrammeCode=?";
			PreparedStatement pst= conn.prepareStatement(query);
			pst.setString(1,cName[0]);
			pst.setString(2,cName[1]);
			pst.setString(3,cName[2]);
			pst.setString(4,cName[3]);
			pst.setString(5,cCode[0]);
			pst.setString(6,cCode[1]);
			pst.setString(7,cCode[2]);
			pst.setString(8,cCode[3]);
			pst.setString(9,cCredit[0]);
			pst.setString(10,cCredit[1]);
			pst.setString(11,cCredit[2]);
			pst.setString(12,cCredit[3]);	
			pst.setString(13,cPrerequisite[0]);
			pst.setString(14,cPrerequisite[1]);
			pst.setString(15,cPrerequisite[2]);
			pst.setString(16,cPrerequisite[3]);
			pst.setString(17,course.getDescription());
			pst.setString(18, code);
			pst.executeUpdate();
			pst.close();
			
			   
			JOptionPane.showMessageDialog(null, "Courses Sucessfully Update");
		}catch(Exception err){
			System.out.println(err);
		}
	}
	
	public void updateDiploma(String code) {
		try{
			String CourseCode= cde1.getText()+" "+cde2.getText()+" "+cde3.getText()+" "+cde4.getText()+" "+cde5.getText()+" "+cde6.getText();
			String CourseName = course1.getText()+" "+course2.getText()+" "+course3.getText()+" "+course4.getText()+" "+course5.getText()+" "+course6.getText();
			String credit =  cred1.getText()+" "+cred2.getText()+" "+cred3.getText()+" "+cred4.getText()+" "+cred5.getText()+" "+cred6.getText();
			int CourseCredit = Integer.parseInt(cred1.getText())+Integer.parseInt(cred2.getText())+Integer.parseInt(cred3.getText())+Integer.parseInt(cred4.getText())+Integer.parseInt(cred5.getText())+Integer.parseInt(cred6.getText());
			String CourseDescription = description.getText();
			String CoursePrerequisite = pre1.getText()+" "+ pre2.getText()+" "+ pre3.getText()+" "+ pre4.getText()+" "+ pre5.getText()+" "+ pre6.getText();
			
			CourseRecords course = new CourseRecords(CourseCode,CourseName,CourseDescription,CourseCredit,CoursePrerequisite);
			ProgrammeRecords pr = new ModifyCourse(programmeCode,programmeName,Integer.parseInt(programmemaxCourses),programmeAward,programmeAccreditation,course);
			pr.display();
			
			String[] cName = course.getName().split("\\s");
			String[] cCode = course.getCode().split("\\s");
			String[] cCredit = credit.split("\\s");
			String[] cPrerequisite = course.getPreRequisite().split("\\s");
			
			String query="UPDATE diploma SET CourseName1=?,CourseName2=?,CourseName3=?,CourseName4=?,CourseName5=?,CourseName6=?,Code1=?,Code2=?,Code3=?,Code4=?,Code5=?,Code6=?,Credits1=?,Credits2=?,Credits3=?,Credits4=?,Credits5=?,Credits6=?,Prereq1=?,Prereq2=?,Prereq3=?,Prereq4=?,Prereq5=?,Prereq6=?, Description=? WHERE ProgrammeCode=?";
			PreparedStatement pst= conn.prepareStatement(query);
			pst.setString(1,cName[0]);
			pst.setString(2,cName[1]);
			pst.setString(3,cName[2]);
			pst.setString(4,cName[3]);
			pst.setString(5,cName[4]);
			pst.setString(6,cName[5]);
			pst.setString(7,cCode[0]);
			pst.setString(8,cCode[1]);
			pst.setString(9,cCode[2]);
			pst.setString(10,cCode[3]);
			pst.setString(11,cCode[4]);
			pst.setString(12,cCode[5]);
			pst.setString(13,cCredit[0]);
			pst.setString(14,cCredit[1]);
			pst.setString(15,cCredit[2]);
			pst.setString(16,cCredit[3]);
			pst.setString(17,cCredit[4]);
			pst.setString(18,cCredit[5]);
			pst.setString(19,cPrerequisite[0]);
			pst.setString(20,cPrerequisite[1]);
			pst.setString(21,cPrerequisite[2]);
			pst.setString(22,cPrerequisite[3]);
			pst.setString(23,cPrerequisite[4]);
			pst.setString(24,cPrerequisite[5]);
			pst.setString(25,course.getDescription());
			pst.setString(26, code);
			pst.executeUpdate();
			pst.close();
			   
			JOptionPane.showMessageDialog(null, "Courses Sucessfully Update");
		}catch(Exception err){
			System.out.println(err);
		}
	}
	
	public void updateAssociatedegree(String code) {
		try{
			String CourseCode= cde1.getText()+" "+cde2.getText()+" "+cde3.getText()+" "+cde4.getText()+" "+cde5.getText()+" "+cde6.getText()+" "+cde7.getText()+" "+cde8.getText();
			String CourseName = course1.getText()+" "+course2.getText()+" "+course3.getText()+" "+course4.getText()+" "+course5.getText()+" "+course6.getText()+" "+course7.getText()+" "+course8.getText();
			String credit =  cred1.getText()+" "+cred2.getText()+" "+cred3.getText()+" "+cred4.getText()+" "+cred5.getText()+" "+cred6.getText()+" "+cred7.getText()+" "+cred8.getText();
			int CourseCredit = Integer.parseInt(cred1.getText())+Integer.parseInt(cred2.getText())+Integer.parseInt(cred3.getText())+Integer.parseInt(cred4.getText())+Integer.parseInt(cred5.getText())+Integer.parseInt(cred6.getText())+Integer.parseInt(cred7.getText())+Integer.parseInt(cred8.getText());
			String CourseDescription = description.getText();
			String CoursePrerequisite = pre1.getText()+" "+ pre2.getText()+" "+ pre3.getText()+" "+ pre4.getText()+" "+ pre5.getText()+" "+ pre6.getText()+" "+ pre7.getText()+" "+ pre8.getText();
			
			CourseRecords course = new CourseRecords(CourseCode,CourseName,CourseDescription,CourseCredit,CoursePrerequisite);
			ProgrammeRecords pr = new ModifyCourse(programmeCode,programmeName,Integer.parseInt(programmemaxCourses),programmeAward,programmeAccreditation,course);
			pr.display();
			
			String[] cName = course.getName().split("\\s");
			String[] cCode = course.getCode().split("\\s");
			String[] cCredit = credit.split("\\s");
			String[] cPrerequisite = course.getPreRequisite().split("\\s");
			
			String query="UPDATE associatedegree SET CourseName1=?,CourseName2=?,CourseName3=?,CourseName4=?,CourseName5=?,CourseName6=?,CourseName7=?,CourseName8=?,Code1=?,Code2=?,Code3=?,Code4=?,Code5=?,Code6=?,Code7=?,Code8=?,Credits1=?,Credits2=?,Credits3=?,Credits4=?,Credits5=?,Credits6=?,Credits7=?,Credits8=?,Prereq1=?,Prereq2=?,Prereq3=?,Prereq4=?,Prereq5=?,Prereq6=?,Prereq7=?,Prereq8=?, Description=? WHERE ProgrammeCode=?";
			PreparedStatement pst= conn.prepareStatement(query);
			pst.setString(1,cName[0]);
			pst.setString(2,cName[1]);
			pst.setString(3,cName[2]);
			pst.setString(4,cName[3]);
			pst.setString(5,cName[4]);
			pst.setString(6,cName[5]);
			pst.setString(7,cName[6]);
			pst.setString(8,cName[7]);
			pst.setString(9,cCode[0]);
			pst.setString(10,cCode[1]);
			pst.setString(11,cCode[2]);
			pst.setString(12,cCode[3]);
			pst.setString(13,cCode[4]);
			pst.setString(14,cCode[5]);
			pst.setString(15,cCode[6]);
			pst.setString(16,cCode[7]);
			pst.setString(17,cCredit[0]);
			pst.setString(18,cCredit[1]);
			pst.setString(19,cCredit[2]);
			pst.setString(20,cCredit[3]);
			pst.setString(21,cCredit[4]);
			pst.setString(22,cCredit[5]);
			pst.setString(23,cCredit[6]);
			pst.setString(24,cCredit[7]);
			pst.setString(25,cPrerequisite[0]);
			pst.setString(26,cPrerequisite[1]);
			pst.setString(27,cPrerequisite[2]);
			pst.setString(28,cPrerequisite[3]);
			pst.setString(29,cPrerequisite[4]);
			pst.setString(30,cPrerequisite[5]);
			pst.setString(31,cPrerequisite[6]);
			pst.setString(32,cPrerequisite[7]);
			pst.setString(33,course.getDescription());
			pst.setString(34, code);
			pst.executeUpdate();
			pst.close();
			   
			JOptionPane.showMessageDialog(null, "Courses Sucessfully Update");
		}catch(Exception err){
			System.out.println(err);
		}
	}
	
	
	public void loadCertificate(String code){
		try {
	        String q = "SELECT * FROM certificate WHERE ProgrammeCode =?";
	        PreparedStatement pst=conn.prepareStatement(q);
	        pst.setString(1, code);
	        ResultSet rs = pst.executeQuery();
	        
		    if(rs.next()) { 
		    	String des = rs.getString("Description");
		    	description.setText(des);
		        String c1 = rs.getString("CourseName1");
		        course1.setText(c1);
		        String c2 = rs.getString("CourseName2");
		        course2.setText(c2);
		        String c3 = rs.getString("CourseName3");
		        course3.setText(c3);
		        String c4 = rs.getString("CourseName4");
		        course4.setText(c4);
		        String cd1 = rs.getString("Credits1");
		        cred1.setText(cd1);
		        String cd2 = rs.getString("Credits2");
		        cred2.setText(cd2);
		        String cd3 = rs.getString("Credits3");
		        cred3.setText(cd3);
		        String cd4 = rs.getString("Credits4");
		        cred4.setText(cd4);
		        String p1 = rs.getString("Prereq1");
		        pre1.setText(p1);
		        String p2 = rs.getString("Prereq2");
		        pre2.setText(p2);
		        String p3 = rs.getString("Prereq3");
		        pre3.setText(p3);
		        String p4 = rs.getString("Prereq4");
		        pre4.setText(p4);
		        String Ccode1 = rs.getString("Code1");
		        cde1.setText(Ccode1);
		        String Ccode2 = rs.getString("Code2");
		        cde2.setText(Ccode2);
		        String Ccode3 = rs.getString("Code3");
		        cde3.setText(Ccode3);
		        String Ccode4 = rs.getString("Code4");
		        cde4.setText(Ccode4);
		        pst.close();
		    }else{
		    	 cred1.setText("0");
		    	 cred2.setText("0");
		    	 cred3.setText("0");
		    	 cred4.setText("0");
		    }
		    cred5.setEnabled(false);
	        cred6.setEnabled(false);
	        cred7.setEnabled(false);
	        cred8.setEnabled(false);
	        cde5.setEnabled(false);
	        cde6.setEnabled(false);
	        cde7.setEnabled(false);
	        cde8.setEnabled(false);
	        pre5.setEnabled(false);
	        pre6.setEnabled(false);
	        pre7.setEnabled(false);
	        pre8.setEnabled(false);
	        cred8.setEnabled(false);
	        course5.setEnabled(false);
	        course6.setEnabled(false);
	        course7.setEnabled(false);
	        course8.setEnabled(false);
	    }catch(SQLException e ) {
	    	JOptionPane.showMessageDialog(null, e);
	    }
	}
	
	public void loadDiploma(String code){
		try {
	        String q = "SELECT * FROM diploma WHERE ProgrammeCode =?";
	        PreparedStatement pst=conn.prepareStatement(q);
	        pst.setString(1, code);
	        ResultSet rs = pst.executeQuery();
	        
		    if(rs.next()) {
		    	String des = rs.getString("Description");
		    	description.setText(des);
		        String c1 = rs.getString("CourseName1");
		        course1.setText(c1);
		        String c2 = rs.getString("CourseName2");
		        course2.setText(c2);
		        String c3 = rs.getString("CourseName3");
		        course3.setText(c3);
		        String c4 = rs.getString("CourseName4");
		        course4.setText(c4);
		        String c5 = rs.getString("CourseName5");
		        course5.setText(c5);
		        String c6 = rs.getString("CourseName6");
		        course6.setText(c6);
		        String cd1 = rs.getString("Credits1");
		        cred1.setText(cd1);
		        String cd2 = rs.getString("Credits2");
		        cred2.setText(cd2);
		        String cd3 = rs.getString("Credits3");
		        cred3.setText(cd3);
		        String cd4 = rs.getString("Credits4");
		        cred4.setText(cd4);
		        String cd5 = rs.getString("Credits5");
		        cred5.setText(cd5);
		        String cd6 = rs.getString("Credits6");
		        cred6.setText(cd6);
		        String p1 = rs.getString("Prereq1");
		        pre1.setText(p1);
		        String p2 = rs.getString("Prereq2");
		        pre2.setText(p2);
		        String p3 = rs.getString("Prereq3");
		        pre3.setText(p3);
		        String p4 = rs.getString("Prereq4");
		        pre4.setText(p4);
		        String p5 = rs.getString("Prereq5");
		        pre5.setText(p5);
		        String p6 = rs.getString("Prereq6");
		        pre6.setText(p6);
		        String Ccode1 = rs.getString("Code1");
		        cde1.setText(Ccode1);
		        String Ccode2 = rs.getString("Code2");
		        cde2.setText(Ccode2);
		        String Ccode3 = rs.getString("Code3");
		        cde3.setText(Ccode3);
		        String Ccode4 = rs.getString("Code4");
		        cde4.setText(Ccode4);
		        String Ccode5 = rs.getString("Code5");
		        cde5.setText(Ccode5);
		        String Ccode6 = rs.getString("Code6");
		        cde6.setText(Ccode6);
		        pst.close();
		    } else{
		    	 cred1.setText("0");
		    	 cred2.setText("0");
		    	 cred3.setText("0");
		    	 cred4.setText("0");
		    	 cred5.setText("0");
		    	 cred6.setText("0");
		    }
		    cde7.setEnabled(false);
	        cde8.setEnabled(false);
	        pre7.setEnabled(false);
	        pre8.setEnabled(false);
	        cred7.setEnabled(false);
	        cred8.setEnabled(false);
	        course7.setEnabled(false);
	        course8.setEnabled(false);
	    }catch(SQLException e ) {
	    	JOptionPane.showMessageDialog(null, e);
	    }
	}
	public void loadAssociate(String code){
		try {
	        String q = "SELECT * FROM associatedegree WHERE ProgrammeCode =?";
	        PreparedStatement pst=conn.prepareStatement(q);
	        pst.setString(1, code);
	        ResultSet rs = pst.executeQuery();
	        
		    if(rs.next()) { 
		    	String des = rs.getString("Description");
		    	description.setText(des);
		        String c1 = rs.getString("CourseName1");
		        course1.setText(c1);
		        String c2 = rs.getString("CourseName2");
		        course2.setText(c2);
		        String c3 = rs.getString("CourseName3");
		        course3.setText(c3);
		        String c4 = rs.getString("CourseName4");
		        course4.setText(c4);
		        String c5 = rs.getString("CourseName5");
		        course5.setText(c5);
		        String c6 = rs.getString("CourseName6");
		        course6.setText(c6);
		        String c7 = rs.getString("CourseName7");
		        course7.setText(c7);
		        String c8 = rs.getString("CourseName8");
		        course8.setText(c8);
		        String cd1 = rs.getString("Credits1");
		        cred1.setText(cd1);
		        String cd2 = rs.getString("Credits2");
		        cred2.setText(cd2);
		        String cd3 = rs.getString("Credits3");
		        cred3.setText(cd3);
		        String cd4 = rs.getString("Credits4");
		        cred4.setText(cd4);
		        String cd5 = rs.getString("Credits5");
		        cred5.setText(cd5);
		        String cd6 = rs.getString("Credits6");
		        cred6.setText(cd6);
		        String cd7 = rs.getString("Credits7");
		        cred7.setText(cd7);
		        String cd8 = rs.getString("Credits8");
		        cred8.setText(cd8);
		        String p1 = rs.getString("Prereq1");
		        pre1.setText(p1);
		        String p2 = rs.getString("Prereq2");
		        pre2.setText(p2);
		        String p3 = rs.getString("Prereq3");
		        pre3.setText(p3);
		        String p4 = rs.getString("Prereq4");
		        pre4.setText(p4);
		        String p5 = rs.getString("Prereq5");
		        pre5.setText(p5);
		        String p6 = rs.getString("Prereq6");
		        pre6.setText(p6);
		        String p7 = rs.getString("Prereq7");
		        pre7.setText(p7);
		        String p8 = rs.getString("Prereq8");
		        pre8.setText(p8);
		        String Ccode1 = rs.getString("Code1");
		        cde1.setText(Ccode1);
		        String Ccode2 = rs.getString("Code2");
		        cde2.setText(Ccode2);
		        String Ccode3 = rs.getString("Code3");
		        cde3.setText(Ccode3);
		        String Ccode4 = rs.getString("Code4");
		        cde4.setText(Ccode4);
		        String Ccode5 = rs.getString("Code5");
		        cde5.setText(Ccode5);
		        String Ccode6 = rs.getString("Code6");
		        cde6.setText(Ccode6);
		        String Ccode7 = rs.getString("Code7");
		        cde7.setText(Ccode7);
		        String Ccode8 = rs.getString("Code8");
		        cde8.setText(Ccode8);
		        pst.close();
		    }else{
		    	 cred1.setText("0");
		    	 cred2.setText("0");
		    	 cred3.setText("0");
		    	 cred4.setText("0");
		    	 cred5.setText("0");
		    	 cred6.setText("0");
		    	 cred7.setText("0");
		    	 cred8.setText("0");
		    }
	    }catch(SQLException e ) {
	    	JOptionPane.showMessageDialog(null, e);
	    }
	}
	
	private void initialize() {
		modifycourse = new JFrame();
		modifycourse.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ModifyProgramme mp = new ModifyProgramme();
				programmeName=mp.getProgrammename();
				programmemaxCourses=mp.getProgrammemaxcourses();
				programmeAccreditation=mp.getProgrammeaccreditation();
				programmeAward = mp.getProgrammeaward();
				programmeCode = mp.getProgrammecode();
				find.setText(programmeCode);
				awardtxt.setText(programmeAward);
				if(programmeAward.equals("Diploma")){
					loadDiploma(programmeCode);
				}else{
					if(programmeAward.equals("Certificate")){
						loadCertificate(programmeCode);
					}else{
						if(programmeAward.equals("Associate Degree")){
							loadAssociate(programmeCode);
						}else{
							 JOptionPane.showMessageDialog(null, "Invalid Award!!");
							 mp.load();
							 modifycourse.dispose();
						}
					}
				}
			}
		});
		modifycourse.setResizable(false);
		modifycourse.setTitle("STAFF ");
		modifycourse.getContentPane().setBackground(new Color(0, 102, 255));
		modifycourse.setBounds(100, 100, 942, 616);
		modifycourse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		modifycourse.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(12, 31, 212, 484);
		modifycourse.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(39, 0, 130, 44);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("REGISTER STUDENT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifycourse.dispose();
				StaffMenu sm = new StaffMenu();
				sm.load();
			}
		});
		btnNewButton.setBounds(12, 172, 188, 25);
		panel.add(btnNewButton);
		
		JButton btnCreateProgramme = new JButton("CREATE PROGRAMME");
		btnCreateProgramme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifycourse.dispose();
				CreateProgramme rs = new CreateProgramme();
				rs.load();
			}
		});
		btnCreateProgramme.setBounds(12, 224, 188, 25);
		panel.add(btnCreateProgramme);
		
		JButton btnModifyPrgramme = new JButton("MODIFY PRGRAMME");
		btnModifyPrgramme.setEnabled(false);
		btnModifyPrgramme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModifyPrgramme.setBounds(12, 278, 188, 25);
		panel.add(btnModifyPrgramme);
		
		JButton btnGenerateStudentList = new JButton("STUDENT LIST");
		btnGenerateStudentList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentList sl = new StudentList();
				modifycourse.dispose();
				sl.load();
			}
		});
		btnGenerateStudentList.setBounds(12, 330, 188, 25);
		panel.add(btnGenerateStudentList);
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				modifycourse.dispose();	
				log.run();
			}
		});
		btnNewButton_1.setBounds(39, 447, 117, 25);
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
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(236, 12, 690, 542);
		modifycourse.getContentPane().add(panel_1);
		
		find = new JTextField();
		find.setEditable(false);
		find.setBounds(194, 75, 167, 19);
		panel_1.add(find);
		find.setColumns(10);
		
		JLabel lblProgrammeCode = new JLabel("Programme Code:");
		lblProgrammeCode.setFont(new Font("Dialog", Font.BOLD, 18));
		lblProgrammeCode.setForeground(new Color(255, 255, 255));
		lblProgrammeCode.setBounds(12, 73, 182, 20);
		panel_1.add(lblProgrammeCode);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 53, 663, 10);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 106, 663, 13);
		panel_1.add(separator_1);
		
		JLabel lblGenerateStudentList = new JLabel("COURSE MODIFICATION");
		lblGenerateStudentList.setFont(new Font("Bitstream Charter", Font.BOLD, 30));
		lblGenerateStudentList.setForeground(new Color(255, 255, 255));
		lblGenerateStudentList.setBounds(159, 12, 364, 29);
		panel_1.add(lblGenerateStudentList);
		
		course2 = new JTextField();
		course2.setColumns(10);
		course2.setBounds(122, 260, 143, 19);
		panel_1.add(course2);
		
		course3 = new JTextField();
		course3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try{
					String numOfRecords = null;
					String q="SELECT COUNT(ProgrammeCode) FROM programmeinfo WHERE ProgrammeCode=?";
					PreparedStatement get = conn.prepareStatement(q);
					get.setString(1,course3.getText());
					ResultSet rs = get.executeQuery();
					if(rs.next()){
						numOfRecords=rs.getString(1);
						System.out.println(numOfRecords);
					}
					if(Integer.parseInt(numOfRecords)==1&& find.getText().equals(course3.getText())==false){
						get.close();
						JOptionPane.showMessageDialog(null, course3.getText()+" Already Exists");
						course3.setText(find.getText());
					}
				}catch(Exception err){
					System.out.println(err);
				}
			
			}
		});
		course3.setColumns(10);
		course3.setBounds(122, 289, 143, 19);
		panel_1.add(course3);
		
		course4 = new JTextField();
		course4.setColumns(10);
		course4.setBounds(122, 322, 143, 19);
		panel_1.add(course4);
		
		course1 = new JTextField();
		course1.setColumns(10);
		course1.setBounds(122, 227, 143, 19);
		panel_1.add(course1);
		
		course5 = new JTextField();
		course5.setColumns(10);
		course5.setBounds(122, 355, 143, 19);
		panel_1.add(course5);
		
		JButton btnDelete = new JButton("UPDATE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(course8.getText().equals("")||cred8.getText().equals("")||cde8.getText().equals("")||pre8.getText().equals("")){
					course8.setText("-");
					cde8.setText("-");
					pre8.setText("-");
					cred8.setText("0");
				}
				if(course6.getText().length()==0 ||cred6.getText().length()==0||cde6.getText().equals("")||pre6.getText().length()==0){
					course6.setText("-");
					cde6.setText("-");
					pre6.setText("-");
					cred6.setText("0");
				}
				
				if(course4.getText().equals("")||cred4.getText().equals("")||cde4.getText().equals("")||pre4.getText().equals("")){
					course4.setText("-");
					cde4.setText("-");
					pre4.setText("-");
					cred4.setText("0");
				}
				if(awardtxt.getText().equals("Certificate")){
					
					updateCertificate(find.getText());
				}else{
					if(awardtxt.getText().equals("Diploma")){
						updateDiploma(find.getText());
					}else{
						if(awardtxt.getText().equals("Associate Degree")){
							updateAssociatedegree(find.getText());
						}
					}
				}
			}
		});
		btnDelete.setBounds(122, 494, 198, 36);
		panel_1.add(btnDelete);
		
		JButton btnAddCourses = new JButton("BACK");
		btnAddCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyProgramme pm = new ModifyProgramme();
				pm.load();
				modifycourse.dispose();
			}
		});
		btnAddCourses.setBounds(364, 494, 198, 36);
		panel_1.add(btnAddCourses);
		
		JLabel lblCourses = new JLabel("COURSES");
		lblCourses.setForeground(Color.WHITE);
		lblCourses.setFont(new Font("Bitstream Charter", Font.BOLD, 21));
		lblCourses.setBounds(144, 199, 108, 29);
		panel_1.add(lblCourses);
		
		JLabel lblCredits = new JLabel("CREDITS");
		lblCredits.setForeground(Color.WHITE);
		lblCredits.setFont(new Font("Bitstream Charter", Font.BOLD, 21));
		lblCredits.setBounds(293, 199, 108, 29);
		panel_1.add(lblCredits);
		
		course6 = new JTextField();
		course6.setColumns(10);
		course6.setBounds(122, 382, 143, 19);
		panel_1.add(course6);
		
		course7 = new JTextField();
		course7.setColumns(10);
		course7.setBounds(122, 415, 143, 19);
		panel_1.add(course7);
		
		course8 = new JTextField();
		course8.setColumns(10);
		course8.setBounds(122, 444, 143, 19);
		panel_1.add(course8);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(0, 566, 222, 19);
		panel_1.add(textField_6);
		
		cred1 = new JTextField();
		cred1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(cred1.getText().length()==0){
					cred1.setText("0");
				}
			}
		});
		cred1.setHorizontalAlignment(SwingConstants.LEFT);
		cred1.setColumns(10);
		cred1.setBounds(301, 227, 60, 19);
		panel_1.add(cred1);
		
		cred2 = new JTextField();
		cred2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(cred2.getText().length()==0){
					cred2.setText("0");
				}
			}
		});
		cred2.setColumns(10);
		cred2.setBounds(301, 260, 60, 19);
		panel_1.add(cred2);
		
		cred3 = new JTextField();
		cred3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(cred3.getText().length()==0){
					cred3.setText("0");
				}
			}
		});
		cred3.setColumns(10);
		cred3.setBounds(301, 289, 60, 19);
		panel_1.add(cred3);
		
		cred4 = new JTextField();
		cred4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(cred4.getText().length()==0){
					cred4.setText("0");
				}
			}
		});
		cred4.setColumns(10);
		cred4.setBounds(301, 322, 60, 19);
		panel_1.add(cred4);
		
		cred5 = new JTextField();
		cred5.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(cred5.getText().length()==0){
					cred5.setText("0");
				}
			}
		});
		cred5.setColumns(10);
		cred5.setBounds(301, 355, 60, 19);
		panel_1.add(cred5);
		
		cred6 = new JTextField();
		cred6.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(cred6.getText().length()==0){
					cred6.setText("0");
				}
			}
		});
		cred6.setColumns(10);
		cred6.setBounds(301, 382, 60, 19);
		panel_1.add(cred6);
		
		cred7 = new JTextField();
		cred7.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(cred7.getText().length()==0){
					cred7.setText("0");
				}
			}
		});
		cred7.setColumns(10);
		cred7.setBounds(301, 415, 60, 19);
		panel_1.add(cred7);
		
		cred8 = new JTextField();
		cred8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(cred8.getText().length()==0){
					cred8.setText("0");
				}
			}
		});
		cred8.setColumns(10);
		cred8.setBounds(301, 444, 60, 19);
		panel_1.add(cred8);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(394, 210, 7, 253);
		panel_1.add(separator_4);
		
		JLabel lblPrerequistes = new JLabel("PRE-REQUISTES");
		lblPrerequistes.setForeground(Color.WHITE);
		lblPrerequistes.setFont(new Font("Bitstream Charter", Font.BOLD, 21));
		lblPrerequistes.setBounds(452, 199, 182, 29);
		panel_1.add(lblPrerequistes);
		
		pre1 = new JTextField();
		pre1.setColumns(10);
		pre1.setBounds(431, 227, 222, 19);
		panel_1.add(pre1);
		
		pre2 = new JTextField();
		pre2.setColumns(10);
		pre2.setBounds(431, 260, 222, 19);
		panel_1.add(pre2);
		
		pre3 = new JTextField();
		pre3.setColumns(10);
		pre3.setBounds(431, 289, 222, 19);
		panel_1.add(pre3);
		
		pre4 = new JTextField();
		pre4.setColumns(10);
		pre4.setBounds(431, 322, 222, 19);
		panel_1.add(pre4);
		
		pre5 = new JTextField();
		pre5.setColumns(10);
		pre5.setBounds(431, 355, 222, 19);
		panel_1.add(pre5);
		
		pre6 = new JTextField();
		pre6.setColumns(10);
		pre6.setBounds(431, 382, 222, 19);
		panel_1.add(pre6);
		
		pre7 = new JTextField();
		pre7.setColumns(10);
		pre7.setBounds(431, 415, 222, 19);
		panel_1.add(pre7);
		
		pre8 = new JTextField();
		pre8.setColumns(10);
		pre8.setBounds(431, 444, 222, 19);
		panel_1.add(pre8);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(12, 186, 663, 13);
		panel_1.add(separator_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(176, 117, 499, 57);
		panel_1.add(scrollPane);
		
		description = new JTextArea();
		scrollPane.setViewportView(description);
		description.setWrapStyleWord(true);
		description.setTabSize(5);
		description.setRows(10);
		description.setLineWrap(true);
		
		JLabel lblDescription = new JLabel("DESCRIPTION:");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Bitstream Charter", Font.BOLD, 21));
		lblDescription.setBounds(12, 131, 162, 29);
		panel_1.add(lblDescription);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(15, 477, 663, 13);
		panel_1.add(separator_2);
		
		cde1 = new JTextField();
		cde1.setColumns(10);
		cde1.setBounds(30, 227, 60, 19);
		panel_1.add(cde1);
		
		cde2 = new JTextField();
		cde2.setColumns(10);
		cde2.setBounds(30, 260, 60, 19);
		panel_1.add(cde2);
		
		cde3 = new JTextField();
		cde3.setColumns(10);
		cde3.setBounds(30, 289, 60, 19);
		panel_1.add(cde3);
		
		cde4 = new JTextField();
		cde4.setColumns(10);
		cde4.setBounds(30, 322, 60, 19);
		panel_1.add(cde4);
		
		cde5 = new JTextField();
		cde5.setColumns(10);
		cde5.setBounds(30, 355, 60, 19);
		panel_1.add(cde5);
		
		cde6 = new JTextField();
		cde6.setColumns(10);
		cde6.setBounds(30, 382, 60, 19);
		panel_1.add(cde6);
		
		cde7 = new JTextField();
		cde7.setColumns(10);
		cde7.setBounds(30, 415, 60, 19);
		panel_1.add(cde7);
		
		cde8 = new JTextField();
		cde8.setColumns(10);
		cde8.setBounds(30, 444, 60, 19);
		panel_1.add(cde8);
		
		JLabel lblCodes = new JLabel("CODES");
		lblCodes.setForeground(Color.WHITE);
		lblCodes.setFont(new Font("Bitstream Charter", Font.BOLD, 21));
		lblCodes.setBounds(24, 199, 108, 29);
		panel_1.add(lblCodes);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(102, 210, 7, 253);
		panel_1.add(separator_3);
		
		JLabel lblAward = new JLabel("Award:");
		lblAward.setForeground(Color.WHITE);
		lblAward.setFont(new Font("Dialog", Font.BOLD, 18));
		lblAward.setBounds(384, 73, 98, 20);
		panel_1.add(lblAward);
		
		awardtxt = new JTextField();
		awardtxt.setEditable(false);
		awardtxt.setColumns(10);
		awardtxt.setBounds(469, 75, 206, 19);
		panel_1.add(awardtxt);
		JMenuBar menuBar = new JMenuBar();
		modifycourse.setJMenuBar(menuBar);
		
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
		
		JMenu mnNewMenu = new JMenu("About");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmProject = new JMenuItem("Project");
		mntmProject.addActionListener(new ActionListener() {
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
		mnNewMenu.add(mntmProject);
	}
}