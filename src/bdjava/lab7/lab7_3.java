package bdjava.lab7;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

//6. Напечатать без повторения слова текста, у которых первая и последняя буквы совпадают.
public class lab7_3 {
    public static void main(String[] args) {
        String text = "dwed www dwws wdd dd";
        Pattern p = Pattern.compile("\\b(\\w)\\w*\\1\\b");
        Matcher m = p.matcher(text);
        while (m.find()) {
            String word = m.group();
            out.println(word);
        }
    }
}
