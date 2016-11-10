package domain;

import java.io.Serializable;

public class CourseRecords extends Records implements Serializable{
	private String description;
	private int credits;
	private String preRequisite;
	
	public CourseRecords(){
		this.description=" ";
		this.credits=0;
		this.preRequisite=" ";
	}
	public CourseRecords(String code, String name, String description, int credits,String preRequisite){
		super(code,name);
		this.description=description;
		this.credits=credits;
		this.preRequisite=preRequisite;
	}
	
	public String getDescription() {
		return description;
	}
	public int getCredits() {
		return credits;
	}
	public String getPreRequisite() {
		return preRequisite;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public void setPreRequisite(String preRequisite) {
		this.preRequisite = preRequisite;
	}
	public void display(){
		System.out.println(super.getCode());
		System.out.println(super.getName());
		System.out.println(description);
		System.out.println(credits);
		System.out.println(preRequisite);
		
	}

}
