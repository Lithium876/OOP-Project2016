package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import services.DBConnection;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GenerateFee {

	private JFrame frmGenerateFee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateFee window = new GenerateFee();
					window.frmGenerateFee.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}Connection conn=null;
JTable table;
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;
	
	public GenerateFee() {
		initialize();
		clock();
		conn=DBConnection.dbConnector();
		
	}
	public void load() {
		try {
			GenerateFee window = new GenerateFee();
			window.frmGenerateFee.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void live() {
		try {
			GenerateFee window = new GenerateFee();
			window.frmGenerateFee.setVisible(true);
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
					/*int seconds = now.get(Calendar.SECOND);
					int minutes=now.get(Calendar.MINUTE);
					int hour=now.get(Calendar.HOUR);
			*/
					//date.setText(month+"/"+day+"/"+year);
					sleep(1000);
					}
				}catch(Exception e){
					
				}
			}
		};
		clock.start();
	}
	public void clear(){
		
	}


	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGenerateFee = new JFrame();
		frmGenerateFee.setTitle("STAFF MENU");
		frmGenerateFee.setResizable(false);
		frmGenerateFee.getContentPane().setBackground(new Color(0, 102, 255));
		frmGenerateFee.setBounds(100, 100, 757, 476);
		frmGenerateFee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGenerateFee.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(12, 12, 212, 421);
		frmGenerateFee.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(39, 0, 130, 44);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("View Program Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentMenu sm = new StudentMenu();
				frmGenerateFee.dispose();	
				sm.load();
			}
		});
		btnNewButton.setBounds(12, 143, 188, 25);
		panel.add(btnNewButton);
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourse ac = new AddCourse();
				frmGenerateFee.dispose();	
				ac.load();
			}
		});
		btnAddCourse.setBounds(12, 195, 188, 25);
		panel.add(btnAddCourse);
		
		JButton btnGenerateFee = new JButton("Generate Fee Breakdown");
		btnGenerateFee.setEnabled(false);
		btnGenerateFee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnGenerateFee.setBounds(12, 249, 188, 25);
		panel.add(btnGenerateFee);
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				frmGenerateFee.dispose();	
				log.run();
			}
		});
		btnNewButton_1.setBounds(39, 384, 117, 25);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(236, 12, 507, 421);
		frmGenerateFee.getContentPane().add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 69, 379, 162);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Total Fees:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(50, 385, 100, 23);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(222, 386, 116, 22);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Total Credits:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(50, 356, 116, 16);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("# Of Courses Enrolled:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(50, 327, 182, 16);
		panel_1.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(222, 354, 116, 22);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(222, 325, 116, 22);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblP = new JLabel("Progress Report");
		lblP.setFont(new Font("Dialog", Font.BOLD, 20));
		lblP.setForeground(Color.WHITE);
		lblP.setBounds(161, 13, 165, 23);
		panel_1.add(lblP);
		
		JLabel lblFeeBreakdown = new JLabel("Fee Breakdown");
		lblFeeBreakdown.setFont(new Font("Dialog", Font.BOLD, 20));
		lblFeeBreakdown.setForeground(Color.WHITE);
		lblFeeBreakdown.setBounds(178, 269, 148, 16);
		panel_1.add(lblFeeBreakdown);
	}
}
