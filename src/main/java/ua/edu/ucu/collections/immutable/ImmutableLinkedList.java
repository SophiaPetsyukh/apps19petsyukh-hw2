package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {
    private int len;
    private Node start;

    private static class Node {
        private Object value;
        private Node next;

        public Node(Object v, Node next) {
            this.value = v;
            this.next = next;
        }

        public Node(Object v) {
            this.value = v;
            this.next = null;
        }
    }

    public ImmutableLinkedList() {
        this.start = null;
        this.len = 0;
    }

    public ImmutableLinkedList(Object[] data) {
        len = data.length;
        start = new Node(data[0]);
        Node cur = start;
        int i = 1;
        while (i < len) {
            cur.next = new Node(data[i]);
            cur = cur.next;
            i++;
        }
    }

    private void check(int index) {
        if (index < 0 || index > len) {
            throw new IndexOutOfBoundsException();
        }
    }

    // Make a copy of linked list
    private ImmutableLinkedList copyOf() {
        if (isEmpty()) {
            return new ImmutableLinkedList();
        }
        ImmutableLinkedList result = new ImmutableLinkedList();
        result.len = len;
        result.start = new Node(start.value);
        Node curNode = start.next;
        Node newNode = result.start;
        while (curNode != null) {
            newNode.next = new Node(curNode.value);
            newNode = newNode.next;
            curNode = curNode.next;
        }
        return result;
    }

    // Find Node in linked list by given index
    private Node findNode(int index) {
        check(index);
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        Node curNode = start;
        for (int n = 0; n < index; n++) {
            curNode = curNode.next;
        }
        return curNode;
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        return add(len, e);
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        return addAll(len, c);
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        check(index);
        ImmutableLinkedList result = copyOf();
        Node curNode = result.start;
        if (isEmpty()) {
            return new ImmutableLinkedList(c);
        }
        else if (index == 0) {
            result.start = new Node(c[0], curNode);
            Node curNodeNew = result.start;
            int i = 1;
            while (i < c.length) {
                curNodeNew.next = new Node(c[i], curNode);
                curNodeNew = curNodeNew.next;
                i++;
            }
        }
        else {
            check(index - 1);
            int i = 0;
            while (i < index - 1) {
                curNode = curNode.next;
                i++;
            }
            int j = 0;
            while (j < c.length) {
                curNode.next = new Node(c[j], curNode.next);
                curNode = curNode.next;
                j++;
            }
        }
        result.len = len + c.length;
        return result;
    }


    @Override
    public Object get(int index) {
        return findNode(index).value;
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        check(index);
        ImmutableLinkedList result = copyOf();
        if (index == 0) {
            result.start = result.start.next;
        }
        else {
            Node prev = result.findNode(index - 1);
            prev.next = prev.next.next;
        }
        result.len = len - 1;
        return result;
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        check(index);
        ImmutableLinkedList result = copyOf();
        result.findNode(index).value = e;
        return result;
    }

    @Override
    public int indexOf(Object e) {
        int i = 0;
        Node curNode = start;
        while (curNode != null) {
            if (curNode.value.equals(e)) {
                return i;
            }
            i++;
            curNode = curNode.next;
        }
        return -1;
    }

    @Override
    public int size() {
        return len;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return len == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[len];
        Node curNode = start;
        int i = 0;
        while (curNode != null) {
            result[i] = curNode.value;
            curNode = curNode.next;
            i++;
        }
        return result;
    }

    @Override
    public String toString() {
        if (start == null) {
            return "";
        }
        StringBuilder result = new StringBuilder(start.value.toString());
        Node curNode = start;
        while (curNode.next != null) {
            curNode = curNode.next;
            result.append(", ").append(curNode.value.toString());

        }
        return result.toString();
    }

    public ImmutableLinkedList addFirst(Object e) {
        return add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(e);
    }

    public Object getFirst() {
        return get(0);
    }

    public Object getLast() {
        return get(len - 1);
    }

    public ImmutableLinkedList removeFirst() {
        return remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return remove(len - 1);
    }

}
