/*
*Created by enmargaret, jezamarts, && noahdominic
*/

public class Student{
	private String studentNumber;
	private String firstName;
	private char middleInitial;
	private String lastName;
	private String course;
	private int yearLevel;
	
	public Student(){
		studentNumber = firstName = lastName = course = null;
		middleInitial = 0;
		yearLevel = 0;
	}
	
	public Student(String num, String fname, char initial, String lname, String course, int year){
		studentNumber = new String(num);
		firstName = new String(fname);
		middleInitial = initial;
		lastName = new String(lname);
		this.course = new String(course);
		yearLevel = year;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public char getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(char middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getYearLevel() {
		return yearLevel;
	}
	public void setYearLevel(int yearLevel) {
		this.yearLevel = yearLevel;
	}
	public void setStudentNumber(String num) {
		studentNumber = num;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public String toString(){
		return "Student Number: " + studentNumber + "\nName: " + lastName + ", " 
		+ firstName + " " + middleInitial + ".\nProgram: " + course + "\nYear: " + yearLevel;
	}
	
}
