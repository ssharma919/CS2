package cs2.queue;

import cs2.linkedList.CS2LinkedList;

public class CS2Queue<E> extends CS2LinkedList<E> {

    public E remove() {
        return super.remove(0);
    }

    public E peek() {
        if (super.size() == 0) return null;
        return super.get(0);
    }
}
