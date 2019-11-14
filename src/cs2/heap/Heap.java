package cs2.heap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Heap<E extends Comparable<E>> {

    private ArrayList<E> list;

    public Heap() {
        list = new ArrayList<>();
    }


    public void add(E obj) {
        list.add(obj);
        int parent = this.parent(this.size() - 1);
        while (obj.compareTo(list.get(parent)) < 0) {
            E temp = list.get(parent);
            list.set(list.indexOf(obj), temp);
            list.set(parent, obj);
            parent = this.parent(parent);
        }
    }

    public E remove() {
        if (this.size() == 0) throw new NullPointerException("Attempted to remove from empty heap");
        if (this.size() == 1) {
            E temp = list.get(0);
            this.clear();
            return temp;
        } else {
            E temp = list.get(0);
            list.set(0, list.remove(this.size() - 1));
            E obj = list.get(0);
            int index = 0;
            while ((this.size() > this.leftChild(index) && this.size() > this.rightChild(index)) && (obj.compareTo(list.get(this.leftChild(index))) > 0 || obj.compareTo(list.get(this.rightChild(index))) > 0)) {
                if (list.get(this.leftChild(index)).compareTo(list.get(this.rightChild(index))) < 0) {
                    E tempLeft = list.get(this.leftChild(index));
                    list.set(this.leftChild(index), obj);
                    list.set(index, tempLeft);
                    index = list.indexOf(obj);
                } else {
                    E tempRight = list.get(this.rightChild(index));
                    list.set(this.rightChild(index), obj);
                    list.set(index, tempRight);
                    index = list.indexOf(obj);
                }
            }
            return temp;
        }
    }

    private int rightChild(int i) {
        return ((i * 2) + 2);
    }

    private int leftChild(int i) {
        return ((i * 2) + 1);
    }

    private int parent(int i) {
        return ((i - 1) / 2);
    }

    private int level(int i) {
        return (int) (Math.floor(Math.log(i + 1) / Math.log(2)));
    }

    public String toString() {
        return toString(0, 0);
    }

    private String toString(int index, int level) {
        if (this.isEmpty()) return "Empty Heap";
        if (this.size() <= index) return "";
        String s = toString(this.rightChild(index), level + 1);
        for (int i = 0; i < level; i++) s += "- ";
        s = s + list.get(index) + "\n";
        s += toString(this.leftChild(index), level + 1);
        return s;
    }

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return (this.size() == 0);
    }

    public Iterator<E> iterator() {
        return new CS2HeapIterator();
    }

    private class CS2HeapIterator implements Iterator<E> {
        ArrayList<E> list;
        private int iterNext;

        public CS2HeapIterator() {
            for (int i = 0; i < Heap.this.size(); i++) {
                list.add(Heap.this.remove());
            }
            for (int i = 0; i < list.size(); i++) {
                Heap.this.add(list.get(i));
            }
        }

        public E next() {
            if (!hasNext()) throw new RuntimeException("There are no more items in the list");
            E obj = list.get(iterNext);
            iterNext++;
            return obj;
        }

        public boolean hasNext() {
            return !(iterNext >= list.size());
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
