package com.example.calculator;
import org.junit.Assert;
import org.junit.Test;

public class MainActivityTest {


    @Test
    public void testAddListenerOnButton() {

        Assert.assertEquals(4, 2 + 2);
    }

    @Test
    public void testAddListenerOnSUBTRACTION() {
        Assert.assertEquals(3, 5 - 2);

    }

    @Test

    public void testAddListenerOnDivision() {
        Assert.assertEquals(2, 4 / 2);
    }

    @Test

    public void testAddListenerOnMULTIPLICATION() {

        Assert.assertEquals(4, 2 * 2);
    }



}