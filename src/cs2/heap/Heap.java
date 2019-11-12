package cs2.heap;

import java.util.ArrayList;

public class Heap<E extends Comparable<E>> {

    private ArrayList<E> list = new ArrayList<>();

    public void add(E obj) { // fix the parent to be changed inside the while loop
        list.add(obj);
        int parent = this.parent(this.size()-1);
        while (obj.compareTo(list.get(parent)) < 0) {
            E temp = list.get(parent);
            list.set(parent, obj);
            list.set(this.size()-1, temp);
        }
    }

    private int rightChild(int i) {
        return ((i*2)+2);
    }

    private int leftChild(int i) {
        return ((i*2)+1);
    }

    private int parent(int i) {
        return ((i-1)/2);
    }

    private int level(int i) {
        return (int) (Math.floor(Math.log(i+1)/Math.log(2)));
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
}
