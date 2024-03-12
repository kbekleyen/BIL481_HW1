package com.mycompany.app;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testApp() {
        assertTrue(true);
    }

    public void testAdd() {
        Integer[] arr1 = new Integer[] { 1, 2, 3, 4 };
        Integer[] arr2 = new Integer[] { 1, 2, 3, 4 };
        assertTrue(Arrays.deepEquals(App.massProcess(arr1, arr2, "Add", "Round"), new String[] { "2", "4", "6", "8" }));
    }

    public void testSub() {
        Integer[] arr1 = new Integer[] { 1, 2, 3, 4 };
        Integer[] arr2 = new Integer[] { 1, 1, 1, 1 };
        assertTrue(Arrays.deepEquals(App.massProcess(arr1, arr2, "Add", "Round"), new String[] { "0", "1", "2", "3" }));
    }

    public void testMul() {
        Integer[] arr1 = new Integer[] { 1, 2, 3, 4 };
        Integer[] arr2 = new Integer[] { 1, 2, 3, 4 };
        assertTrue(Arrays.deepEquals(App.massProcess(arr1, arr2, "Add", "Round"), new String[] { "1", "4", "9", "16" }));
    }

    public void testDiv() {
        Integer[] arr1 = new Integer[] { 1, 2, 3, 4 };
        Integer[] arr2 = new Integer[] { 1, 1, 1, 1 };
        assertTrue(Arrays.deepEquals(App.massProcess(arr1, arr2, "Add", "Round"), new String[] { "1", "2", "3", "4" }));
    }

}
