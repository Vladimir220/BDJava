package bdjava.lab5;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static java.lang.System.out;

public class Part4 {
    public static void main(String[] args) {
        try {
            //String f = "./src/bdjava/lab5/target551.txt";
            String f = "./src/bdjava/lab5/target552.txt";
            TextAnalyzer p = new TextAnalyzer(f);
            //p.deletingWords();
            p.removeDuplicateSpaces();
        }
        catch (FileNotFoundException ex) {
            out.println(ex.getMessage());
        }
        catch (IOException ex) {
            out.println(ex.getMessage());
        }
    }
}

class TextAnalyzer {
    private String source;
    private String target;
    public TextAnalyzer (String source, String target) throws FileNotFoundException, IOException {
        FileInputStream fi = new FileInputStream(source);
        FileOutputStream fo = new FileOutputStream(target);
        fi.close();
        fo.close();
        this.source = source;
        this.target = target;
    }
    public TextAnalyzer (String fileParams) throws NoSuchElementException, IOException {
        Scanner reader = new Scanner(new FileInputStream(fileParams));
        this.source = reader.nextLine();
        this.target = reader.nextLine();
        FileInputStream fi = new FileInputStream(this.source);
        FileOutputStream fo = new FileOutputStream(this.target);
        fi.close();
        fo.close();
        reader.close();
    }
    public void deletingWords () throws NoSuchElementException, IOException {
        Scanner reader = new Scanner(new FileInputStream(this.source));
        FileOutputStream fo = new FileOutputStream(this.target);
        PrintStream pfo = new PrintStream(fo);

        String line;
        while (reader.hasNextLine()) {
            line = reader.nextLine();
            String[] words = line.split("\\s+");
            ArrayList <String> newLine = new ArrayList<String>();
            int allowableAmount = 0;
            int currentAmount = 0;
            for (String word : words)
                if ((word.length() >= 3 && word.length() <= 5)) {
                    allowableAmount++;
                }
            allowableAmount &= 0b11111111111111111111111111111110;
            for (String word : words) {
                if (word.length() < 3 || word.length() > 5) {
                    newLine.add(word);
                }
                else if (currentAmount != allowableAmount)
                {
                    newLine.add(word);
                    currentAmount++;
                }
            }
            String result = String.join(" ", newLine);
            pfo.println(result);
        }

        pfo.close();
        reader.close();
        fo.close();
    }
    public void removeDuplicateSpaces () throws NoSuchElementException, IOException {
        Scanner reader = new Scanner(new FileInputStream(this.source));
        FileOutputStream fo = new FileOutputStream(this.target);
        PrintStream pfo = new PrintStream(fo);

        String line;
        while (reader.hasNextLine()) {
            line = reader.nextLine();
            line = line.replaceAll("\\s+", " ");
            line = line.trim();
            pfo.println(line);
        }

        pfo.close();
        reader.close();
        fo.close();
    }
}