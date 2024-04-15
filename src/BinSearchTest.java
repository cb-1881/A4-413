import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BinSearchTest {
    private BinSearch<Integer> intTree;

    @Before
    public void setUp() {
        intTree = new BinSearch<>();
        // Set up the tree with some default values
        intTree.insert(10);
        intTree.insert(5);
        intTree.insert(15);
        intTree.insert(3);
        intTree.insert(20);
        intTree.insert(7);
    }

    @Test
    public void testInsertAndContainsNode() {
        assertFalse("Should not contain 99", intTree.containsNode(99));
        intTree.insert(99);
        assertTrue("Should now contain 99", intTree.containsNode(99));
    }

    @Test
    public void testContainsNodeFalse() {
        assertFalse("Should not contain 100", intTree.containsNode(100));
    }

    @Test
    public void testDeleteAll() {
        intTree.deleteAll();
        assertFalse("Should not contain 10", intTree.containsNode(10));
        assertFalse("Should not contain 5", intTree.containsNode(5));
        assertFalse("Should not contain 15", intTree.containsNode(15));
    }

    @Test
    public void testInorderTraversal() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        intTree.inorderTraversal();
        assertEquals("3 5 7 10 15 20 ", outContent.toString());
    }

    @Test
    public void testPreorderTraversal() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        intTree.preorderTraversal();
        assertEquals("10 5 3 7 15 20 ", outContent.toString());
    }

    @Test
    public void testPostorderTraversal() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        intTree.postorderTraversal();
        assertEquals("3 7 5 20 15 10 ", outContent.toString());
    }



    public static void main(String[] args) {
        // Running the test cases using JUnitCore
        Result result = JUnitCore.runClasses(BinSearchTest.class);

        // Print the results of the test cases
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        // Print a success or failure message based on the test results
        if (result.wasSuccessful()) {
            System.out.println("All tests finished successfully!");
        } else {
            System.out.println("Some tests failed.");
        }
    }

}

