package cs2.stack;

import cs2.linkedList2.CS2LinkedList;

import java.util.Iterator;

public class CS2Stack<E> extends CS2LinkedList<E> {

    public E push(E item) {
        super.add(item);
        return item;
    }

    public E pop() {
        return super.remove(super.size()-1);
    }

    public boolean empty() {
        return super.size() == 0;
    }

    public E peek() {
        return super.get(0);
    }

    public int search(Object o) {
        Iterator<E> it = super.iterator();
        int i = 1;
        while (it.hasNext()) {
            if (it.next().equals(o)) return i;
            i++;
        }
        return -1;
    }

}
