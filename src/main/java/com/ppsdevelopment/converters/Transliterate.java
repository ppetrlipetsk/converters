package com.ppsdevelopment.converters;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс предоставляет статический метод транслитерации символов из кирилицы в латиницу
 */

public class Transliterate {
    final static String[] cir={"а","б","в","г","д","е","ё","ж","з","и","й","к","л","м","н","о","п","р","с","т","у","ф","х","ц","ч","ш","щ","ь","ы","ъ","э","ю","я","А","Б","В","Г","Д","Е","Ё","Ж","З","И","Й","К","Л","М","Н","О","П","Р","С","Т","У","Ф","Х","Ц","Ч","Ш","Щ","Ь","Ы","Ъ","Э","Ю","Я"};
    final static String[] lat={"a","b","v","g","d","e","e","zh","z","i","i","k","l","m","n","o","p","r","s","t","u","f","h","ts","ch","sh","sh","","iy","","e","yu","ya","A","B","V","G","D","E","E","ZH","Z","I","I","K","L","M","N","O","P","R","S","T","U","F","H","TS","CH","SH","SH","","IY","","E","YU","YA"};
    final static String[][] CHARS={{"/","_"},{"\\","_"},{" ","_"},{"@","_"},{"`","_"},{"\"","_"},{"'","_"},{".","_"},{",","_"},{"№","N"},{"#","N"},{"-","_"},{"(",""},{")",""},{"'","''"}};

    static Map<String,String> charCodeCirLat;

    static {
        charCodeCirLat =new HashMap();
        fillCharCode();
    }

    public Transliterate(){
        charCodeCirLat =new HashMap();
        fillCharCode();
    }

    private static void fillCharCode() {
        for(int i=0;i<cir.length;i++){
            charCodeCirLat.put(cir[i],lat[i]);
        }
        for (int i=0;i<CHARS.length;i++)
            charCodeCirLat.put(CHARS[i][0],CHARS[i][1]);
    }

    /**
     * Возвращает символ в латинской кодировке.
     * @param s символ в кирилической кодировке.
     * @return символ в латинской кодировке.
     */
    public static String getSymbol(String s){
        if (charCodeCirLat.containsKey(s))
        return charCodeCirLat.get(s);
        else
            return s;
    }

    /**
     * Метод возвращает транслитерированную строку
     * @param text- текстовая строка в кодировке кириллица.
     * @return текстовая строка в кодировке латиница.
     */
    public static String toTransliterate(String text){
        StringBuilder dest = new StringBuilder(text.length());
        for(int i = 0, n = text.length() ; i < n ; i++) {
            char c = text.charAt(i);
            if (charCodeCirLat.containsKey(String.valueOf(c))) {
                dest.append(charCodeCirLat.get(String.valueOf(c)));
            }
            else {
                dest.append(c);
            }
        }
        return dest.toString();
    }


}
