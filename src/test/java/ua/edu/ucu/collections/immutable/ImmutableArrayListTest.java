package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private ImmutableArrayList empty;
    private ImmutableArrayList array;
    
    @Before
    public void setUp() {
        empty = new ImmutableArrayList();
        array = new ImmutableArrayList(new Integer[] {1, 2, 3, 4}, 4);
    }

    @Test
    public void testAdd() {
        ImmutableArrayList res = (ImmutableArrayList) empty.add(5);
        assertEquals(1, res.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithException() {
        ImmutableArrayList res = (ImmutableArrayList) empty.add(3, 2);
    }

    @Test
    public void testAddWithoutException() {
        ImmutableArrayList res = (ImmutableArrayList) array.add(2, 2);
        assertEquals(5, res.size());
        assertEquals(2, res.get(2));
    }

    @Test
    public void testAddAll() {
        ImmutableArrayList result = (ImmutableArrayList) array.addAll(new Object[] {5, 2, 3});
        assertEquals(7, result.size());
    }

    @Test
    public void testGet() {
        assertEquals(1, array.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithException() {
        array.set(12, 3);
    }

    @Test
    public void testSet() {
        ImmutableArrayList result = (ImmutableArrayList) array.set(3, 5);
        assertEquals(5, result.get(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithException() {
        array.remove(12);
    }

    @Test
    public void testRemoveWithoutException() {
        ImmutableArrayList result = (ImmutableArrayList) array.remove(3);
        assertEquals(3, result.size());
    }

    @Test
    public void testIndexOfWithElement() {
        int result = array.indexOf(2);
        assertEquals(1, result);
    }

    @Test
    public void testIndexOfWithoutElement() {
        int result = array.indexOf(12);
        assertEquals(-1, result);
    }

    @Test
    public void testSize() {
        int result = array.size();
        assertEquals(4, result);
    }

    @Test
    public void testClear() {
        ImmutableArrayList result = (ImmutableArrayList) array.clear();
        assertEquals(0, result.size());
    }

    @Test
    public void isEmpty() {
        assertTrue(empty.isEmpty());
        assertFalse(array.isEmpty());
    }
    @Test
    public void testToArray() {
        Integer[] result = (Integer[]) array.toArray();
        assertEquals(new Integer[] {1, 2, 3, 4}, result);
    }

    @Test
    public void testToString() {
        assertEquals(array.toString(), "[1, 2, 3, 4]");
    }








}
