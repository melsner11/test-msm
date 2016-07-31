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

    @Test
    public void testCreateAppleWithWeightInRange(){
        Apple apple = new Apple();
        apple.setWeight(10);
        assertEquals(10, apple.getWeight());
    }

    @Test
    public void testCreateAppleWithWeightOutOfRangeThrowsIllegalArgumentException(){
        Apple apple = new Apple();
        thrown.expect(IllegalArgumentException.class);
        apple.setWeight(9);
    }

    @Test
    public void testSetColor(){
        Apple apple = new Apple();
        apple.setColor(Color.GREEN);
        assertNotNull(apple.getColor());
    }

    @Test
    public void testSetColorBlue(){
        Apple apple = new Apple();
        apple.setColor(Color.BLUE);
        assertEquals(Color.BLUE, apple.getColor());
    }

    @Test
    public void testSetState(){
        Apple apple = new Apple();
        apple.setState(FruitState.PEELED);
        assertNotNull(apple.getState());
    }

    @Test
    public void testSetStateEaten(){
        Apple apple = new Apple();
        apple.setState(FruitState.EATEN);
        assertEquals(FruitState.EATEN, apple.getState());
    }

    @Test
    public void testPeelApple(){
        Apple apple = new Apple();
        apple.peel();
        assertEquals(FruitState.PEELED, apple.getState());
        
    }

    @Test
    public void testDoNotPeelApple(){
        Apple apple = new Apple();
        assertNull(apple.getState());
        
    }

    @Test
    public void testEatNotPeeledApple(){
        Apple apple = new Apple();
        apple.eat();
        assertNull(apple.getState());
        
    }

    @Test
    public void testEatAPeeledApple(){
        Apple apple = new Apple();
        apple.peel();
        apple.eat();
        assertEquals(FruitState.EATEN, apple.getState());
    }
}
