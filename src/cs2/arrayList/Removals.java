package cs2.arrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class Removals {
    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            lst.add((int)(Math.random()*21 - 10));
        }
        System.out.println(lst);

        Iterator<Integer> it = lst.iterator();
        while (it.hasNext()) {
            if (it.next() < 0) it.remove();
        }
        System.out.println(lst);


    }
}
