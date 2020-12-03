package com.ppsdevelopment.converters;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс предоставляет статический метод преобразования строки даты в формате "dd.mm.yyyy" в строку формата "yyyy-mm-dd"
 */
public class DateFormatter {
    private static final String[] splitters=new String[]{"/",".","\\"};;
    private static final String SPLITTER_HYPHEN ="-";
    private static final String DATE_FORMAT_FROM ="dd-MM-yyyy";
    private static final String DATE_FORMAT_TO ="yyyy-MM-dd";

    /**
     * Преобразует строку даты в из исходного формата в заданный формат. По умолчанию, из "dd-mm-yyyy" в строку формата "yyyy-mm-dd"
     * @param fdate строка даты в формате "dd-mm-yyyy" или "dd.mm.yyyy" или "dd/mm/yyyy"
     * @param formatFrom- исходный формат даты. Если null, то принимается формат "dd-MM-yyyy"
     * @param formatTo - заданный формат даты. Если null, то принимается формат "yyyy-MM-dd"
     * @param delimiter - разделитель, соответствующий исходному формату. Если null, то принимается "-".
     * @return строка даты в заданном формате
     * @throws ParseException
     */
    public static String convertDateFormat(String fdate,String formatFrom, String formatTo, String delimiter) throws ParseException {
        if (formatFrom==null) formatFrom= DATE_FORMAT_FROM;
        if (formatTo==null) formatTo= DATE_FORMAT_TO;
        if (delimiter==null) delimiter=SPLITTER_HYPHEN;
        for (int i=0;i<splitters.length;i++){
            fdate=fdate.replace(splitters[i],delimiter);
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

    /**
     * Дополняет строку даты нулями и числом столетия.
     * @param value- строка даты
     * @return строка даты формата dd/mm/yyyy
     * @throws Exception
     */
    public String normDateStr(String value) throws Exception {
        String[] splitter={".","/","-"};
        String[] d = null;//new String[];// value.split("/");
        int i=0;
        while((d==null||d.length==0)&&(i<splitter.length)){
            d=value.split(splitter[i]);
        }

        if (d.length == 3) {
            if (d[0].length() == 1) d[0] = "0" + d[0];
            if (d[1].length() == 1) d[1] = "0" + d[1];
            if (d[2].length() == 2) d[2] = "20" + d[2];
            return d[1] + "." + d[0] + "." + d[2];
        } else
            throw new Exception("Неверный формат строки даты! Строка даты:"+value);
    }
}
