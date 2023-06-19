package bdjava.lab7;

import static java.lang.System.out;

public class Part8 {
    public static void main(String[] args) {
        String text = "Жццв РРт Дц ц иа";
        String[] words = text.split("\\s+");
        int count = 0;
        for (String word : words) {
            if (word.matches("\\p{Lu}\\p{L}*")) {
                count++;
                out.println(word);
            }
        }
        out.println("Количество слов, начинающихся с прописной буквы: " + count);
    }

}
