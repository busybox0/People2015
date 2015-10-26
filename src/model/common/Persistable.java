package model.common;


public abstract class Persistable {
    public static long counter = 1;
    private static long id_count =1 ; // 'protected' to be visible from subclass
    private long id; // 'protected' to be visible from subclass

    {
        // init
        id = id_count++;
        counter++; // gets deducted when person fired
        //System.out.println("Hello from Persistable init, counter=" + counter);
    }

    public final static long getTotalNumber(){
        return counter;
    }

    public final long getId() {
        return id;
    }
}
