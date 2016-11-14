package domain;

import java.util.Date;

public class StaffRecords extends Person{
	private String faculty;
	private String department;
	private Date employmentDate;
	
	public StaffRecords(){
		this.faculty=" ";
		this.department=" ";
		this.employmentDate = new Date();
	}
	public StaffRecords(String faculty, String department, Date employmentDate){
		this.faculty=faculty;
		this.department=department;
		this.employmentDate=employmentDate;
		
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setEmploymentDate(Date employmentDate) {
		this.employmentDate = employmentDate;
	}

	public String getFaculty() {
		return faculty;
	}
	public String getDepartment() {
		return department;
	}
	public Date getEmploymentDate() {
		return employmentDate;
	}
	public void display() {
		// TODO Auto-generated method stub
		
	}
}