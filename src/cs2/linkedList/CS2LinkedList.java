package cs2.linkedList;

import cs2.CS2List;

public class CS2LinkedList<E> implements CS2List<E> {
    ListNode head;

    public CS2LinkedList() {
        head = null;
    }

    @Override
    public int size() {
        ListNode aNode = head;
        int count = 0;
        while (aNode != null) {
            count++;
            aNode = aNode.getNext();
        }
        return count;
    }

    @Override
    public boolean add(E obj) {
        ListNode ln = new ListNode(obj);
        ListNode h = head;
        if (head == null) head = ln;
        else {
            while (h.getNext() != null) h = h.getNext();
            h.setNext(ln);
        }
        return true;
    }

    public String toString() {
        if (head == null) return "Empty List";
        String str = "";
        int count = 0;
        ListNode aNode = head;
        while (aNode != null) {
            str += "[" + count + "]:" + aNode.getValue() + " ";
            count++;
            aNode = aNode.getNext();
        }
        return str;
    }

    @Override
    public void add(int index, E obj) {
        if (index > this.size()-1 || index < 0) throw new IndexOutOfBoundsException("Index is outside the boundaries");
        ListNode ln = new ListNode(obj);
        if (index == 0) {
            ListNode prevH = head;
            head = ln;
            ln.setNext(prevH);
        } else if (index > 0 && index < this.size()-1){
            int count = index;
            ListNode aNode = head;
            while (count != 1) {
                aNode = aNode.getNext();
                count--;
            }
            ListNode prevI = aNode.getNext();
            aNode.setNext(ln);
            ln.setNext(prevI);
        } else {
            ListNode aNode = head;
            while (aNode.getNext() != null) aNode = aNode.getNext();
            aNode.setNext(ln);
        }

    }

    @Override
    public E get(int index) {
        if (index > this.size()-1 || index < 0) throw new IndexOutOfBoundsException("Index is outside the boundaries");
        int count = index;
        ListNode aNode = head;
        while (count != 0) {
            aNode = aNode.getNext();
            count--;
        }
        return aNode.getValue();
    }

    @Override
    public E set(int index, E obj) {
        if (index > this.size()-1 || index < 0) throw new IndexOutOfBoundsException("Index is outside the boundaries");
        int count = index;
        ListNode aNode = head;
        while (count != 0) {
            aNode = aNode.getNext();
            count--;
        }
        E prevObj = aNode.getValue();
        aNode.setValue(obj);
        return prevObj;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    private class ListNode {
        private E value;
        private ListNode next;

        public ListNode (E e) {
            value = e;
            next = null;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
