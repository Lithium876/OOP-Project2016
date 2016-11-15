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
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class AddCourse {


	private JFrame frmAddCourse;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourse window = new AddCourse();
					window.frmAddCourse.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn=null;
	private JTextField textField;
	
	public AddCourse() {
		initialize();
		clock();
		conn=DBConnection.dbConnector();
		
	}
	public void load() {
		try {
			AddCourse window = new AddCourse();
			window.frmAddCourse.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void live() {
		try {
			AddCourse window = new AddCourse();
			window.frmAddCourse.setVisible(true);
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
		frmAddCourse = new JFrame();
		frmAddCourse.setTitle("STAFF MENU");
		frmAddCourse.setResizable(false);
		frmAddCourse.getContentPane().setBackground(new Color(0, 102, 255));
		frmAddCourse.setBounds(100, 100, 757, 476);
		frmAddCourse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddCourse.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(12, 12, 212, 421);
		frmAddCourse.getContentPane().add(panel);
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
				frmAddCourse.dispose();	
				sm.load();
			}
		});
		btnNewButton.setBounds(12, 143, 188, 25);
		panel.add(btnNewButton);
		
		JButton btnAddCourse= new JButton("Add Course");
		btnAddCourse.setEnabled(false);
		btnAddCourse.setBounds(12, 195, 188, 25);
		panel.add(btnAddCourse);
		
		JButton btnGenerateFee = new JButton("Generate Fee Breakdown");
		btnGenerateFee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerateFee gf = new GenerateFee();
				frmAddCourse.dispose();	
				gf.load();
				
			}
		});
		btnGenerateFee.setBounds(12, 249, 188, 25);
		panel.add(btnGenerateFee);
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				frmAddCourse.dispose();	
				log.run();
			}
		});
		btnNewButton_1.setBounds(39, 384, 117, 25);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(236, 12, 507, 421);
		frmAddCourse.getContentPane().add(panel_1);
		
		JLabel lblSelectACourses = new JLabel("Select a Course(s) From The Group Below  ");
		lblSelectACourses.setForeground(Color.WHITE);
		lblSelectACourses.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSelectACourses.setBounds(35, 13, 420, 26);
		panel_1.add(lblSelectACourses);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(131, 326, 97, 25);
		panel_1.add(btnSave);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(282, 326, 97, 25);
		panel_1.add(btnReset);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(70, 132, 113, 25);
		panel_1.add(chckbxNewCheckBox);
		
		JCheckBox checkBox = new JCheckBox("New check box");
		checkBox.setEnabled(false);
		checkBox.setBounds(201, 178, 113, 25);
		panel_1.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("New check box");
		checkBox_1.setBounds(201, 132, 113, 25);
		panel_1.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("New check box");
		checkBox_2.setBounds(342, 132, 113, 25);
		panel_1.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("New check box");
		checkBox_3.setBounds(70, 178, 113, 25);
		panel_1.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("New check box");
		checkBox_4.setEnabled(false);
		checkBox_4.setBounds(342, 178, 113, 25);
		panel_1.add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("New check box");
		checkBox_5.setEnabled(false);
		checkBox_5.setBounds(70, 228, 113, 25);
		panel_1.add(checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox("New check box");
		checkBox_6.setEnabled(false);
		checkBox_6.setBounds(201, 228, 113, 25);
		panel_1.add(checkBox_6);
		
		JLabel lblNewLabel_1 = new JLabel("Program Enrolled:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(47, 70, 146, 20);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(198, 68, 116, 22);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(60, 120, 407, 145);
		panel_1.add(panel_2);
		
	}
}