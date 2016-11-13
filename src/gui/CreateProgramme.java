package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Calendar;
//import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import services.FileProcess;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class CreateProgramme {

	private JFrame frmCreateProgramme;
	private JTextField textField;
	private JTextField textField_1;
	private String name;
	private String depart;
	private String fac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateProgramme window = new CreateProgramme();
					window.frmCreateProgramme.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateProgramme() {
		initialize();
	}
	public void load() {
		try {
			CreateProgramme window = new CreateProgramme();
			window.frmCreateProgramme.setVisible(true);
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
					/*Calendar now = new GregorianCalendar();
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
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCreateProgramme = new JFrame();
		frmCreateProgramme.setTitle("STAFF MENU");
		frmCreateProgramme.setResizable(false);
		frmCreateProgramme.getContentPane().setBackground(new Color(0, 102, 255));
		frmCreateProgramme.setBounds(100, 100, 757, 569);
		frmCreateProgramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateProgramme.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(12, 31, 212, 461);
		frmCreateProgramme.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(39, 0, 130, 44);
		panel.add(lblNewLabel);

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
		
		JButton btnNewButton = new JButton("REGISTER STUDENT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCreateProgramme.dispose();
				StaffMenu sm = new StaffMenu();
				sm.load();
			}
		});
		btnNewButton.setBounds(12, 162, 188, 25);
		panel.add(btnNewButton);
		
		JButton btnCreateProgramme = new JButton("CREATE PROGRAMME");
		btnCreateProgramme.setEnabled(false);
		btnCreateProgramme.setBounds(12, 214, 188, 25);
		panel.add(btnCreateProgramme);
		
		JButton btnModifyPrgramme = new JButton("MODIFY PRGRAMME");
		btnModifyPrgramme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModifyPrgramme.setBounds(12, 268, 188, 25);
		panel.add(btnModifyPrgramme);
		
		JButton btnGenerateStudentList = new JButton("STUDENT LIST");
		btnGenerateStudentList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCreateProgramme.dispose();
				StudentList sl =new StudentList();
				sl.load();
			}
		});
		btnGenerateStudentList.setBounds(12, 320, 188, 25);
		panel.add(btnGenerateStudentList);
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				frmCreateProgramme.dispose();	
				log.run();
			}
		});
		btnNewButton_1.setBounds(39, 424, 117, 25);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(236, 12, 507, 496);
		frmCreateProgramme.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Programme Code:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(23, 79, 191, 28);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(216, 85, 242, 19);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblProgrammeName = new JLabel("Programme Name:");
		lblProgrammeName.setForeground(Color.WHITE);
		lblProgrammeName.setFont(new Font("Dialog", Font.BOLD, 18));
		lblProgrammeName.setBounds(23, 133, 191, 28);
		panel_1.add(lblProgrammeName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(216, 139, 242, 19);
		panel_1.add(textField_1);
		
		JLabel label = new JLabel("Programme Name:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setBounds(23, 189, 191, 28);
		panel_1.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(221, 192, 237, 24);
		panel_1.add(comboBox);
		
		JButton btnNewButton_2 = new JButton("CREATE PROGRAMME");
		btnNewButton_2.setBounds(97, 450, 293, 34);
		panel_1.add(btnNewButton_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Degree ");
		rdbtnNewRadioButton.setFont(new Font("Dialog", Font.BOLD, 18));
		rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBackground(new Color(0, 153, 255));
		rdbtnNewRadioButton.setBounds(145, 347, 149, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Associate Degree");
		rdbtnNewRadioButton_1.setFont(new Font("Dialog", Font.BOLD, 18));
		rdbtnNewRadioButton_1.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1.setBackground(new Color(0, 153, 255));
		rdbtnNewRadioButton_1.setBounds(145, 386, 204, 23);
		panel_1.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnCertificate = new JRadioButton("Certificate");
		rdbtnCertificate.setFont(new Font("Dialog", Font.BOLD, 18));
		rdbtnCertificate.setForeground(new Color(255, 255, 255));
		rdbtnCertificate.setBackground(new Color(0, 153, 255));
		rdbtnCertificate.setBounds(145, 309, 149, 23);
		panel_1.add(rdbtnCertificate);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 238, 483, 2);
		panel_1.add(separator);
		
		JLabel lblProgrammeType = new JLabel("PROGRAMME TYPE");
		lblProgrammeType.setFont(new Font("Bitstream Charter", Font.BOLD, 24));
		lblProgrammeType.setForeground(new Color(255, 255, 255));
		lblProgrammeType.setBounds(142, 248, 282, 40);
		panel_1.add(lblProgrammeType);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 286, 483, 2);
		panel_1.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 429, 483, 2);
		panel_1.add(separator_2);
		
		JLabel lblCreateProgramme = new JLabel("CREATE PROGRAMME");
		lblCreateProgramme.setForeground(Color.WHITE);
		lblCreateProgramme.setFont(new Font("Bitstream Charter", Font.BOLD, 30));
		lblCreateProgramme.setBounds(84, 12, 340, 40);
		panel_1.add(lblCreateProgramme);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(12, 52, 483, 2);
		panel_1.add(separator_3);
		
		JMenuBar menuBar = new JMenuBar();
		frmCreateProgramme.setJMenuBar(menuBar);
		
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
