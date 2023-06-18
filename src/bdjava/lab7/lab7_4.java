package bdjava.lab7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

//7. В тексте найти и напечатать все слова максимальной и все слова минимальной длины.
public class lab7_4 {
    public static void main(String[] args) {
        String text = "rwevrgvb3we qwsd sh s wefth4 qw i78 f";
        Pattern pattern = Pattern.compile("\\b\\w+\\b");

        Matcher matcher = pattern.matcher(text);

        int minLength = text.length();
        int maxLength = 0;
        String min = "";
        String max = "";

        int len;
        while (matcher.find()) {
            String word = matcher.group();
            len = word.length();
            if (len < minLength) {
                minLength = len;
                min = word;
            }
            if (len > maxLength) {
                maxLength = len;
                max = word;
            }
        }

        out.println("Минимальное слово: " + min);
        out.println("Максимальное слово: " + max);
    }
}