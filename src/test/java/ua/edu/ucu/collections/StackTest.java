package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class StackTest {
    private Stack s;
    
    @Before
    public void setUp() {
        s = new Stack();
    }

    @Test
    public void testPushAndPeek() {
        for (int i = 0; i < 10; i++) {
            s.push(i);
            assertEquals(i, s.peek());
        }
    }

    @Test
    public void testPop() {
        for (int i = 0; i < 5; i++) {
            s.push(i);
        }
        s.pop();
        assertEquals(1, s.peek());
    }
    
}
