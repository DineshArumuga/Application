package com.example.string_reverse;

public class String_reverse {
    public static int count=0;
    public String stringReverse(String str)
    {
        String Rev="";
        for(int j=str.length()-1;j>=0;j--) {
            Rev += str.charAt(j);
        }
        return Rev;
    }
    public int static_number(int number)
    {
        int num;
        num = number + count++;
        return num;
    }
}
