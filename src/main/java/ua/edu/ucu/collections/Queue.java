package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList q;

    public Queue() {
        this.q = new ImmutableLinkedList();
    }

    public Object peek() {
        return q.getFirst();
    }

    public void enqueue(Object e) {
        q = q.addLast(e);
    }

    public Object dequeue() {
        Object e = q.getFirst();
        q = q.removeFirst();
        return e;
    }
}
