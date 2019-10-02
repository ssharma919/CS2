package cs2.linkedList2;

public class TestRunner {
    public static void main(String[] args) {
        CS2LinkedList<Integer> lst = new CS2LinkedList<Integer>();
        System.out.println (lst);
        lst.add (25);
        lst.add (50);
        lst.add (75);
        lst.add (100);
        System.out.println (lst);
    }
}
