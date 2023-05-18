package com.example.interval_problem;

public class Interval {
    private final int mStart;
    private final int mEnd;

    public Interval(int Start, int End) {
        if(Start >= End){
            throw new IllegalArgumentException("invalid internal range");
        }
        this.mStart = Start;
        this.mEnd = End;
    }
    public int getStart()
    {
        return mStart;
    }
    public int getEnd()
    {
        return mEnd;
    }
}
