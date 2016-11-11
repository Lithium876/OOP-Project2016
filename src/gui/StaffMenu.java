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

import domain.StudentRecords;

import javax.swing.JSeparator;

public class StaffMenu {

	private JFrame frmStaffMenu;
	private JTextField fname;
	private JTextField lname;
	private JTextField textField_2;
	private JTextField contact;
	private JTextField add1;
	private JTextField addw;
	private JTextField add3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public StaffMenu() {
		initialize();
		clock();
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
		frmStaffMenu = new JFrame();
		frmStaffMenu.setTitle("STAFF MENU");
		frmStaffMenu.setResizable(false);
		frmStaffMenu.getContentPane().setBackground(new Color(0, 102, 255));
		frmStaffMenu.setBounds(100, 100, 757, 476);
		frmStaffMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStaffMenu.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(12, 12, 212, 421);
		frmStaffMenu.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(39, 0, 130, 44);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("REGISTER STUDENT");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(12, 143, 188, 25);
		panel.add(btnNewButton);
		
		JButton btnCreateProgramme = new JButton("CREATE PROGRAMME");
		btnCreateProgramme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStaffMenu.dispose();
				RegisterStudents rs = new RegisterStudents();
				rs.load();
			}
		});
		btnCreateProgramme.setBounds(12, 195, 188, 25);
		panel.add(btnCreateProgramme);
		
		JButton btnModifyPrgramme = new JButton("MODIFY PRGRAMME");
		btnModifyPrgramme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModifyPrgramme.setBounds(12, 249, 188, 25);
		panel.add(btnModifyPrgramme);
		
		JButton btnGenerateStudentList = new JButton("STUDENT LIST");
		btnGenerateStudentList.setBounds(12, 301, 188, 25);
		panel.add(btnGenerateStudentList);
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				frmStaffMenu.dispose();	
				log.run();
			}
		});
		btnNewButton_1.setBounds(39, 384, 117, 25);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(236, 23, 507, 402);
		frmStaffMenu.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 153, 93, 15);
		panel_1.add(lblNewLabel_1);
		
		fname = new JTextField();
		fname.setBounds(103, 151, 392, 19);
		panel_1.add(fname);
		fname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setBounds(12, 182, 88, 15);
		panel_1.add(lblLastName);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(103, 180, 392, 19);
		panel_1.add(lname);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(182, 14, 25, 15);
		panel_1.add(lblId);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(209, 12, 123, 19);
		panel_1.add(textField_2);
		
		JLabel lblContact = new JLabel("Contact #:");
		lblContact.setForeground(Color.WHITE);
		lblContact.setBounds(12, 228, 93, 15);
		panel_1.add(lblContact);
		
		contact = new JTextField();
		contact.setColumns(10);
		contact.setBounds(103, 226, 392, 19);
		panel_1.add(contact);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setBounds(12, 266, 93, 15);
		panel_1.add(lblAddress);
		
		add1 = new JTextField();
		add1.setColumns(10);
		add1.setBounds(103, 264, 392, 19);
		panel_1.add(add1);
		
		addw = new JTextField();
		addw.setColumns(10);
		addw.setBounds(103, 295, 392, 19);
		panel_1.add(addw);
		
		add3 = new JTextField();
		add3.setColumns(10);
		add3.setBounds(103, 326, 392, 19);
		panel_1.add(add3);
		StudentRecords sr = new StudentRecords();
		
		JSeparator separator = new JSeparator();
		separator.setBounds(481, 277, -468, -24);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 210, 483, 15);
		panel_1.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 34, 483, 15);
		panel_1.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(12, 137, 483, 15);
		panel_1.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(12, 353, 483, 15);
		panel_1.add(separator_4);
		
		JButton btnNewButton_2 = new JButton("REGISTER STUDENT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(144, 365, 311, 25);
		panel_1.add(btnNewButton_2);
		
		JLabel label = new JLabel("Date:");
		label.setForeground(Color.WHITE);
		label.setBounds(12, 49, 62, 15);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setText("11/10/2016");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(143, 49, 328, 19);
		panel_1.add(textField);
		
		JLabel label_1 = new JLabel("Enrolment Status:");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(12, 82, 133, 15);
		panel_1.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText("1");
		textField_1.setColumns(10);
		textField_1.setBounds(143, 80, 328, 19);
		panel_1.add(textField_1);
		
		JLabel label_2 = new JLabel("Programme Code:");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(12, 109, 133, 15);
		panel_1.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(143, 106, 328, 19);
		panel_1.add(textField_3);
	}
}
