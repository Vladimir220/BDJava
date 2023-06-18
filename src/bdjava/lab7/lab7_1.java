package bdjava.lab7;

import static java.lang.System.out;

//6.	После каждого слова текста, заканчивающегося заданной подстрокой, вставить указанное слово.
public class lab7_1 {
    public static void main(String[] args) {
        String text = "qsqs sa sdwdsa saeed a sxsa";
        String pattern = "\\b\\w+sa\\b";
        String newWord = "СЛОВО";
        String newText = text.replaceAll(pattern, "$0 " + newWord);

        out.println(newText);
    }
}
