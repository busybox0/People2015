package model.person;


import model.unit.Department;
import model.unit.Faculty;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Employee extends Person {

    LocalDate hireDate;
    LocalDate fireDate;
    Department department;

    // Constructor1
     public Employee(String inFirstName, String inLastName, LocalDate inBirthDate, LocalDate inhireDate) {
        super(inFirstName, inLastName, inBirthDate);
        this.hireDate = inhireDate;
    }
    // Constructor2
     public Employee(String inFirstName, String inLastName, String inBirthDate_yyyymmdd, String inHireDate_yyyymmdd) {
        super(inFirstName, inLastName, inBirthDate_yyyymmdd);
        this.hireDate = LocalDate.parse(inHireDate_yyyymmdd, DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
    public short getExperience() {
        Period experience = Period.between(hireDate, LocalDate.now());
        return (short) experience.getYears();
    }
    public Employee getBoss() {
        return this.department.getHead();
    }
    public  Faculty getFaculty() {
        return this.department.getFaculty();
    }

    public void setDepartment(Department department) { // assume employee can work in only 1 department
        if (this.department == null) {
            this.department = department;
            this.department.addEmployee(this);
        }
        else {
            this.department.removeEmployee(this);
            this.department = department;
            this.department.addEmployee(this);
        }
    }
    public void fire(){
        counter--;
        fireDate = LocalDate.now();
    }

    public void fire(LocalDate inFireDate){
        counter--;
        fireDate = inFireDate;
        System.out.println(" fired ");
        // TODO check for date delta from now() throw new IllegalArgumentException

    }
    @Override
    public String toString(){
        if (fireDate != null) {
            return super.toString() + "; Hired: " + hireDate.toString() + "; Fired: " + fireDate.toString() ;
        }
        else {
            return super.toString() + "; Hired: " + hireDate.toString() ;
        }
    }

}
