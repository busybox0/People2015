package model.person;


public abstract class Persistable {
    static long counter = 1;
    private static long id_count =1 ; // 'protected' to be visible from subclass
    private long id; // 'protected' to be visible from subclass

    {
        // init
        id = id_count++;
        counter++; // gets deducted when person fired
        System.out.println("Hello from Persistable init, counter=" + counter);
    }

    final static long getTotalNumber(){
        return counter;
    }

    final long getId() {
        return id;
    }
}
