package com.ppsdevelopment.converters;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс предоставляет статический метод транслитерации символов из кирилицы в латиницу
 */

public class Transliterate {
    static String[] cir={"а","б","в","г","д","е","ё","ж","з","и","й","к","л","м","н","о","п","р","с","т","у","ф","х","ц","ч","ш","щ","ь","ы","ъ","э","ю","я"};
    static String[] lat={"a","b","v","g","d","e","e","zh","z","i","i","k","l","m","n","o","p","r","s","t","u","f","h","ts","ch","sh","sh","","iy","","e","yu","ya"};
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
            if (charCodeCirLat.containsKey(c)) {
                dest.append(charCodeCirLat.get(c));
            }
            else {
                dest.append(c);
            }
        }
        return dest.toString();
    }

}
