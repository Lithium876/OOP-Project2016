package hai;


import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Programme extends JFrame {
	private String Code;
	private String Award;
	private String PName;
	private int MaxCourse;
	private String Accreditation;
	//private CourseRecord courseRecord;
	Staff s= new Staff();
	AddStaff as= new AddStaff();
	private JPanel contentPane;
	private JTextField tfCode;
	private JTextField tfAward;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Programme frame = new Programme();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn=null;
	/**
	 * Create the frame.
	 */
	public  Programme() {
		
		setTitle("Create Progamme");
		conn= SqliteConnect.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnlogout = new JButton("Back");
		Image img6= new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnlogout.setIcon(new ImageIcon(img6));
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  dispose();
			  StaffMenu s= new StaffMenu();
			  s.setVisible(true);
			}
		});
		btnlogout.setFont(new Font("Stencil", Font.PLAIN, 15));
		btnlogout.setBounds(583, 380, 121, 37);
		contentPane.add(btnlogout);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setForeground(new Color(255, 204, 0));
		lblName.setFont(new Font("Stencil", Font.ITALIC, 15));
		lblName.setBounds(25, 29, 190, 26);
		contentPane.add(lblName);
		
		JLabel lblCode = new JLabel("Code:");
		lblCode.setForeground(new Color(255, 204, 0));
		lblCode.setFont(new Font("Stencil", Font.ITALIC, 15));
		lblCode.setBounds(25, 92, 190, 24);
		contentPane.add(lblCode);
		
		JLabel lblAward = new JLabel("Award:");
		lblAward.setForeground(new Color(255, 204, 0));
		lblAward.setFont(new Font("Stencil", Font.ITALIC, 15));
		lblAward.setBounds(25, 150, 190, 27);
		contentPane.add(lblAward);
		
		JLabel lblAcreditationStatus = new JLabel("Acreditation Status:");
		lblAcreditationStatus.setForeground(new Color(255, 204, 0));
		lblAcreditationStatus.setFont(new Font("Stencil", Font.ITALIC, 15));
		lblAcreditationStatus.setBounds(25, 215, 190, 26);
		contentPane.add(lblAcreditationStatus);
		
		JLabel lblNewLabel = new JLabel("Maximun Number of Courses:");
		lblNewLabel.setForeground(new Color(255, 204, 0));
		lblNewLabel.setFont(new Font("Stencil", Font.ITALIC, 13));
		lblNewLabel.setBounds(25, 272, 202, 62);
		contentPane.add(lblNewLabel);
		
		tfCode = new JTextField();
		tfCode.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		tfCode.setBounds(316, 87, 252, 26);
		contentPane.add(tfCode);
		tfCode.setColumns(10);
		
		tfAward = new JTextField();
		tfAward.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		tfAward.setBounds(316, 146, 252, 26);
		contentPane.add(tfAward);
		tfAward.setColumns(10);

		String[] status={"Accredited","Unaccredited"};
		JComboBox cbStatus = new JComboBox(status);
		cbStatus.setSelectedIndex(-1);
		cbStatus.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		cbStatus.setBounds(315, 211, 190, 26);
		contentPane.add(cbStatus);
		
		String max[]={"1","2","3","4","5","6","7","8"};
		JComboBox cbMCourse = new JComboBox(max);
		cbMCourse.setSelectedIndex(-1);
		cbMCourse.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		cbMCourse.setBounds(315, 286, 111, 26);
		contentPane.add(cbMCourse);
		
		
		String[] programmes={"Certificate","Diploma","Associates Degree"};
		JComboBox cbName = new JComboBox(programmes);
		cbName.setSelectedIndex(-1);
		cbName.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		cbName.setBounds(316, 25, 252, 26);
		contentPane.add(cbName);
	  	
		JButton btnReset = new JButton("Clear");
		 btnReset.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
				cbName.setSelectedIndex(-1);
				cbMCourse.setSelectedIndex(-1);
				cbStatus.setSelectedIndex(-1);
				tfCode.setText(" ");
				tfAward.setText(" ");
				}
		});
		Image img4= new ImageIcon(this.getClass().getResource("/reset.png")).getImage();
		btnReset.setIcon(new ImageIcon(img4));
		btnReset.setForeground(new Color(0, 0, 0));
		btnReset.setFont(new Font("Stencil", Font.PLAIN, 15));
		btnReset.setBounds(429, 380, 121, 36);
		contentPane.add(btnReset);	
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  try{
				if((cbName.getSelectedIndex()!=-1)&&(tfAward.getText().length()!=0)&&(tfCode.getText().length()!=0)&&(cbStatus.getSelectedIndex()!=-1)&&(cbMCourse.getSelectedIndex()!=-1)){
				   setPName(cbName.getSelectedItem().toString());
			       setAccreditation(cbStatus.getSelectedItem().toString());
			       String s=cbMCourse.getSelectedItem().toString();
			       setMaxCourse(Integer.parseInt(s));
			       setCode(tfCode.getText());	
				   setAward(tfAward.getText());
				   String query= "INSERT INTO Programmes values ('"+getPName()+"',"+"'"+getCode()+"',"+"'"+getAccreditation()+"',"+"'"+getAward()+"',"+"'"+getMaxCourse()+"')";
				   Statement statement= conn.createStatement(); 
				   statement.executeUpdate(query);
				   statement.close();
				   
				   PreparedStatement ps=conn.prepareStatement(query);
				   ps.close();
				   
				   JOptionPane.showMessageDialog(null," Programme Databade Sucessfully Updated");
				   
			       
			       
			       cbName.setSelectedIndex(-1);
				   cbMCourse.setSelectedIndex(-1);
				   cbStatus.setSelectedIndex(-1);
				   tfCode.setText(" ");
				   tfAward.setText(" ");
				   dispose();
				}
		        else{
					JOptionPane.showMessageDialog(null, "Ensure that all fields are filled");
				}
				
			}
			  catch(Exception ex){
				  JOptionPane.showMessageDialog(null,ex.getMessage());
			  }
			  
			}
		});
		btnCreate.setForeground(new Color(0, 0, 0));
		btnCreate.setFont(new Font("Stencil", Font.PLAIN, 15));
		Image img= new ImageIcon(this.getClass().getResource("/Pic2.png")).getImage();
		btnCreate.setIcon(new ImageIcon(img));
		btnCreate.setBounds(280, 380, 121, 36);
		contentPane.add(btnCreate);
		
		
		 
		
		
		
		JLabel label_1 = new JLabel("");
		Image img0= new ImageIcon(this.getClass().getResource("/FF.png")).getImage();
		label_1.setIcon(new ImageIcon(img0));
		label_1.setBounds(10, 11, 217, 366);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		Image img10= new ImageIcon(this.getClass().getResource("/FF.png")).getImage();
		label_2.setIcon(new ImageIcon(img10));
		label_2.setBounds(248, 11, 456, 366);
		contentPane.add(label_2);
		
		
		
		
		JLabel label = new JLabel(" ");
		Image img2= new ImageIcon(this.getClass().getResource("/FORM.png")).getImage();
		label.setIcon(new ImageIcon(img2));
		label.setBounds(0, 0, 721, 429);
		contentPane.add(label);

	
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getPName() {
		return PName;
	}

	public void setPName(String pName) {
		PName = pName;
	}

	public int getMaxCourse() {
		return MaxCourse;
	}

	public void setMaxCourse(int maxCourse) {
		MaxCourse = maxCourse;
	}

	public String getAccreditation() {
		return Accreditation;
	}

	public void setAccreditation(String accreditation) {
		Accreditation = accreditation;
	}

	public String getAward() {
		return Award;
	}

	public void setAward(String award) {
		Award = award;
	}
}
