package domain;

public abstract class Person {
	private int idNumber;
	private String firstName;
	private String lastName;
	
	public Person(){
		this.idNumber=0;
		this.firstName=" ";
		this.lastName=" ";
	}
	public Person(int idNumber, String firstName, String LastName){
		this.idNumber=idNumber;
		this.firstName=firstName;
	}
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getIdNumber() {
		return idNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public abstract void display();
}
