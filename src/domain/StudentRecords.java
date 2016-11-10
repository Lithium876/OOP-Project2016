package domain;

import java.io.Serializable;
import java.util.Date;

public class StudentRecords extends Person implements Serializable{
	private String address;
	private Date dateEnrolled;
	private String programmeCode;
	private boolean enrolmentStatus;
	private int contactNumber;
	private CourseRecords course;
	
	
	public StudentRecords(){
		this.address=" ";
		this.dateEnrolled = new Date();
		this.enrolmentStatus=false;
		this.contactNumber=0;
		this.course = new CourseRecords();
	}
	public StudentRecords(int id,String firstName, String lastName,String address, boolean enrolmentStatus,String programmeCode, int contactNumber,CourseRecords course){
		super(id,firstName,lastName);
		this.course=course;
		this.address=address;
		this.enrolmentStatus=enrolmentStatus;
		this.programmeCode=programmeCode;
		this.contactNumber=contactNumber;
		this.enrolmentStatus=enrolmentStatus;
		this.dateEnrolled=new Date();
	}
	public void setcourse(CourseRecords course){
		this.course=course;
	}
	public CourseRecords getcourse(){
		return course;
	}
 	public void setAddress(String address) {
		this.address = address;
	}
	public void setDateEnrolled(Date dateEnrolled) {
		this.dateEnrolled = dateEnrolled;
	}
	public void setProgrammeCode(String programmeCode){
		this.programmeCode=programmeCode;
	}
	public void setEnrolmentStatus(boolean enrolmentStatus) {
		this.enrolmentStatus = enrolmentStatus;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getProgramCode(){
		return programmeCode;
	}
	public String getAddress() {
		return address;
	}
	public Date getDateEnrolled() {
		return dateEnrolled;
	}
	public boolean isEnrolmentStatus() {
		return enrolmentStatus;
	}
	public int getContactNumber() {
		return contactNumber;
	}
	public void display(){
		System.out.println(dateEnrolled);
		System.out.println(super.getIdNumber());
		System.out.println(super.getFirstName() +" "+super.getLastName());
		System.out.println(address);
		System.out.println(enrolmentStatus);
		System.out.println(programmeCode);
		course.display();
		
	}
}