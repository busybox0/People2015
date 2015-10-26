package model.person;

import model.unit.Faculty;
import model.unit.Group;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student extends Person {
    LocalDate enrollmentDate;
    LocalDate leaveDate;
    Faculty faculty;
    Group group;

    // Constructor1
    public Student(String firstName, String lastName, LocalDate birthDate, LocalDate enrollDate) {
        super(firstName, lastName, birthDate);
        this.enrollmentDate = enrollDate;
    }
    // Constructor2
    public Student(String firstName, String lastName, String birthDate_yyyymmdd, String enrollDate_yyyymmdd) {
        super(firstName, lastName, birthDate_yyyymmdd);
        this.enrollmentDate = LocalDate.parse(enrollDate_yyyymmdd, DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
    public LocalDate getLeaveDate() {
        return leaveDate;
    }

    @Override
    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setGroup(Group group) {
        if ( this.group == null) {
            this.group = group;
            this.group.addStudent(this);
        }
        else {
            this.group.removeStudent(this);
            this.group = group;
            this.group.addStudent(this);
        }
    }

    public Group getGroup() {
        return group;
    }

    public void setLeaveDate(LocalDate leaveDate) {
        this.leaveDate = leaveDate;
    }

    @Override
    public String toString() {
        return  super.toString() + "; Enrolled: " + enrollmentDate.toString() ;
    }

    public void fire(){
        counter--;
        leaveDate = LocalDate.now();

    }

}
