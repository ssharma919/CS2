package cs2.arrayList2;

import java.util.Iterator;

public class CS2ArrayListRunner {
    public static void main(String[] args) {
        CS2ArrayList<Double> list = new CS2ArrayList<Double>();

        // fill with random values

        for (int i=0; i<20; i++) {
            list.add (Math.random()-0.5);
        }

        // use an iterator to traverse the List


        Iterator<Double> it = list.iterator();
        while (it.hasNext()) {
            Double val = it.next();
            System.out.println (val + " ");
        }

        System.out.println (list);
        it = list.iterator();
        while (it.hasNext()) {
            if (it.next() < 0.0) it.remove();
        }
        System.out.println (list);
        System.out.println();

        try {
            it.remove();
            it.remove();
        }
        catch (Exception e) {
            System.out.println ("Caught error attempting multiple removes");
            System.out.println (e);
        }

        while(it.hasNext()) {
            it.next();
        }

        try {
            it.next();
        }
        catch (Exception e) {
            System.out.println ("Caught error attempting next at end of list");
            System.out.println (e);
        }
    }
}
