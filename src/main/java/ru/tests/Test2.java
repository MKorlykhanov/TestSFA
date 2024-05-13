package ru.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test2 {

    @Test
    public void testIntNumberMore0AndLess10() {
        assertEquals(53, foo(1));
        assertEquals(53, foo(9));
        assertEquals(-1, foo(0));
        assertEquals(-1, foo(10));
    }

    @Test
    public void testIntNumberMore25AndLess78() {
        assertEquals(41, foo(26));
        assertEquals(41, foo(77));
        assertEquals(-1, foo(25));
        assertEquals(-1, foo(78));
    }

    @Test
    public void testIntNumberMore125() {
        assertEquals(112, foo(126));
        assertEquals(112, foo(Integer.MAX_VALUE));
        assertEquals(-1, foo(125));
    }

    @Test
    public void testIntAnotherNumbers() {
        assertEquals(-1, foo(-1));
    }

    //Исходный код Димы
    int foo(int number) {
        int result = 0;
        if (number > 0 && number < 10) {
            result = 53;
        } else if (number > 25 && number < 78) {
            result = 41;
        } else if (number > 125) {
            result = 112;
        } else {
            result = -1;
        }
        return result;
    }
}