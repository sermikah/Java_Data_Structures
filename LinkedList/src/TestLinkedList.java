import org.junit.*;

import static org.junit.Assert.*;

public class TestLinkedList {
    LinkedList linkedList;


    @Before
    public void setUp() throws Exception {
        linkedList = new LinkedList();
    }

    @After
    public void tearDown() throws Exception {
        linkedList = null;
    }

    @Test
    public void testAppend() {
        assertNull(linkedList.head);
        linkedList.append(1);
        assertEquals(1, linkedList.head.data);
        linkedList.append(2);
        assertEquals(2, linkedList.head.next.data);
    }

    @Test
    public void testPrepend() {
        assertNull(linkedList.head);
        linkedList.prepend(1);
        assertEquals(1, linkedList.head.data);
        linkedList.prepend(2);
        assertEquals(2, linkedList.head.data);
    }

    @Test
    public void testDelete() {
        assertNull(linkedList.head);
        try {
            linkedList.delete(1);
            fail();
        } catch (InvalidDataException e) {
            assertEquals("List does not contains 1", e.getMessage());
        }
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        assertEquals(1, linkedList.head.data);
        try {
            linkedList.delete(1);
            assertEquals(2, linkedList.head.data);
            linkedList.delete(2);
            assertEquals(3, linkedList.head.data);
            linkedList.delete(3);
            assertNull(linkedList.head);
        } catch (InvalidDataException e) {
            fail();
        }

        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);

        try {
            assertEquals(2, linkedList.head.next.data);
            linkedList.delete(2);
            assertEquals(3, linkedList.head.next.data);
        } catch (InvalidDataException e) {
            fail();
        }
    }

    @Test
    public void testContains() {
        assertNull(linkedList.head);
        assertFalse(linkedList.contains(1));

        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(24);
        assertTrue(linkedList.contains(24));
        try {
            linkedList.delete(24);
            assertFalse(linkedList.contains(24));
        } catch (InvalidDataException e) {
            fail();
        }
    }

    @Test
    public void testIsEmpty() {
        assertNull(linkedList.head);
        assertTrue(linkedList.isEmpty());
        linkedList.append(1);
        assertFalse(linkedList.isEmpty());
        try {
            linkedList.delete(1);
            assertTrue(linkedList.isEmpty());
        } catch (InvalidDataException e) {
            fail();
        }
    }

    @Test
    public void testIndexOf() {
        assertNull(linkedList.head);
        try {
            linkedList.indexOf(5);
            fail();
        } catch (InvalidDataException e) {
            assertEquals("List does not contains 5", e.getMessage());
        }

        linkedList.append(10);
        try {
            assertEquals(0, linkedList.indexOf(10));
            linkedList.append(3);
            linkedList.append(7);
            linkedList.append(2);
            assertEquals(3, linkedList.indexOf(2));
            linkedList.delete(7);
            assertEquals(2, linkedList.indexOf(2));

        } catch (InvalidDataException e) {
            fail();
        }
    }

    @Test
    public void testGet() {
        try {
            linkedList.get(5);
            fail();
        } catch (InvalidIndexException e) {
            assertEquals("Invalid Index!", e.getMessage());
        }
        linkedList.append(15);
        linkedList.append(5);
        linkedList.append(35);
        linkedList.append(27);
        try {
            assertEquals(35, linkedList.get(2));
            linkedList.delete(35);
            assertEquals(27, linkedList.get(2));
        } catch (InvalidIndexException | InvalidDataException e) {
            fail();
        }
    }

    @Test
    public void testClear() {
        assertNull(linkedList.head);
        linkedList.append(3);
        linkedList.append(5);
        assertNotNull(linkedList.head);
        linkedList.clear();
        assertNull(linkedList.head);
    }

    @Test
    public void testGetFirst() {
        assertNull(linkedList.head);
        try {
            linkedList.getFirst();
            fail();
        } catch (EmptyListException e) {
            assertEquals("List is empty!", e.getMessage());
        }

        linkedList.append(1);
        try {
            assertEquals(1, linkedList.getFirst());
            linkedList.delete(1);
        } catch (EmptyListException | InvalidDataException e) {
            fail();
        }

        try {
            linkedList.getFirst();
            fail();
        } catch (EmptyListException e) {
            assertEquals("List is empty!", e.getMessage());
        }

    }
//
    @Test
    public void testGetLast() {
        assertNull(linkedList.head);

        try {
            linkedList.getLast();
            fail();
        } catch (EmptyListException e) {
            assertEquals("List is empty!", e.getMessage());
        }

        linkedList.append(1);
        linkedList.append(11);
        linkedList.append(21);
        try {
            assertEquals(21, linkedList.getLast());
            linkedList.delete(21);
            assertEquals(11, linkedList.getLast());
        } catch (EmptyListException | InvalidDataException e) {
            fail();
        }
    }

    @Test
    public void testSize() {
        assertNull(linkedList.head);
        assertEquals(0,linkedList.size());

        for(int i = 0; i<3; i++){
            linkedList.append(i);
            assertEquals(i+1,linkedList.size());
        }

        for(int i = 2; i>=0; i--){
            try {
                linkedList.delete(i);
                assertEquals(i,linkedList.size());
            } catch (InvalidDataException e) {
                fail();
            }
        }
    }
}
