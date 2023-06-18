package bdjava.lab7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//7.	В зависимости от признака (0 или 1)
// в каждой строке текста удалить указанный символ везде, где он встречается, или вставить его после k-гo символа.
public class lab7_2 {
    public static void main(String[] args) {
        String text = "d3d3d3d3d3cccdsaaw33";
        char symbol = '3';
        // это признак
        boolean sign = true;
        int k = 3;

        if (sign) {
            String regex = String.valueOf(symbol);
            String res = text.replaceAll(regex, "");
            System.out.println("Результат: " + res);
        } else {
            String regex = "(.{1," + k + "})";
            String replacement = "$1" + symbol;
            String res = text.replaceAll(regex, replacement);
            System.out.println("Результат: " + res);
        }
    }
}
