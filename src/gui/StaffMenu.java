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

public class StaffMenu {

	private JFrame frmStaffMenu;

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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(12, 143, 188, 25);
		panel.add(btnNewButton);
		
		JButton btnCreateProgramme = new JButton("CREATE PROGRAMME");
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
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(236, 106, 507, 270);
		frmStaffMenu.getContentPane().add(panel_1);
	}
}
