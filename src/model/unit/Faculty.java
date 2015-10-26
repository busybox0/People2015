package model.unit;

import model.person.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Faculty extends StructuralUnit {
    LocalDate dateOfCreation;
    Department[] departments;
    Employee dean;
    List listOfDepartments = new ArrayList();

    public Faculty(String title, LocalDate dateOfCreation, Employee dean) {
        super(title);
        this.dateOfCreation = dateOfCreation;
        this.dean = dean;
    }

    public Faculty(String title, Employee dean) {
        super(title);
        this.dean = dean;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Department[] getDepartments() {
        departments = (Department[]) listOfDepartments.toArray();
        return departments;
    }

    public void addDepartment(Department department) {
        listOfDepartments.add(department);
    }

    public Employee getDean() {
        return dean;
    }

    public void setDean(Employee dean) {
        this.dean = dean;
    }

    //TODO getEmployeesNumber
    //TODO getStudentsNumber
}
