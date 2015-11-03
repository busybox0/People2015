package model.unit;

import java.util.ArrayList;
import java.util.List;

// Факультет готовит специалистов по следующим специальностям...
public class Speciality extends StructuralUnit{
    Group[] groups;
    Department department;
    List<Group> listGroups = new ArrayList<>();

    public Speciality(String title, Department department) {
        super(title);
        setDepartment(department);
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        if (this.department == null) {
            this.department = department;
            this.department.addSpeciality(this);
        }
        else {
            this.department.removeSpeciality(this);
            this.department = department;
            this.department.addSpeciality(this);
        }
    }
    public void addGroup(Group group) {
        listGroups.add(group);
    }
    public void removeGroup(Group group) {
        listGroups.remove(group);
    }
    public Group[] getGroups() {
        groups =  listGroups.toArray(new Group[listGroups.size()]);
        return groups;
    }
}
