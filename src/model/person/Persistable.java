package model.person;

/**
 * Created by max on 2015-10-14.
 */
public abstract class Persistable {
    static long counter = 0;
    protected long id; // to be visible from subclass
    long getTotalNumber;
    long getId() {
        return id;
    }
}
