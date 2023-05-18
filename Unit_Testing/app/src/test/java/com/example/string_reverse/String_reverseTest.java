package com.example.string_reverse;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class String_reverseTest {
    String_reverse Reverse;
    @Before
    public void setUp() throws Exception {
        Reverse = new String_reverse();
    }

    @Test
    public void String_reverse_stringReverse_emptystring() {
        String result = Reverse.stringReverse("");
        assertEquals(result,"");
    }

    @Test
    public void String_reverse_stringReverse_SingleChar(){
        String result = Reverse.stringReverse("d");
        assertEquals(result,"d");
    }

    @Test
    public void String_reverse_stringReverse_ThreeChar() {
        String result = Reverse.stringReverse("Din");
        assertEquals(result,"niD");
    }

    @Test
    public void String_reverse_stringReverse_ASCIIchar() {
        String result = Reverse.stringReverse("1234.=-09");
        assertEquals(result,"90-=.4321");
    }

    @Test
    public void static_number() {
        int result = Reverse.static_number(1);
        assertEquals(result,3);
    }

    @Test
    public void static_number1() {
        int result = Reverse.static_number(1);
        assertEquals(result,1);
    }

    @Test
    public void static_number2() {
        int result = Reverse.static_number(1);
        assertEquals(result,2);
    }
}