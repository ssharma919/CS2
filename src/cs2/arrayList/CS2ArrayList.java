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
        if (myList.length == mySize) this.expand();
        myList[mySize] = obj;
        mySize++;
        return true;
    }

    @Override
    public void add(int index, E obj) {
        if (myList.length == mySize || index >= mySize) this.expand();
        if (index < 0) throw new IndexOutOfBoundsException();
        for (int i = this.size(); i > index; i--) {
            myList[i] = myList[i-1];
        }
        myList[index] = obj;
        mySize++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= mySize) throw new IndexOutOfBoundsException();
        return myList[index];
    }

    @Override
    public E set(int index, E obj) {
        if (index < 0 || index >= mySize) throw new IndexOutOfBoundsException();
        E temp = myList[index];
        myList[index] = obj;
        return temp;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= myList.length) throw new IndexOutOfBoundsException();
        E temp = myList[index];
        for (int i = index; i < mySize; i++) {
            myList[i] = myList[i+1];
        }
        mySize--;
        return temp;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < mySize; i++) {
            str += "[" + i + "]: " + myList[i] + " ";
        }
        return str;
    }

    private void expand() {
        E[] arr = (E[])(new Object[(int)(1.5 * mySize)]);
        for (int i = 0; i < mySize; i++) {
            arr[i] = myList[i];
        }
        myList = arr;
    }
}
