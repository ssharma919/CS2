package cs2.linkedList2;

import java.util.Iterator;

public class Part2Tester {
    public static void main(String[] args) {
        CS2LinkedList<Double> list = new CS2LinkedList<Double>();

        for (int i=0; i<25; i++) {
            list.add(Math.random());
        }


// print using toString
        System.out.println (list);

// print using conventional for-loop:
        for (int i=0; i<list.size(); i++) {
            System.out.print (list.get(i) + " ");
        }
        System.out.println ();

// use an iterator to traverse the List
        Iterator<Double> it = list.iterator();
        while (it.hasNext()) {
            Double val = it.next();
            System.out.println (val + " ");
        }

        System.out.println();
        System.out.println("Removing all values larger than 0.1");
        Iterator<Double> it1 = list.iterator();
        while (it1.hasNext()) {
            if (it1.next() > .1) it1.remove();
        }
        for (int i=0; i<list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }


    }
}
