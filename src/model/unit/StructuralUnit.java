package model.unit;

// To be inherited by Group, Department, Faculty.
// represents the name of Structural Unit

import model.common.Persistable;

public abstract class StructuralUnit extends Persistable {
    String title;
    //Constructor
    public StructuralUnit(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return title;
    }
}
