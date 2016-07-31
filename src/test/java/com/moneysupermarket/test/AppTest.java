package com.moneysupermarket.test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.moneysupermarket.test.Apple;

/**
 * Unit test
 */
public class AppTest {

    public AppTest(){
        super();
    }

    /**
     * Test create a new apple
     */
    @Test
    public void testCreateApple(){
        Apple apple = new Apple();
        assertNotNull(apple);
    }

    @Test
    public void testCreateAppleWithTasteInRange(){
        Apple apple = new Apple();
        apple.setTaste(3);
        assertEquals(3, apple.getTaste());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCreateAppleWithWrongTasteThrowsIllegalArgumentException(){
        Apple apple = new Apple();
        thrown.expect(IllegalArgumentException.class);
        apple.setTaste(12);
    }
}
