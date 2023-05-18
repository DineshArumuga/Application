package com.example.interval_problem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IntervalOverlapDetectorTest {
    IntervalOverlapDetector intervalOverlapDetector;

    @Before
    public void setUp()  {
        intervalOverlapDetector = new IntervalOverlapDetector();
    }

    //Interval1 is Before Interval2
    @Test
    public void test1() {
        Interval interval1 = new Interval(-1,5);
        Interval interval2 = new Interval(8,12);
        Boolean result = intervalOverlapDetector.isOverlap(interval1,interval2);
        assertEquals(result,false);
    }

    //Interval1 overlaps Interval2 on start
    @Test
    public void test2() {
        Interval interval1 = new Interval(-1,5);
        Interval interval2 = new Interval(3,12);
        Boolean result = intervalOverlapDetector.isOverlap(interval1,interval2);
        assertEquals(result,true);
    }

    //Interval1 is contained within Interval2
    @Test
    public void test3() {
        Interval interval1 = new Interval(-1,5);
        Interval interval2 = new Interval(-4,12);
        Boolean result = intervalOverlapDetector.isOverlap(interval1,interval2);
        assertEquals(result,true);
    }

    //Interval1 contains Interval2
    @Test
    public void test4() {
        Interval interval1 = new Interval(-1,5);
        Interval interval2 = new Interval(0,3);
        Boolean result = intervalOverlapDetector.isOverlap(interval1,interval2);
        assertEquals(result,true);
    }

    //Interval1 overlaps Interval2 on end
    @Test
    public void test5() {
        Interval interval1 = new Interval(-1,5);
        Interval interval2 = new Interval(-4,4);
        Boolean result = intervalOverlapDetector.isOverlap(interval1,interval2);
        assertEquals(result,true);
    }

    //Interval1 is after Interval2
    @Test
    public void test6() {
        Interval interval1 = new Interval(-1,5);
        Interval interval2 = new Interval(-10,-3);
        Boolean result = intervalOverlapDetector.isOverlap(interval1,interval2);
        assertEquals(result,false);
    }
}