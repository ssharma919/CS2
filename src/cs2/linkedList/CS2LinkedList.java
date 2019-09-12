package cs2.linkedList;

import cs2.CS2List;

public class CS2LinkedList<E> implements CS2List<E> {
    ListNode head;

    public CS2LinkedList() {
        head = null;
    }

    @Override
    public int size() {
        return 0;
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
