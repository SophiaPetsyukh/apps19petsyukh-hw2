package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList empty;
    private ImmutableLinkedList array;
    
    @Before
    public void setUp() {
        empty = new ImmutableLinkedList();
        array = new ImmutableLinkedList(new Object[] {1, 2, 3, 4, 5});
    }

    @Test
    public void testAddToEmpty() {
        ImmutableLinkedList result = (ImmutableLinkedList) empty.add(5);
        assertEquals(1, result.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithException() {
        ImmutableLinkedList result = (ImmutableLinkedList) array.add(10, 5);
    }

    @Test
    public void testAddWithoutException() {
        ImmutableLinkedList result = (ImmutableLinkedList) array.add(2, 5);
        assertEquals(6, result.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllWithException() {
        ImmutableLinkedList result = (ImmutableLinkedList) array.addAll(10, new Object[] {1, 2});
    }

    @Test
    public void testAddAllWithoutException() {
        ImmutableLinkedList result = (ImmutableLinkedList) array.addAll(2, new Object[] {1, 2});
        assertEquals(7, result.size());
    }

    @Test
    public void testAddAllWithIndexZero() {
        ImmutableLinkedList result = (ImmutableLinkedList) array.addAll(0, new Object[] {1, 2, 3});
        assertEquals(8, result.size());
    }

    @Test
    public void testGet() {
        assertEquals(array.get(2), 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithException() {
        array.get(10);
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList result = (ImmutableLinkedList) array.remove(2);
        assertEquals(4, result.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithException() {
        ImmutableLinkedList result = (ImmutableLinkedList) array.remove(10);
    }

    @Test
    public void testRemoveWithIndexZero() {
        ImmutableLinkedList result = (ImmutableLinkedList) array.remove(0);
        assertEquals(4, result.size());
    }

    @Test
    public void testSet() {
        ImmutableLinkedList result = (ImmutableLinkedList) array.set(2, 4);
        assertEquals(4, result.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithException() {
        ImmutableLinkedList result = (ImmutableLinkedList) array.set(10, 4);
    }

    @Test
    public void testIndexOf() {
        int result = array.indexOf(2);
        assertEquals(1, result);
    }

    @Test
    public void testIndexOfWithoutElement() {
        int result = array.indexOf(10);
        assertEquals(-1, result);
    }

    @Test
    public void testSize() {
        int result = array.size();
        assertEquals(5, result);
    }

    @Test
    public void testClear() {
        ImmutableLinkedList result = (ImmutableLinkedList) array.clear();
        assertEquals(0, result.size());
    }

    @Test
    public void isEmpty() {
        assertTrue(empty.isEmpty());
        assertFalse(array.isEmpty());
    }

    @Test
    public void testToArray() {
        Object[] result = (Object[]) array.toArray();
        assertArrayEquals(new Object[] {1, 2, 3, 4, 5}, result);
    }

    @Test
    public void testToStringEmpty() {
        assertEquals(empty.toString(), "");
    }

    @Test
    public void testToString() {
        assertEquals(array.toString(), "1, 2, 3, 4, 5");
    }

    @Test
    public void testAddFirst() {
        ImmutableLinkedList result = array.addFirst(1);
        assertEquals(6, result.size());
    }

    @Test
    public void testAddLast() {
        ImmutableLinkedList result = array.addLast(1);
        assertEquals(6, result.size());
    }













}
