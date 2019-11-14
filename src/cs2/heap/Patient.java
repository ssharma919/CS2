package cs2.heap;

public class Patient implements Comparable<Patient> {
    // constants for use with Patient object

    public static final int ASC = 0;    // ascending/descending sort
    public static final int DESC = 1;

    public static final int BY_NAME = 0;    //  name/condition priority
    public static final int BY_CONDITION = 1;

    public static final int BLACK = 1;  // Priority levels by color
    public static final int RED = 2;
    public static final int YELLOW = 3;
    public static final int GREEN = 4;
    public static final int WHITE = 5;

    public static final int EXPECTANT = 1;  // priority levels by descriptor
    public static final int IMMEDIATE = 2;
    public static final int OBSERVATION = 3;
    public static final int WAIT = 4;
    public static final int DISMISS = 5;

    private static int dir = ASC;   // default ascending
    private static int sortBy = BY_CONDITION;   // default by condition

    private String name;
    private int condition;

    public Patient(String name, int condition){
        this.name = name;
        this.condition = condition;
    }

    public int getCondition() {
        return condition;
    }

    public String getName() {
        return name;
    }

    public int compareTo(Patient other) {
        int comp;
        if (sortBy == BY_NAME) {
            comp = this.name.compareTo(other.name);
        }
        else {
            comp = this.condition - other.condition;
        }

        if (dir == ASC) {
            return comp;
        }
        else {
            return -1 * comp;
        }
    }

    public String toString(){
        if (sortBy == BY_NAME)
            return ("Name: " + name + "; Condition Level: "+ condition);
        else
            return ("Condition Level: " + condition + "; Name: " + name);
    }

    public static void setDirection(int direc){
        dir = direc;
    }
    public static void sortBy(int key){
        sortBy = key;
    }

}