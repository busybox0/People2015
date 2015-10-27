package model.unit;

import model.person.Employee;
import model.person.Student;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Group extends StructuralUnit {
    LocalDate dateOfCreation;
    List<Student> listOfStudents = new ArrayList<>();
    Student[] students;
    Speciality speciality;
    Employee curator;
    byte size; // this is the following-the-specs field. Of course int would be better here


    // Constructor 1
    public Group(String groupName, LocalDate dateOfCreation, Speciality speciality, Employee curator) {
        super(groupName);
        this.dateOfCreation = dateOfCreation;
        this.speciality = speciality;
        this.curator = curator;
    }
    // Constructor 2
//    public Group(String groupName, LocalDate dateOfCreation, Speciality speciality, Employee curator,Department department) {
//        super(groupName);
//        this.dateOfCreation = dateOfCreation;
//        this.speciality = speciality;
//        this.curator = curator;
//        this.department = department;
//    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }
    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
    public Speciality getSpeciality() {
        return speciality;
    }
    public void setSpeciality(Speciality speciality) {
        if ( this.speciality == null) {
            this.speciality = speciality;
            this.speciality.addGroup(this);
        }
        else {
            this.speciality.removeGroup(this);
            this.speciality = speciality;
            this.speciality.addGroup(this);
        }
    }
    public Employee getCurator() {
        return curator;
    }
    public void setCurator(Employee curator) {
        this.curator = curator;
    }
    public Student[] getStudents() {
        students = listOfStudents.toArray(new Student[listOfStudents.size()]);
        return students;
    }

    public void addStudent(Student student) {
        listOfStudents.add(student);
    }

    public void removeStudent(Student student) {

        listOfStudents.remove(student);
    }
    public short getYear() {
        return (short) dateOfCreation.getYear();
    }
    public Department getDepartment() {
        return this.getSpeciality().getDepartment();
    }
//    public void setDepartment(Department department) {
//        this.department = department;
//    }
    public Faculty getFaculty() {
        return this.getSpeciality().getDepartment().getFaculty();
    }
//    public void setFaculty(Faculty faculty) {
//        this.faculty = faculty;
//    }

    public byte getSize() {
        size = (byte) listOfStudents.size();
        return size;
    }

}
