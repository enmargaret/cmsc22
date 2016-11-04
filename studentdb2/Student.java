package StudentList;

/*
*Created by enmargaret, jezamarts, && noahdominic
*/

import java.io.*;

public class Student implements Serializable {
    private String studentNumber;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private String course;
    private int yearLevel;
    private Course faveSubject;
    private String crushName;

    public Student(){
        studentNumber = firstName = lastName = crushName = course = null;
        faveSubject = new Course();
        middleInitial = 0;
        yearLevel = 0;
    }

    public Student(String num, String fname, char initial, String lname, String course, int year, Course fave, String crush){
        studentNumber = num;
        firstName = fname;
        middleInitial = initial;
        lastName = lname;
        this.course = course;
        yearLevel = year;
        faveSubject = fave;
        crushName = crush;
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
    public String getCrush(){return crushName;}

    public Course getFave(){return faveSubject;}

    public void setCrush(String crush){
        crushName = crush;
    }

    public void setFave(Course fave){
        faveSubject = fave;
    }

    public String toString(){
        if(middleInitial == ' ') {
            return "Student Number: " + studentNumber + "\nName: " + lastName + ", "
                    + firstName + " " + "\nProgram: " + course + "\nYear: " + yearLevel + "\nFavorite Subject:\n" + faveSubject +
                    "\nCrush Name: " + crushName;
        }
        else {
            return "Student Number: " + studentNumber + "\nName: " + lastName + ", "
                    + firstName + " " + middleInitial + ".\nProgram: " + course + "\nYear: " + yearLevel +
                    "\nFavorite Subject:\n" + faveSubject + "\nCrush Name: " + crushName;
        }
    }
}
