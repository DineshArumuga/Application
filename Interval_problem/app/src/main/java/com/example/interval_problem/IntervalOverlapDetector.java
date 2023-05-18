package com.example.interval_problem;

public class IntervalOverlapDetector {
    public boolean isOverlap(Interval internal1,Interval internal2)
    {
        return internal1.getEnd() > internal2.getStart() && internal1.getStart() < internal2.getEnd();
    }
}
