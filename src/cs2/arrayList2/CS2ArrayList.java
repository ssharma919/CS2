
package cs2.arrayList2;

import cs2.CS2List;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * This class creates an arrayList with all of its respective methods from an array
 * @param <E> The type of the objects inside the arrayList
 */
public class CS2ArrayList<E> implements CS2List<E>, Iterable<E> {

    private E[] myList;
    private int mySize;

    /**
     * Creates an instance of CS2List with mySize 0
     */
    public CS2ArrayList() {
        myList = (E[])(new Object[20]);
        mySize = 0;
    }

    /**
     * Returns mySize
     * @return Returns mySize
     */
    @Override
    public int size() {
        return this.mySize;
    }

    /**
     * Add an object to the end of the arrayList
     * @param obj Object you wish to add
     * @return Returns a boolean dependant on if an object was added or not
     */
    @Override
    public boolean add(E obj) {
        if (myList.length == mySize) this.expand();
        myList[mySize] = obj;
        mySize++;
        return true;
    }

    /**
     * Adds an object at a specified index
     * @param index Specified index at which the object is inserted
     * @param obj Object you wish to add
     */
    @Override
    public void add(int index, E obj) {
        if (myList.length == mySize || index >= mySize) this.expand();
        if (index < 0) throw new IndexOutOfBoundsException("Attempted to access an index outside of the boundaries");
        for (int i = this.size(); i > index; i--) {
            myList[i] = myList[i-1];
        }
        myList[index] = obj;
        mySize++;
    }

    /**
     * Returns an object at a specified index
     * @param index The specified index
     * @return Object from a specified index
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= mySize || mySize == 0) throw new IndexOutOfBoundsException("Attempted to access an index outside of the boundaries");
        return myList[index];
    }

    /**
     * Changes the object to a new one at a specified index
     * @param index The specified index
     * @param obj The new object
     * @return Returns the previous object
     */
    @Override
    public E set(int index, E obj) {
        if (index < 0 || index >= mySize || mySize == 0) throw new IndexOutOfBoundsException("Attempted to access an index outside of the boundaries");
        E temp = myList[index];
        myList[index] = obj;
        return temp;
    }

    /**
     * Removes the object at a specified index
     * @param index The specified index
     * @return Returns removed object
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= myList.length || mySize == 0) throw new IndexOutOfBoundsException("Attempted to access an index outside of the boundaries");
        E temp = myList[index];
        for (int i = index; i < mySize-1; i++) {
            myList[i] = myList[i+1];
        }
        mySize--;
        return temp;
    }

    /**
     * Returns a formatted array in String
     * @return The String
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < mySize; i++) {
            str += "[" + i + "]: " + myList[i] + " ";
        }
        return str;
    }

    /**
     * Expands the size of the arrayList if the capacity is reached
     */
    private void expand() {
        E[] arr = (E[])(new Object[(int)(1.5 * mySize)]);
        for (int i = 0; i < mySize; i++) {
            arr[i] = myList[i];
        }
        myList = arr;
    }

    /**
     * Returns the first index of a particular object
     * @param o The particular object
     * @return The index
     */
    public int indexOf(Object o) {
        for (int i = 0; i < mySize; i++) {
            if (myList[i].equals(o)) return i;
        }
        return -1;
    }

    /**
     * Returns the last index of a particular object
     * @param o The particular object
     * @return The index
     */
    public int lastIndexOf(Object o) {
        for (int i = mySize-1; i >= 0; i--) {
            if (myList[i].equals(o)) return i;
        }
        return -1;
    }

    /**
     * Clears the entire arrayList
     */
    public void clear() {
        mySize = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new CS2Iterator();
    }

    public ListIterator<E> listIterator() {
        return new CS2Iterator();
    }

    private class CS2Iterator implements Iterator<E>, ListIterator<E> {

        private int idx = 0;
        private boolean calledNext = false;
        private boolean calledPrevious = false;

        @Override
        public boolean hasNext() {
            return (idx < CS2ArrayList.this.mySize);
        }

        @Override
        public E next() {
            if (hasNext() == false) throw new IndexOutOfBoundsException("You are outside the array bounds");
            idx++;
            calledNext = true;
            return CS2ArrayList.this.get(idx-1);
        }

        @Override
        public boolean hasPrevious() {
            return (idx > CS2ArrayList.this.mySize);
        }

        @Override
        public E previous() {
            if (hasPrevious() == false) throw new IndexOutOfBoundsException("You are outside the array bounds");
            idx--;
            calledPrevious = true;
            return CS2ArrayList.this.get(idx+1);
        }

        @Override
        public int nextIndex() {
            return idx;
        }

        @Override
        public int previousIndex() {
            return idx-1;
        }

        public void remove() {
            if (calledNext == false || calledPrevious == false) throw new RuntimeException("Haven't called next");
            if (CS2ArrayList.this.mySize == 0) throw new NullPointerException("List does not have any items");
            if (calledNext || calledPrevious) {
                if (calledNext) {
                    CS2ArrayList.this.remove(idx - 1);
                    calledNext = false;
                    idx--;
                }
                if (calledPrevious) {
                    CS2ArrayList.this.remove(idx + 1);
                    calledPrevious = false;
                    idx++;
                }
            }
        }

        @Override
        public void set(E e) {
            if (calledPrevious) {
                CS2ArrayList.this.set(previousIndex(), e);
            }
            if (calledNext) {
                CS2ArrayList.this.set(nextIndex(), e);
            }
        }

        @Override
        public void add(E e) {
            CS2ArrayList.this.add(nextIndex(), e);
            idx++;
        }
    }
}
