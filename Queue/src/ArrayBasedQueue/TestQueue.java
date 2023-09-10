package ArrayBasedQueue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestQueue {
    Queue queue;

    @Before
    public void setUp() throws Exception {
        queue = new Queue(5);
    }

    @After
    public void tearDown() throws Exception {
        queue = null;
    }

    @Test
    public void testEnqueue() {
        try {
            queue.enqueue(1);
            assertEquals(1, queue.queue[queue.rear]);
            queue.enqueue(4);
            assertEquals(4, queue.queue[queue.rear]);
            queue.enqueue(18);
            assertEquals(18, queue.queue[queue.rear]);
            queue.enqueue(555);
            assertEquals(555, queue.queue[queue.rear]);
            queue.enqueue(9785);
            assertEquals(9785, queue.queue[queue.rear]);
        } catch (QueueOverflowException e) {
            fail();
        }

        try {
            queue.enqueue(1);
            fail();
        } catch (QueueOverflowException e) {
            assertEquals("Queue is full!", e.getMessage());
        }
    }

    @Test
    public void testDequeue() {
        try {
            queue.dequeue();
            fail();
        } catch (QueueUnderflowException e) {
            assertEquals("Queue is empty!", e.getMessage());
        }
        try {
            queue.enqueue(3);
            queue.enqueue(33);
            queue.enqueue(333);

            assertEquals(3, queue.dequeue());
            assertEquals(33, queue.dequeue());
            assertEquals(333, queue.dequeue());
        } catch (QueueOverflowException | QueueUnderflowException e) {
            fail();
        }
    }

    @Test
    public void testPeek() {
        try {
            queue.peek();
            fail();
        } catch (QueueUnderflowException e) {
            assertEquals("Queue is empty!",e.getMessage());
        }

        try {
            queue.enqueue(5);
            assertEquals(5,queue.peek());
            queue.enqueue(3);
            assertEquals(5,queue.peek());
            queue.dequeue();
            assertEquals(3,queue.peek());
            queue.dequeue();
        } catch (QueueUnderflowException | QueueOverflowException e) {
            fail();
        }

        try {
            queue.peek();
            fail();
        } catch (QueueUnderflowException e) {
            assertEquals("Queue is empty!",e.getMessage());
        }
    }

    @Test
    public void testIsFull() {
        assertFalse(queue.isFull());
        try {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            assertFalse(queue.isFull());
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            assertFalse(queue.isFull());
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);
            queue.enqueue(5);
            assertTrue(queue.isFull());
        } catch (QueueOverflowException | QueueUnderflowException e) {
            fail();
        }
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        try {
            queue.enqueue(1);
            queue.enqueue(3);
            queue.enqueue(5);
            assertFalse(queue.isEmpty());
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            assertTrue(queue.isEmpty());
        } catch (QueueOverflowException | QueueUnderflowException e) {
            fail();
        }
    }

    @Test
    public void testSize() {
        assertEquals(0,queue.size());
        try {
            queue.enqueue(1);
            queue.enqueue(10);
            assertEquals(2,queue.size());
            queue.dequeue();
            queue.dequeue();
            assertEquals(0,queue.size());
        } catch (QueueOverflowException | QueueUnderflowException e) {
            fail();
        }
    }
}
