package ArrayBasedStack;

import org.junit.*;

import static org.junit.Assert.*;

public class TestStack {
    Stack stack;

    @Before
    public void setUp() throws Exception {
        stack=new Stack(3);
    }

    @After
    public void tearDown() throws Exception {
        stack=null;
    }

    @Test
    public void testPush() {

        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
        } catch (StackOverflowException e) {
            fail();
        }

        try {
            stack.push(3);
            fail();
        } catch (StackOverflowException e) {
            assertEquals("Stack is full!",e.getMessage());
        }
    }

    @Test
    public void testPop() {
        try {
            stack.pop();
            fail();
        } catch (StackUnderflowException e) {
            assertEquals("Stack is empty!",e.getMessage());
        }

        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            assertEquals(3,stack.pop());
            assertEquals(2,stack.pop());
            assertEquals(1,stack.pop());
        } catch (StackOverflowException | StackUnderflowException e) {
            fail();
        }

        try {
            stack.pop();
            fail();
        } catch (StackUnderflowException e) {
            assertEquals("Stack is empty!",e.getMessage());
        }
    }

    @Test
    public void testPeek() {
        try {
            stack.peek();
            fail();
        } catch (StackUnderflowException e) {
           assertEquals("Stack is empty!",e.getMessage());
        }


        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            assertEquals(3,stack.peek());
            stack.pop();
            assertEquals(2,stack.peek());
            stack.pop();
            assertEquals(1,stack.peek());
            stack.pop();
        } catch (StackOverflowException | StackUnderflowException e ) {
            fail();
        }

        try {
            stack.peek();
            fail();
        } catch (StackUnderflowException e) {
            assertEquals("Stack is empty!",e.getMessage());
        }
    }

    @Test
    public void testSize() {
        assertEquals(0,stack.size());
        try {
            stack.push(1);
            assertEquals(1,stack.size());
            stack.push(2);
            assertEquals(2,stack.size());
            stack.push(3);
            assertEquals(3,stack.size());
            stack.pop();
            assertEquals(2,stack.size());
            stack.pop();
            assertEquals(1,stack.size());
            stack.pop();
            assertEquals(0,stack.size());

        } catch (StackOverflowException e) {
            fail();
        } catch (StackUnderflowException e) {
            fail();
        }


    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        try {
            stack.push(1);
            assertFalse(stack.isEmpty());
            stack.pop();
            assertTrue(stack.isEmpty());
        } catch (StackOverflowException | StackUnderflowException e) {
           fail();
        }

    }

    @Test
    public void testIsFull() {
        for(int i=0;i<3;i++){
            try {
                assertFalse(stack.isFull());
                stack.push(i);
            } catch (StackOverflowException e) {
                fail();
            }
        }

        assertTrue(stack.isFull());

        for(int i=0;i<3;i++){
            try {
                stack.pop();
                assertFalse(stack.isFull());
            }  catch (StackUnderflowException e) {
                throw new RuntimeException(e);
            }
        }
    }
}