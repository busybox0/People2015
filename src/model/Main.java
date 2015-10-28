package model;

import model.person.Employee;
import model.person.Person;
import model.person.Student;
import model.unit.Department;
import model.unit.Faculty;
import model.unit.Group;
import model.unit.Speciality;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Employee rector = new Employee("Иван", "Цыганенко", "19600101", "20050101");
        Employee panch = new Employee("Иван", "Панченко", "19661101", "20050101");
        Employee vikt = new Employee("Виктор", "Погорелов", "19350101", "20150101");
        Employee pasch = new Employee("Иван", "Пащенко", "19710101", "20150101");
        Employee john = new Employee("John", "Smith", "19600506", "20150101");

        Faculty pediatry = new Faculty("Педиатрия",LocalDate.of(1890,9,1),(Employee)rector);
        Department daylight = new Department("Дневное",(Employee) panch,pediatry);
        Department evening = new Department("Вечернее",(Employee) john,pediatry);
        Speciality surgery = new Speciality("Хирургия",daylight);
        Speciality neonatology = new Speciality("Неонатолония",daylight);
        Group third = new Group("Группа 3", LocalDate.of(1996,9,1),neonatology,(Employee) vikt);
        Group fourth = new Group("Группа 4", LocalDate.of(1996,9,1),surgery,(Employee) pasch);

        for ( Employee e : new Employee[]{rector, panch, vikt}) {
            e.setDepartment(daylight);
        }
        for ( Employee e : new Employee[]{pasch,john}) {
            e.setDepartment(evening);
        }

        Student vita = new Student("Вита", "Петренко", "19771115", "19960820");
        Student sveta = new Student("Света", "Лесняк", "19790216", "19960821");
        Student oksana = new Student("Оксана", "Апанасенко", "19800308", "19960821");
        Student andrii = new Student("Андрей", "Головко", "19770520", "19960821");
        Student vova = new Student("Вова", "Чечеленко", "19770520", "19960821");
        Student lena = new Student("Лена", "Лысенко", "19791218", "19960821");
        john.fire();
//        System.out.println(john.toString() + "\n" + pasch.toString() + "\n" + lena.toString());
//        System.out.println(Employee.getTotalNumber());
//        pasch.fire();
        System.out.println(Employee.getTotalNumber() + " objects.");



        for (Student s : new Student[]{vita, sveta, oksana, andrii, vova, lena} ){
            s.setFaculty(pediatry);
        }
        for (Student s : new Student[]{vita, sveta, oksana}) {
            s.setGroup(third);

        }
//        System.out.println("vita.getGroup = " + vita.getGroup());
        for (Student s : new Student[]{andrii, vova, lena}) {
            s.setGroup(fourth);
        }

        System.out.println(vita.getGroup());
        System.out.println(vita.getGroup().getDepartment());
        System.out.println(vita.getGroup().getFaculty());
        third.setSpeciality(neonatology);
        fourth.setSpeciality(neonatology);



        System.out.println("pediatry.getStudentsNumber() = " + pediatry.getStudentsNumber());
        System.out.println("pediatry.getEmployeesNumber() = " + pediatry.getEmployeesNumber());




    }
}
