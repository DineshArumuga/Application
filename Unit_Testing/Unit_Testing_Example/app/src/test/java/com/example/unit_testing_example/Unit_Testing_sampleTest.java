package com.example.unit_testing_example;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Unit_Testing_sampleTest {
    Unit_Testing_sample test;
    @Before
    public void Setup()
    {
        test = new Unit_Testing_sample();
    }

    @Test
    public void test1()
    {
        boolean result = test.isPositive(-1);
        assertEquals(result,false);
    }

    @Test
    public void test2()
    {
        boolean result = test.isPositive(1);
        assertEquals(result,true);
    }

    @Test
    public void test3()
    {
        boolean result = test.isPositive(0);
        assertEquals(result,false);
    }

    @Test
    public void test4()
    {
        boolean result = test.isPositive(Integer.parseInt("String"));
        assertEquals(result,false);
    }

    @Test
    public void test5()
    {
        boolean result = test.isPositive(1245698749);
        assertEquals(result,true);
    }

}