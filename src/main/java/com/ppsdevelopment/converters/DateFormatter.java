package com.ppsdevelopment.converters;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс предоставляет статический метод преобразования строки даты в формате "dd.mm.yyyy" в строку формата "yyyy-mm-dd"
 */
public class DateFormatter {
    private static final String[] splitters=new String[]{"/",".","\\"};// SPLITTER_DOT =".";
    private static final String SPLITTER_HYPHEN ="-";
    private static final String DATE_FORMAT_FROM ="dd-MM-yyyy";
    private static final String DATE_FORMAT_TO ="yyyy-MM-dd";

    /**
     * Преобразует строку даты в из исходного формата в заданный формат. По умолчанию, из "dd-mm-yyyy" в строку формата "yyyy-mm-dd"
     * @param fdate строка даты в формате "dd-mm-yyyy" или "dd.mm.yyyy" или "dd/mm/yyyy"
     * @param formatFrom- исходный формат даты. Если null, то принимается формат "dd-MM-yyyy"
     * @param formatTo - заданный формат даты. Если null, то принимается формат "yyyy-MM-dd"
     * @param delimiter - разделитель. Если null, то принимается "-".
     * @return строка даты в заданном формате
     * @throws ParseException
     */
    public static String convertDateFormat(String fdate,String formatFrom, String formatTo, String delimiter) throws ParseException {
        if (formatFrom==null) formatFrom= DATE_FORMAT_FROM;
        if (formatTo==null) formatTo= DATE_FORMAT_TO;
        if (delimiter==null) delimiter=SPLITTER_HYPHEN;
        for (int i=0;i<splitters.length;i++){
            fdate.replace(splitters[i],delimiter);
        }

        DateFormat df=new SimpleDateFormat(formatTo);
        String s=null;
        try {
            Date date=new SimpleDateFormat(formatFrom).parse(fdate);
            s=df.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new ParseException("Ошибка преобразования формата даты: "+fdate+" формат источника:"+formatFrom+" формат назначения:"+formatTo,0);
        }
        return s;
    }
}
