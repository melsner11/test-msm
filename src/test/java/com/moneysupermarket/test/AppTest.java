package com.moneysupermarket.test;

import junit.framework.TestCase;
import com.moneysupermarket.test.Apple;

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
     * test create a new apple
     */
    public void testCreateApple()
    {
        Apple apple = new Apple();
        assertNotNull(apple);
    }
}
