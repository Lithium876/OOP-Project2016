package presentation;

import java.util.Scanner;

import domain.*;

public class driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		ProgrammeRecords pr = new ProgrammeRecords();
		StudentRecords stu = new StudentRecords();
		CourseRecords course = new CourseRecords("Course Name","Course Code","Course Deswcription",32,"Course preRequisite");
		
		stu.setAddress("Address");
		stu.setContactNumber(754843);
		stu.setEnrolmentStatus(true);
		stu.setProgrammeCode("PHY432");
		stu.setIdNumber(893453);
		stu.setFirstName("Lomar");
		stu.setLastName("Lilly");
		stu.setcourse(course);
		stu.display();

		/*pr.setCode("HPT432");
		pr.setName("Name");
		pr.setMaxCourse(7);
		pr.setAward("AWARD");
		pr.setAccreditation("Accreditation");
		pr.setcourse(course);
		pr.display();*/
		input.close();
	}
}