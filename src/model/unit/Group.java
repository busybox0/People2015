package model.unit;

import model.person.Employee;
import model.person.Student;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Group extends StructuralUnit {
    LocalDate dateOfCreation;
    List<Student> listOfStudents = new ArrayList<>();
    Object[] students;
//    Student[] students;
    Speciality speciality;
    Employee curator;
//    Department department;
//    Faculty faculty;

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
        return (Student[])students;
    }

    public void addStudent(Student student) {
        listOfStudents.add(student);
        System.out.println("listOfStudents " + listOfStudents.toString());
//        if  ( listOfStudents.size() > 1) students =   listOfStudents.toArray(students);
        students =   listOfStudents.toArray();
    }


    public void removeStudent(Student student) {

        listOfStudents.remove(student);
        students = (Student[]) listOfStudents.toArray();
    }
    public short getYear() {
        return (short) dateOfCreation.getYear();
    }
    public byte getSize() {
        return (byte) (students.length + 1);
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
}
