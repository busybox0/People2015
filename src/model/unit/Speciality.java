package model.unit;

import java.util.ArrayList;
import java.util.List;

// Факультет готовит специалистов по следующим специальностям...
public class Speciality extends StructuralUnit{
    Object[] groups;
    Department department;
    List<Group> listGroups = new ArrayList<>();

    public Speciality(String title, Department department) {
        super(title);
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    public void addGroup(Group group) {
        listGroups.add(group);
    }
    public void removeGroup(Group group) {
        listGroups.remove(group);
    }
    public Group[] getGroups() {
        groups =  listGroups.toArray();
        return (Group[]) groups;
    }
}
