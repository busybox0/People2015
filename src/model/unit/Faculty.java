package model.unit;

import model.person.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Faculty extends StructuralUnit {
    LocalDate dateOfCreation;
    Department[] departments;
    Employee dean;
    List<Department> listOfDepartments = new ArrayList<>();

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
        departments =  listOfDepartments.toArray(new Department[listOfDepartments.size()]);
        return departments;
    }

    public void addDepartment(Department department) {
        listOfDepartments.add(department);
    }

    public void removeDepartment(Department department) {
        listOfDepartments.remove(department);
    }

    public Employee getDean() {
        return dean;
    }

    public void setDean(Employee dean) {
        this.dean = dean;
    }
    public int getEmployeesNumber() {
        int size = 0;
        for (Department d : listOfDepartments) {
            size += (int) d.getSize();
        }
        return size;
    }
    public int getStudentsNumber() {
        int size = 0;
        for (Department d : listOfDepartments) {
            for (Speciality s : d.getSpecialities()){
                for (Group g : s.getGroups()) {
                    size += (int) g.getSize();
                }
            }
        }
    return size;
    }
}
