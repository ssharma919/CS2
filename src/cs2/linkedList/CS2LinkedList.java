package cs2.linkedList;

import cs2.CS2List;

public class CS2LinkedList<E> implements CS2List<E> {
    private ListNode head;
    private int mySize;
    private ListNode tail;

    public CS2LinkedList() {
        head = null;
        tail = null;
        mySize = 0;
    }

    @Override
    public int size() {
//        ListNode aNode = head;
//        int count = 0;
//        while (aNode != null) {
//            count++;
//            aNode = aNode.getNext();
//        }
//        return count;
        return mySize;
    }

    @Override
    public boolean add(E obj) {
        ListNode newValue = new ListNode(obj);
        ListNode endPointer = tail;
        if (head == null){
            head = newValue;
            tail = newValue;
            mySize++;
            return true;
        }
        else {
            endPointer.setNext(newValue);
            mySize++;
            tail = endPointer.getNext();
            return true;
        }
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
        if (index > this.size() || index < 0) throw new IndexOutOfBoundsException("Index is outside the boundaries");
        ListNode newValue = new ListNode(obj);
        ListNode pointer = head;
        ListNode endPointer = tail;
        if (head == null) {
            head = newValue;
        } else if (index == mySize) {
            endPointer.setNext(newValue);
            mySize++;
            tail = endPointer.getNext();
        } else {
            for (int i = 0; i < index - 1; i++) {
                pointer = pointer.getNext();
            }
            ListNode aNode = pointer.getNext();
            pointer.setNext(newValue);
            newValue.setNext(aNode);
        }
        mySize++;
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
        if (index > this.size()-1 || index < 0) throw new IndexOutOfBoundsException("Index is outside the boundaries");
        if (head == null) {
            throw new RuntimeException("Attempted to remove from empty list.");
        }
        if (head.getNext() == null && index == 0) {
            ListNode originalHead = head;
            head = null;
            tail = null;
            mySize--;
            return originalHead.getValue();
        } else if (index == 0) {
            ListNode originalHead = head;
            head = head.next;
            mySize--;
            return originalHead.getValue();
        } else {
            ListNode pointer = head;
            for (int i = 0; i < index - 1; i++) {
                pointer = pointer.getNext();
            }
            E obj = pointer.next.getValue();
            pointer.setNext(pointer.next.next);
            mySize--;
            return obj;
        }
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
