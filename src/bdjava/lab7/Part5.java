package bdjava.lab7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

//6.В предложении из n слов первое слово поставить на место второго, второе – на место третьего,
// и т.д., (n-1)-е слово – на место n-го, n-е слово поставить на место первого.
// В исходном и преобразованном предложениях между словами должны быть или один пробел, или знак препинания и один пробел.
public class Part5 {
    public static void main(String[] args) {
        String sentence = "qwe sdf hjk zxc";
        String regex = "\\b(\\w+\\b)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            result.append(matcher.group()).append(" ");
        }
        String[] words = result.toString().trim().split(" ");
        String firstWord = words[0];
        for (int i = 0; i < words.length - 1; i++) {
            words[i] = words[i + 1];
        }
        words[words.length - 1] = firstWord;
        String transformedSentence = String.join(" ", words);
        out.println(transformedSentence);
    }
}
