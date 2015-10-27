// Department is a child of Faculty and the parent of Speciality
package model.unit;
import model.person.Employee;
import java.util.ArrayList;
import java.util.List;

public class Department extends StructuralUnit{
    Speciality[] specialities;
    Employee[] employees;
    Employee head;
    Faculty faculty;
    List<Speciality>  listOfSpecialities = new ArrayList<>();
    List<Employee> listOfEmployees = new ArrayList<>();
    byte size; // this is the following-the-specs field. Of course int would be better here

    public Department(String title, Employee head, Faculty faculty) {
        super(title);
        this.head = head;
        this.faculty = faculty;
    }

    public Speciality[] getSpecialities() {
        specialities = listOfSpecialities.toArray(new Speciality[listOfSpecialities.size()] );
        return specialities;
    }

    public void addSpeciality(Speciality speciality) {
        listOfSpecialities.add(speciality);
    }
    public void removeSpeciality(Speciality speciality) {
        listOfSpecialities.remove(speciality);
    }

    public Employee[] getEmployees() {
        employees =  listOfEmployees.toArray(new Employee[listOfEmployees.size()]);
        return employees;
    }

    public void addEmployee(Employee employee) {
        listOfEmployees.add(employee);
    }
    public void removeEmployee(Employee employee) {
        listOfEmployees.remove(employee);
    }

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee head) {
        this.head = head;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public byte getSize() {
        size = (byte) listOfEmployees.size();
        return size;
    }


}
