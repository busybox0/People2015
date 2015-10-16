package model.person;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Person john = new Employee("John", "Smith", "20000101", "20150101");
        Person dan = new Employee("Dan", "Smith", "20000101", "20150101");
        Person man = new Employee("Man", "Great", "20000101", "20150101");
        System.out.println(john);
        john.fire();
        System.out.println(john);
        System.out.println(dan);
        System.out.println(man);
        System.out.println(Employee.getTotalNumber());
        dan.fire();
        System.out.println(Employee.getTotalNumber());
        Person ed = new Employee("Ed", "Dille", "19600101", "20050101");
        System.out.println(ed);
        System.out.println(Employee.getTotalNumber());



    }
}
