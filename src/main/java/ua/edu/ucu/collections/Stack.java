package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList s;

    public Stack() {
        this.s = new ImmutableLinkedList();
    }

    public void push(Object elem) {
        s = s.addFirst(elem);
    }

    public Object peek() {
        return s.getFirst();
    }

    public Object pop() {
        Object elem = s.getFirst();
        s = s.removeFirst();
        return elem;
    }
}
