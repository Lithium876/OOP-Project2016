package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import services.FileProcess;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmLogin;
	private JTextField usrname;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(new Color(0, 102, 255));
		frmLogin.setResizable(false);
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 614, 467);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 255));
		panel.setBounds(227, 102, 10, 222);
		frmLogin.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(0, 0, 230, 416);
		frmLogin.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 153, 255));
		panel_2.setBounds(237, -15, 375, 431);
		frmLogin.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Droid Sans Fallback", Font.BOLD, 16));
		lblUsername.setBounds(12, 146, 121, 26);
		panel_2.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Droid Sans Fallback", Font.BOLD, 16));
		lblPassword.setBounds(12, 184, 121, 26);
		panel_2.add(lblPassword);
		
		JLabel lblDomain = new JLabel("Domain:");
		lblDomain.setForeground(new Color(255, 255, 255));
		lblDomain.setFont(new Font("Droid Sans Fallback", Font.BOLD, 16));
		lblDomain.setBounds(12, 222, 121, 26);
		panel_2.add(lblDomain);
		
		usrname = new JTextField();
		usrname.setBounds(110, 151, 190, 19);
		panel_2.add(usrname);
		usrname.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(110, 189, 190, 19);
		panel_2.add(pass);
		
		JComboBox domain = new JComboBox();
		domain.setEditable(true);
		domain.setBounds(110, 224, 190, 24);
		domain.setModel(new DefaultComboBoxModel(new String[]{"Administrator","Staff","Student"}));
		panel_2.add(domain);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passwrd = new String(pass.getPassword());
				String usr =usrname.getText();
				String pswrd =passwrd;
				String type = String.valueOf(domain.getSelectedItem());
				
				int check;
				FileProcess look = new FileProcess();
				check=look.fileLookUP(usr, pswrd,type);
				
				if(check==0){
					System.out.println("Login B");
				}
				else{
					JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
				}
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton.setBounds(130, 276, 132, 26);
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 153, 255));
		panel_3.setBounds(227, -15, 10, 431);
		frmLogin.getContentPane().add(panel_3);
	}
}