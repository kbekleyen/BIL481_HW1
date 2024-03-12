package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testFound() {
      Integer[] arr1 = new Integer[]{1,2,3,4};
      Integer[] arr2 = new Integer[]{1,2,3,4};
      assertEquals(App.massProcess(arr1,arr2,"Add","Round"), new Integer[]{2,4,6,8});
    }

    public void testNotFound() {
      
    }

    public void testEmptyArray() {
      
    }

    public void testNull() {
    
    }

}
