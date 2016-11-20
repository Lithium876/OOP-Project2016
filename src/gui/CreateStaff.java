package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import services.FileProcess;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateStaff{

	private JFrame frmStaffAccount;
	private JTextField firstName;
	private JTextField username;
	private JPasswordField passwordField;
	private JPasswordField confirmpasswordField;
	private JTextField lastName;
	private JTextField departmnt;
	private JTextField faculty;
	public String usr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateStaff window = new CreateStaff();
					window.frmStaffAccount.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateStaff() {
		initialize();
	}
	public void run() {
		try {
			CreateStaff window = new CreateStaff();
			window.frmStaffAccount.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frmStaffAccount = new JFrame();
		frmStaffAccount.setTitle("Staff Account");
		frmStaffAccount.getContentPane().setBackground(new Color(0, 102, 255));
		frmStaffAccount.setResizable(false);
		frmStaffAccount.setBounds(100, 100, 614, 499);
		frmStaffAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStaffAccount.setLocationRelativeTo(null);
		frmStaffAccount.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(12, 12, 588, 447);
		frmStaffAccount.getContentPane().add(panel);
		panel.setLayout(null);
		
		firstName = new JTextField();
		firstName.setBounds(118, 76, 166, 19);
		panel.add(firstName);
		firstName.setColumns(10);
		
		JLabel fname = new JLabel("First Name:");
		fname.setForeground(new Color(255, 255, 255));
		fname.setBounds(22, 78, 99, 15);
		panel.add(fname);
		
		JLabel lname = new JLabel("Last Name:");
		lname.setForeground(Color.WHITE);
		lname.setBounds(302, 78, 99, 15);
		panel.add(lname);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(265, 163, 198, 19);
		panel.add(username);
		
		JLabel usrname = new JLabel("ID Number:");
		usrname.setForeground(Color.WHITE);
		usrname.setBounds(123, 165, 99, 15);
		panel.add(usrname);
		
		JLabel pass = new JLabel("Password:");
		pass.setForeground(Color.WHITE);
		pass.setBounds(123, 214, 75, 15);
		panel.add(pass);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(265, 212, 198, 19);
		panel.add(passwordField);
		
		confirmpasswordField = new JPasswordField();
		confirmpasswordField.setBounds(265, 256, 198, 19);
		panel.add(confirmpasswordField);
		
		JLabel confirmpasss = new JLabel("Confirm Password:");
		confirmpasss.setForeground(Color.WHITE);
		confirmpasss.setBounds(123, 258, 133, 15);
		panel.add(confirmpasss);
		
		JLabel lblDomain = new JLabel("Domain:");
		lblDomain.setForeground(Color.WHITE);
		lblDomain.setBounds(123, 305, 99, 15);
		panel.add(lblDomain);
		
		JComboBox domain = new JComboBox();
		domain.setEnabled(false);
		domain.setEditable(true);
		domain.setBounds(265, 300, 198, 24);
		domain.setModel(new DefaultComboBoxModel(new String[]{"STAFF"}));
		panel.add(domain);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(400, 76, 159, 19);
		panel.add(lastName);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 150, 564, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 349, 564, 2);
		panel.add(separator_1);
		
		JButton btnNewButton = new JButton("ADD STAFF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileProcess fp = new FileProcess();
				String name = new String(firstName.getText()+" "+lastName.getText());
				usr = username.getText();
				String department = departmnt.getText();
				String fac = faculty.getText();
				String passwrd = new String(passwordField.getPassword());
				String confirmPasswrd = new String(confirmpasswordField.getPassword());
				String type = String.valueOf(domain.getSelectedItem());
				
				fp.validate(name, usr, passwrd, confirmPasswrd, "NO", type,department,fac);
			}
		});
		btnNewButton.setBounds(191, 366, 221, 32);
		panel.add(btnNewButton);
		
		JLabel lblAddStaffAccount = new JLabel("Staff Account");
		lblAddStaffAccount.setFont(new Font("Courier 10 Pitch", Font.BOLD, 47));
		lblAddStaffAccount.setForeground(new Color(255, 255, 255));
		lblAddStaffAccount.setBounds(129, 12, 377, 52);
		panel.add(lblAddStaffAccount);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 62, 564, 2);
		panel.add(separator_2);
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				frmStaffAccount.dispose();	
				log.run();
			}
		});
		btnNewButton_1.setBounds(251, 407, 99, 25);
		panel.add(btnNewButton_1);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setForeground(Color.WHITE);
		lblDepartment.setBounds(22, 123, 99, 15);
		panel.add(lblDepartment);
		
		departmnt = new JTextField();
		departmnt.setColumns(10);
		departmnt.setBounds(118, 119, 166, 19);
		panel.add(departmnt);
		
		JLabel lblFaculty = new JLabel("Faculty:");
		lblFaculty.setForeground(Color.WHITE);
		lblFaculty.setBounds(302, 121, 99, 15);
		panel.add(lblFaculty);
		
		faculty = new JTextField();
		faculty.setColumns(10);
		faculty.setBounds(400, 119, 159, 19);
		panel.add(faculty);
		
		
	}
}
