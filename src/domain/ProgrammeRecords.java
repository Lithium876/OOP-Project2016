package domain;

public class ProgrammeRecords extends Records{
	private int maxCourse;
	private String award;
	private String accreditation;
	private CourseRecords course;
	
	public ProgrammeRecords(){
		this.award=" ";
		this.accreditation=" ";
		this.course = new CourseRecords();
	}
	
	public ProgrammeRecords(String code, String name, int maxCourse, String award, String accreditation,CourseRecords course){
		super(code,name);
		this.course=course;
		this.maxCourse=maxCourse;
		this.award=award;
		this.accreditation=accreditation;
	}
	public void setcourse(CourseRecords course){
		this.course=course;
	}
	public CourseRecords getcourse(){
		return course;
	}
	public int getMaxCourse() {
		return maxCourse;
	}
	public String getAward() {
		return award;
	}
	public String getAccreditation() {
		return accreditation;
	}
	public void setMaxCourse(int maxCourse) {
		this.maxCourse = maxCourse;
	}
	public void setAward(String award) {
		this.award = award;
	}
	public void setAccreditation(String accreditation) {
		this.accreditation = accreditation;
	}
	
	public void display(){
		System.out.println(super.getCode()); 
		System.out.println(super.getName());
		System.out.println(maxCourse);
		System.out.println(award);
		System.out.println(accreditation);	
		course.display();
	}
}
