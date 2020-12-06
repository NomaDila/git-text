package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextTest {

    private StringBuilder sb;
    private String[] array;
    private String[][] arr;
    private String word;


    @Before
    public void setUp() throws Exception {
        sb = new StringBuilder("Once upon a time a Wolf");
        array = new String[]{"once", "upon", "a", "time", "a", "wolf"};
        arr = new String[][]{{"once", "1"}, {"upon", "1"}, {"a", "2"}, {"time", "1"}, {"wolf", "1"}, {null, null}};
        word = "a";
    }

    @After
    public void tearDown() throws Exception {
        sb = null;
        array = null;
        arr = null;
        word = null;
    }

    @Test
    public void testGetArrayOfWordsFromText() {
        String[] actual = Text.getArrayOfWordsFromText(sb);
        String[] expected = array;
        assertArrayEquals(actual, expected);
    }

    @Test
    public void testGetNumberWordsInText() {
        int actual = Text.getNumberWordsInText(sb);
        int expected = 6;
        assertEquals(actual, expected);
    }

    @Test
    public void testGetArrayOfNonRepeatingWordsAndNumber() {
        String[][] actual = Text.getArrayOfNonRepeatingWordsAndNumber(array);
        String[][] expected = arr;
        assertArrayEquals(actual, expected);
    }

    @Test
    public void testGetNumberOccurrencesWordInArray() {
        int actual = Text.getNumberOccurrencesWordInArray(array, word);
        int expected = 2;
        assertEquals(actual, expected);
    }
}
