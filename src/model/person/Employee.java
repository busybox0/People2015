package model.person;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee extends Person {

    LocalDate hireDate;
    LocalDate fireDate;

    // Constructor1
    Employee(String inFirstName, String inLastName, LocalDate inBirthDate, LocalDate inhireDate) {
        super(inFirstName, inLastName, inBirthDate);
        this.hireDate = inhireDate;
    }
    // Constructor2
    Employee(String inFirstName, String inLastName, String inBirthDate_yyyymmdd, String inHireDate_yyyymmdd) {
        super(inFirstName, inLastName, inBirthDate_yyyymmdd);
        this.hireDate = LocalDate.parse(inHireDate_yyyymmdd, DateTimeFormatter.ofPattern("yyyyMMdd"));
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
