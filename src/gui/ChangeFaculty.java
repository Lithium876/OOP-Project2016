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

public class ChangeFaculty {

	private JFrame frmChangePassword;
	private JTextField textField;
	StaffMenu sm= new StaffMenu();
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeFaculty window = new ChangeFaculty();
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
			ChangeFaculty window = new ChangeFaculty();
			window.frmChangePassword.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ChangeFaculty() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChangePassword = new JFrame();
		frmChangePassword.setResizable(false);
		frmChangePassword.setTitle("CHANGE FACULTY");
		frmChangePassword.setAlwaysOnTop(true);
		frmChangePassword.getContentPane().setBackground(new Color(0, 153, 255));
		frmChangePassword.setBounds(100, 100, 430, 214);
		frmChangePassword.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmChangePassword.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("ID Number:");
		label.setForeground(Color.WHITE);
		label.setBounds(25, 14, 99, 15);
		frmChangePassword.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(179, 12, 198, 19);
		frmChangePassword.getContentPane().add(textField);
		
		JLabel lblCurrentDepartment = new JLabel("Current Faculty:");
		lblCurrentDepartment.setForeground(Color.WHITE);
		lblCurrentDepartment.setBounds(25, 57, 161, 15);
		frmChangePassword.getContentPane().add(lblCurrentDepartment);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(179, 55, 198, 19);
		frmChangePassword.getContentPane().add(textField_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(19, 41, 397, 2);
		frmChangePassword.getContentPane().add(separator);
		
		JLabel lblNewDepartment = new JLabel("New Faculty:");
		lblNewDepartment.setForeground(Color.WHITE);
		lblNewDepartment.setBounds(25, 93, 161, 15);
		frmChangePassword.getContentPane().add(lblNewDepartment);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(179, 91, 198, 19);
		frmChangePassword.getContentPane().add(textField_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 128, 397, 2);
		frmChangePassword.getContentPane().add(separator_1);
		
		JButton btnChangeDepartment = new JButton("CHANGE FACULTY");
		btnChangeDepartment.setBounds(98, 142, 245, 34);
		frmChangePassword.getContentPane().add(btnChangeDepartment);
	}

}
