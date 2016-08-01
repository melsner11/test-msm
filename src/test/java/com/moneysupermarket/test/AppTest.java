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
        apple.setColor(Color.GREEN);
        apple.setHasWorm(false);
        apple.setTaste(4);
        apple.peel(new Peeler());
        assertEquals(FruitState.PEELED, apple.getState());
    }

    @Test
    public void testStateDoNotPeelApple(){
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
        apple.setTaste(4);
        apple.setHasWorm(false);
        apple.setColor(Color.GREEN);
        apple.peel(new Peeler());
        apple.eat();
        assertEquals(FruitState.EATEN, apple.getState());
    }

    @Test
    public void testPeelAppleWithWorm(){
        Apple apple = new Apple();
        apple.setHasWorm(true);
        apple.setColor(Color.GREEN);
        apple.setTaste(4);
        apple.peel(new Peeler());
        assertNull(apple.getState());
    }

    @Test
    public void testPeelAppleWithTasteSmallerFour(){
        Apple apple = new Apple();
        apple.setTaste(3);
        apple.setHasWorm(false);
        apple.setColor(Color.GREEN);
        apple.peel(new Peeler());
        assertNull(apple.getState());
    }

    @Test
    public void testPeelAppleWithTasteFourAndNoWorm(){
        Apple apple = new Apple();
        apple.setTaste(4);
        apple.setHasWorm(false);
        apple.setColor(Color.BLUE);
        apple.peel(new ValyrianSteelPeeler());
        assertEquals(FruitState.PEELED, apple.getState());
    }

    @Test
    public void testPeelAppleWithNormalPeeler (){
        Apple apple = new Apple();
        apple.setColor(Color.GREEN);
        apple.setTaste(4);
        apple.setHasWorm(false);
        apple.peel(new Peeler());
        assertEquals(FruitState.PEELED, apple.getState());
    }

    @Test
    public void testPeelAppleWithoutPeeler (){
        Apple apple = new Apple();
        apple.setColor(Color.GREEN);
        apple.setTaste(4);
        apple.setHasWorm(false);
        apple.peel(null);
        assertNull(apple.getState());
    }
    
    public void testPeelBlueAppleWithSteelPeeler (){
        Apple apple = new Apple();
        apple.setColor(Color.BLUE);
        apple.setTaste(4);
        apple.setHasWorm(false);
        apple.peel(new ValyrianSteelPeeler());
        assertEquals(FruitState.PEELED, apple.getState());
    }

    @Test
    public void testPeelRedAppleWithSteelPeeler (){
        Apple apple = new Apple();
        apple.setColor(Color.RED);
        apple.setHasWorm(false);
        apple.setTaste(4);
        apple.peel(new ValyrianSteelPeeler());
        assertEquals(FruitState.PEELED, apple.getState());
    }

    @Test
    public void testPeelBlueAppleWithNormalPeeler (){
        Apple apple = new Apple();
        apple.setColor(Color.BLUE);
        apple.setHasWorm(false);
        apple.setTaste(4);
        apple.peel(new Peeler());
        assertNull(apple.getState());
    }

    @Test
    public void testPeelerWithRed (){
        Peeler peeler = new Peeler();
        assertTrue(peeler.canPeel(Color.RED));
    }

    @Test
    public void testPeelerWithBlue (){
        Peeler peeler = new Peeler();
        assertFalse(peeler.canPeel(Color.BLUE));
    }

    @Test
    public void testValyrianPeelerWithBlue (){
        Peeler peeler = new ValyrianSteelPeeler();
        assertTrue(peeler.canPeel(Color.BLUE));
    }

    @Test
    public void testValyrianPeelerWithGreen (){
        Peeler peeler = new ValyrianSteelPeeler();
        assertTrue(peeler.canPeel(Color.GREEN));
    }

    @Test
    public void testValyrianPeelerWithNull (){
        Peeler peeler = new ValyrianSteelPeeler();
        thrown.expect(NullPointerException.class);
        peeler.canPeel(null);
    }

    @Test
    public void testPeelerWithNull (){
        Peeler peeler = new Peeler();
        thrown.expect(NullPointerException.class);
        peeler.canPeel(null);
    }
}
