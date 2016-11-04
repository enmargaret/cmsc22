package StudentList;

import java.io.Serializable;

/**
 * Created by enmargaret on 04/11/2016.
 */
public class Course implements Serializable {
    private String courseCode;
    private String courseDescription;

    public Course() {
        courseCode = courseDescription = null;
    }

    public Course(String code, String desc) {
        courseCode = code;
        courseDescription = desc;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String toString(){
        return "Course Code: " + courseCode + "\nCourse Description: " + courseDescription;
    }
}
