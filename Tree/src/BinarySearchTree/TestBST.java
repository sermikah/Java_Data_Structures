package BinarySearchTree;

import org.junit.*;

import static org.junit.Assert.*;

public class TestBST {
    BinarySearchTree bst;

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Starting to execute tests.");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Creating BST object!");
        bst = new BinarySearchTree();
    }

    @Test
    public void testInsert() {
        System.out.println("Starting to test BST.Insert()");
        assertNull(bst.root);

        bst.insert(20);
        assertNotNull(bst.root);
        assertEquals(20,bst.root.data);

        assertNull(bst.root.left);
        assertNull(bst.root.right);

        bst.insert(10);
        assertNotNull(bst.root.left);
        assertNull(bst.root.right);
        assertEquals(10,bst.root.left.data);

        bst.insert(30);
        assertNotNull(bst.root.right);
        assertEquals(30,bst.root.right.data);
        System.out.println("Passed to test BST.Insert()");
    }

    @Test
    public void testDelete() {
        assertNull(bst.root);
        bst.insert(10);
        assertNotNull(bst.root);
        assertEquals(10,bst.root.data);

        bst.delete(10);
        assertNull(bst.root);

        buildTree();

        assertNotNull(bst.root.left.left.left);
        assertEquals(6,bst.root.left.left.left.data);
        bst.delete(6);
        assertNull(bst.root.left.left.left);

        assertNotNull(bst.root.left.left);
        assertEquals(12,bst.root.left.left.data);
        assertNotNull(bst.root.left.left.right);
        assertEquals(18,bst.root.left.left.right.data);

        bst.delete(12);
        assertNull(bst.root.left.left.right);
        assertEquals(18,bst.root.left.left.data);

        assertNotNull(bst.root.left);
        assertEquals(25,bst.root.left.data);
        assertNotNull(bst.root.left.right.left);
        assertEquals(27,bst.root.left.right.left.data);

        bst.delete(25);
        assertNotNull(bst.root.left);
        assertEquals(27,bst.root.left.data);
        assertNull(bst.root.left.right.left);
    }

    private void buildTree() {
        bst.insert(50);
        bst.insert(25);
        bst.insert(75);
        bst.insert(12);
        bst.insert(35);
        bst.insert(60);
        bst.insert(90);
        bst.insert(6);
        bst.insert(18);
        bst.insert(27);
        bst.insert(40);
        bst.insert(55);
        bst.insert(65);
        bst.insert(85);
        bst.insert(95);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Deleting BST object!");
        bst = null;
        System.out.println("-----------------------------------------------");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Ending to execute tests.");
    }
}
