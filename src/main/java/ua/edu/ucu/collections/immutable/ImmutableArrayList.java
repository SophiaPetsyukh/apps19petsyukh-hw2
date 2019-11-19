package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    private final Object[] elements;
    private final int len;

    public ImmutableArrayList() {
        elements = new Object[0];
        len = 0;
    }

    public ImmutableArrayList(Object[] data, int len) {
        this.len = len;
        this.elements = Arrays.copyOf(data, len);
    }

    private void check(int i) {
        if (i < 0 || i > len) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return addAll(len, new Object[] {e});
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(len, c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        check(index);
        Object[] result = new Object[len + c.length];
        System.arraycopy(elements, 0, result, 0, index);
        System.arraycopy(c, 0, result, index, c.length);
        System.arraycopy(elements, index, result, index + c.length,
                len - index);
        return new ImmutableArrayList(result, result.length);
    }

    @Override
    public Object get(int index) {
        check(index);
        return elements[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        check(index);
        Object[] result = new Object[len - 1];
        for (int i = 0; i < index; i++) {
            result[i] = elements[i];
        }
        for (int j = index; j < result.length; j++) {
            result[j] = elements[j + 1];
        }
        return new ImmutableArrayList(result, result.length);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        check(index);
        Object[] result = Arrays.copyOf(elements, len);
        result[index] = e;
        return new ImmutableArrayList(result, len);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < len; i++) {
            if (elements[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return len;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList(new Object[] {}, 0);
    }

    @Override
    public boolean isEmpty() {
        return len == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, len);
    }

    @Override
    public String toString() {
        String result = Arrays.toString(toArray());
        return result;
    }
}
