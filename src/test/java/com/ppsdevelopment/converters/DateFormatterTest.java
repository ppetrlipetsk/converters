package com.ppsdevelopment.converters;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {

    // data="01.12.2001" с разными разделителями
    //Остальные параметры null
    @org.junit.jupiter.api.Test
    void convertDateFormatWithNull() {
        String[] delimiters=new String[] {"/",".","\\"};
        String delimiter="-";
        for (int i=0;i<delimiters.length;i++)
        {
            String date="01"+delimiters[i]+"12"+delimiters[i]+"2001";
            String actual="2001"+delimiter+"12"+delimiter+"01";;
            String val=null;
            try {
                val=  DateFormatter.convertDateFormat(date,null,null,null);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            assertEquals(val,actual);
        }
    }

    // Определен формат исходный и заданный
    @org.junit.jupiter.api.Test
    void convertDateFormatWithFormatPattern() {
        String[] delimiters=new String[] {"/",".","\\"};
        String delimiter="-";
        String formatFrom="dd-MM-yyyy";
        String formatTo="dd.MM.yyyy";
        String actual="01.12.2001";;

        diffDelimitersLoop(delimiters, delimiter, formatFrom, formatTo, actual);
    }

    private void diffDelimitersLoop(String[] delimiters, String delimiter, String formatFrom, String formatTo, String actual) {
        for (int i = 0; i < delimiters.length; i++) {
            String date = "01" + delimiters[i] + "12" + delimiters[i] + "2001";

            String val = null;
            try {
                val = DateFormatter.convertDateFormat(date, formatFrom, formatTo, delimiter);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            assertEquals(val, actual);
        }
    }

    // Определен только исходный формат
    @org.junit.jupiter.api.Test
    void convertDateFormatWithFormatPattern1() {
        String[] delimiters=new String[] {"/",".","\\"};
        String formatFrom="dd-MM-yyyy";
        String actual="2001-12-01";;
        diffDelimitersLoop(delimiters, null, formatFrom, null, actual);
    }

    // Определен только заданный формат
    @org.junit.jupiter.api.Test
    void convertDateFormatWithFormatPattern2() {
        String[] delimiters=new String[] {"/",".","\\"};
        String delimiter="-";
        String formatTo="dd.MM.yyyy";
        String actual="01.12.2001";;
        diffDelimitersLoop(delimiters, delimiter, null, formatTo, actual);
    }

    // Определен только разделитель
    @org.junit.jupiter.api.Test
    void convertDateFormatWithDelimiter() {
        String[] delimiters=new String[] {"/",".","\\"};
        String delimiter="-";
        String actual="2001-12-01";;
        diffDelimitersLoop(delimiters, delimiter, null, null, actual);
    }


    // Задана неверная дата
    @org.junit.jupiter.api.Test
    void convertDateFormatWithFailDateValue() {
        String delimiter=".";
        String actual="2001-12-01";;
        String date="01w12w2001";
        String val = null;
        try {
            val = DateFormatter.convertDateFormat(date, "dd.MM.yyyy", null, delimiter);
        } catch (ParseException e) {
        }
        assertEquals(val, actual);
    }

}