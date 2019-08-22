package cs2.arrayList;

import cs2.CS2List;

public class CS2ArrayList<E> implements CS2List<E> {

    private E[] myList;
    private int mySize;

    public CS2ArrayList() {
        myList = (E[])(new Object[20]);
        mySize = 0;
    }

    @Override
    public int size() {
        return this.mySize;
    }

    @Override
    public boolean add(E obj) {
        return false;
    }

    @Override
    public void add(int index, E obj) {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E obj) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }
}
