package com.ppsdevelopment.converters;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class TransliterateTest {

    @Test
    void getSymbol() {
        String expected="a";;
        String str="а";
        String val = null;
        val = Transliterate.getSymbol(str);
        assertEquals(val, expected);
    }

    @Test
    void toTransliterate() {
        String actual="abvgd";;
        String str="абвгд";
        String val = null;
        val = Transliterate.toTransliterate(str);
        assertEquals(val, actual);
    }
}