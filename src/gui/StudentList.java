package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StudentList {

	private JFrame studentList;
	private JButton SeeAll;
	private JButton search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentList window = new StudentList();
					window.studentList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	Connection conn=null;
	private JTable table;
	private JTextField find;
	public StudentList() {
		initialize();
		conn=DBConnection.dbConnector();
	}
	public void load() {
		try {
			StudentList window = new StudentList();
			window.studentList.setVisible(true);
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
					int seconds = now.get(Calendar.SECOND);
					int minutes=now.get(Calendar.MINUTE);
					int hour=now.get(Calendar.HOUR);
					
					//lblNewLabel_1.setText(hour+":"+minutes+":"+seconds);
					sleep(1000);
					}
				}catch(Exception e){
					
				}
			}
		};
		clock.start();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		studentList = new JFrame();
		studentList.setResizable(false);
		studentList.setTitle("STAFF ");
		studentList.getContentPane().setBackground(new Color(0, 102, 255));
		studentList.setBounds(100, 100, 1023, 577);
		studentList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		studentList.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(12, 31, 212, 461);
		studentList.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(39, 0, 130, 44);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("REGISTER STUDENT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentList.dispose();
				StaffMenu sm = new StaffMenu();
				sm.load();
			}
		});
		btnNewButton.setBounds(12, 172, 188, 25);
		panel.add(btnNewButton);
		
		JButton btnCreateProgramme = new JButton("CREATE PROGRAMME");
		btnCreateProgramme.setBounds(12, 224, 188, 25);
		panel.add(btnCreateProgramme);
		
		JButton btnModifyPrgramme = new JButton("MODIFY PRGRAMME");
		btnModifyPrgramme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModifyPrgramme.setBounds(12, 278, 188, 25);
		panel.add(btnModifyPrgramme);
		
		JButton btnGenerateStudentList = new JButton("STUDENT LIST");
		btnGenerateStudentList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGenerateStudentList.setEnabled(false);
		btnGenerateStudentList.setBounds(12, 330, 188, 25);
		panel.add(btnGenerateStudentList);
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				studentList.dispose();	
				log.run();
			}
		});
		btnNewButton_1.setBounds(39, 424, 117, 25);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(236, 12, 773, 504);
		studentList.getContentPane().add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(12, 120, 749, 372);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		find = new JTextField();
		find.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(find.getText().length()==0){
					search.setEnabled(false);
				}
				else{
					search.setEnabled(true);
				}
			}
		});
		find.setBounds(227, 75, 222, 19);
		panel_1.add(find);
		find.setColumns(10);
		
		JLabel lblProgrammeCode = new JLabel("Programme Code:");
		lblProgrammeCode.setFont(new Font("Dialog", Font.BOLD, 18));
		lblProgrammeCode.setForeground(new Color(255, 255, 255));
		lblProgrammeCode.setBounds(42, 74, 182, 20);
		panel_1.add(lblProgrammeCode);
		
		search = new JButton("GENERATE");
		search.setEnabled(false);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String q = "SELECT * FROM studentinfo WHERE ProgrammeCode=?";
					PreparedStatement pst= conn.prepareStatement(q);
					pst.setString(1,find.getText());
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception err){
					System.out.println(err);
				}
			}
		});
		search.setBounds(461, 72, 117, 25);
		panel_1.add(search);
		
		SeeAll = new JButton("VIEW ALL");
		SeeAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String q = "SELECT * FROM studentinfo";
					PreparedStatement pst= conn.prepareStatement(q);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception err){
					System.out.println(err);
				}
			}
		});
		SeeAll.setBounds(590, 72, 117, 25);
		panel_1.add(SeeAll);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 53, 749, 10);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 109, 749, 10);
		panel_1.add(separator_1);
		
		JLabel lblGenerateStudentList = new JLabel("GENERATE STUDENT LIST");
		lblGenerateStudentList.setFont(new Font("Bitstream Charter", Font.BOLD, 30));
		lblGenerateStudentList.setForeground(new Color(255, 255, 255));
		lblGenerateStudentList.setBounds(186, 12, 377, 29);
		panel_1.add(lblGenerateStudentList);
		JMenuBar menuBar = new JMenuBar();
		studentList.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnAccount = new JMenu("Account Settings");
		menuBar.add(mnAccount);
		
		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		mnAccount.add(mntmChangePassword);
		
		JSeparator separator_6 = new JSeparator();
		mnAccount.add(separator_6);
		
		JMenuItem mntmChangeDepartment = new JMenuItem("Change Department");
		mnAccount.add(mntmChangeDepartment);
		
		JMenuItem mntmChangeFaculty = new JMenuItem("Change Faculty");
		mnAccount.add(mntmChangeFaculty);
		
		JSeparator separator_7 = new JSeparator();
		mnAccount.add(separator_7);
		
		JMenuItem mntmAccountInformation = new JMenuItem("Account Information");
		mnAccount.add(mntmAccountInformation);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
	}
}
