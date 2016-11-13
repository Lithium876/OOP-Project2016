package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ChangePassword {

	private JFrame frmChangePassword;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	StaffMenu sm= new StaffMenu();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword window = new ChangePassword();
					window.frmChangePassword.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
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


	/**
	 * Initialize the contents of the frame.
	 */
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(167, 12, 198, 19);
		frmChangePassword.getContentPane().add(textField);
		
		JLabel label_1 = new JLabel("Password:");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(25, 63, 75, 15);
		frmChangePassword.getContentPane().add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(167, 61, 198, 19);
		frmChangePassword.getContentPane().add(passwordField);
		
		JLabel label_2 = new JLabel("Confirm Password:");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(25, 107, 133, 15);
		frmChangePassword.getContentPane().add(label_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(167, 105, 198, 19);
		frmChangePassword.getContentPane().add(passwordField_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 41, 397, 2);
		frmChangePassword.getContentPane().add(separator);
		
		JButton btnNewButton = new JButton("CHANGE PASSWORD");
		btnNewButton.setBounds(94, 159, 245, 34);
		frmChangePassword.getContentPane().add(btnNewButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 145, 397, 2);
		frmChangePassword.getContentPane().add(separator_1);
	}

}
