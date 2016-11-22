package gui;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

import services.FileProcess;

import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassword {

	private JFrame frmChangePassword;
	private JTextField id;
	private JPasswordField passwordField;
	private JPasswordField confirmpasswordField;
	StaffMenu sm= new StaffMenu();
	
	
	public void start() {
		try {
			ChangePassword window = new ChangePassword();
			window.frmChangePassword.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ChangePassword() {
		initialize();
	}

	private void initialize() {
		frmChangePassword = new JFrame();
		frmChangePassword.setResizable(false);
		frmChangePassword.setTitle("CHANGE PASSWORD");
		frmChangePassword.setAlwaysOnTop(true);
		frmChangePassword.getContentPane().setBackground(new Color(0, 153, 255));
		frmChangePassword.setBounds(100, 100, 430, 230);
		frmChangePassword.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmChangePassword.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("ID Number:");
		label.setForeground(Color.WHITE);
		label.setBounds(25, 14, 99, 15);
		frmChangePassword.getContentPane().add(label);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(167, 12, 198, 19);
		frmChangePassword.getContentPane().add(id);
		
		JLabel pass = new JLabel("New Password:");
		pass.setForeground(Color.WHITE);
		pass.setBounds(25, 63, 124, 15);
		frmChangePassword.getContentPane().add(pass);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(167, 61, 198, 19);
		frmChangePassword.getContentPane().add(passwordField);
		
		JLabel label_2 = new JLabel("Confirm Password:");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(25, 107, 133, 15);
		frmChangePassword.getContentPane().add(label_2);
		
		confirmpasswordField = new JPasswordField();
		confirmpasswordField.setBounds(167, 105, 198, 19);
		frmChangePassword.getContentPane().add(confirmpasswordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 41, 397, 2);
		frmChangePassword.getContentPane().add(separator);
		
		JButton btnNewButton = new JButton("CHANGE PASSWORD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileProcess fp = new FileProcess();
				String passwrd = new String(passwordField.getPassword());
				String confirmPasswrd = new String(confirmpasswordField.getPassword());
				fp.validate("", id.getText(), passwrd, confirmPasswrd, "YES", "", "", "");
				frmChangePassword.dispose();
			}
		});
		btnNewButton.setBounds(94, 159, 245, 34);
		frmChangePassword.getContentPane().add(btnNewButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 145, 397, 2);
		frmChangePassword.getContentPane().add(separator_1);
	}
}