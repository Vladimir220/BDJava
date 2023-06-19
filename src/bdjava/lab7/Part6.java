package bdjava.lab7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

///7.Текст шифруется по следующему правилу: из исходного текста выбирается 1, 4, 7, 10-й и т.д. (до конца текста)
// символы, затем 2, 5, 8, 11-й и т.д. (до конца текста) символы, затем 3, 6, 9, 12-й и т.д.
// Зашифровать заданный текст.
public class Part6 {
    public static void main(String[] args) {
        String text = "This is text to be encrypted.";
        out.println("Оригинальный текст: " + text);
        String encryptedText = encryptText(text);
        out.println("Закодированный текст: " + encryptedText);
    }

    public static String encryptText(String text) {
        Pattern pattern = Pattern.compile("(?<=.).");
        Matcher matcher = pattern.matcher(text);
        StringBuilder[] encryptedChars = new StringBuilder[3];

        encryptedChars[0] = new StringBuilder();
        encryptedChars[1] = new StringBuilder();
        encryptedChars[2] = new StringBuilder();

        int count = 0;
        while (matcher.find()) {
            out.println();
            count++;
            int index = count % 3;
            encryptedChars[index].append(matcher.group());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(encryptedChars[0]);
        sb.append(encryptedChars[1]);
        sb.append(encryptedChars[2]);
        return sb.toString();
    }
}
