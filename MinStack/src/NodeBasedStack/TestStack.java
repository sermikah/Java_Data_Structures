package NodeBasedStack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestStack {

    Stack stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack();
    }

    @After
    public void tearDown() throws Exception {
        stack = null;
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(15);
        assertFalse(stack.isEmpty());
        try {
            stack.pop();
            assertTrue(stack.isEmpty());
        } catch (StackUnderFlowException e) {
            fail();
        }

    }

    @Test
    public void testPush() {
        assertNull(stack.top);
        stack.push(10);
        assertNotNull(stack.top);
        assertEquals(10, stack.top.data);
        stack.push(15);
        assertEquals(15, stack.top.data);
    }

    @Test
    public void pop() {
        assertNull(stack.top);
        stack.push(420);
        stack.push(15);

        try {
            assertEquals(15, stack.pop());
            assertEquals(420, stack.pop());
            assertNull(stack.top);
        } catch (StackUnderFlowException e) {
            fail();
        }
    }

    @Test
    public void testPeek() {
        assertNull(stack.top);
        try {
            stack.peek();
            fail();
        } catch (StackUnderFlowException e) {
            assertEquals("Stack is Empty",e.getMessage());
        }

        stack.push(55);
        try {
            assertEquals(55,stack.peek());
        } catch (StackUnderFlowException e) {
            fail();
        }
    }

    @Test
    public void testClear() {
        stack.push(555);
        assertNotNull(stack.top);
        stack.clear();
        assertNull(stack.top);
    }
}

/*







 */


