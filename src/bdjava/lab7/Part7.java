package bdjava.lab7;

import java.util.Arrays;

import static java.lang.System.out;

//6.Вывести в заданном тексте все слова, расположив их в алфавитном порядке.
public class Part7 {
    public static void main(String[] args) {
        String text = "это пример текста, который нужно обработать и вывести все слова в алфавитном порядке.";
        String[] words = text.split("[\\P{L}]+");
        Arrays.sort(words);
        for (String word : words) {
            out.println(word);
        }
    }
}
