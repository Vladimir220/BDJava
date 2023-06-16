package bdjava.lab5;
import org.jetbrains.annotations.NotNull;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.util.*;

import static java.lang.System.out;

public class Part3 {
    public static void main(String[] args) {
        if(args.length == 2) {
            try {
                String f1 = args[0];
                String f2 = args[1];
                PoemAnalyzer p = new PoemAnalyzer(f1, f2);
                p.estimateFrequencyNnAkhmatova();
            }
            catch (FileNotFoundException ex) {
                out.println(ex.getMessage());
            }
            catch (IOException ex) {
                out.println(ex.getMessage());
            }
        }
        else if (args.length == 0) {
            try {
                String f = "./src/bdjava/lab5/paths.txt";
                PoemAnalyzer p = new PoemAnalyzer(f);
                p.estimateFrequencyNnAkhmatova();
            }
            catch (FileNotFoundException ex) {
                out.println(ex.getMessage());
            }
            catch (IOException ex) {
                out.println(ex.getMessage());
            }
        }
        if(args.length == 2) {
            try {
                String f1 = args[0];
                String f2 = args[1];
                PoemAnalyzer p = new PoemAnalyzer(f1, f2);
                p.replacingLettersInZabolotsky();
            }
            catch (FileNotFoundException ex) {
                out.println(ex.getMessage());
            }
            catch (IOException ex) {
                out.println(ex.getMessage());
            }
        }
        else if (args.length == 0) {
            try {
                String f = "./src/bdjava/lab5/paths2.txt";
                PoemAnalyzer p = new PoemAnalyzer(f);
                p.replacingLettersInZabolotsky();
            }
            catch (FileNotFoundException ex) {
                out.println(ex.getMessage());
            }
            catch (IOException ex) {
                out.println(ex.getMessage());
            }
        }
    }
}

class PoemAnalyzer {
    private String source;
    private String target;
    static class WordRepetitions implements Comparable {
        private String word;
        private int count;
        public WordRepetitions (String word, int count) {
            this.word = word;
            this.count = count;
        }
        @Override
        public int compareTo(@NotNull Object o) {
            return this.count - ((WordRepetitions) o).count;
        }
        public String getWord() {
            return word;
        }
        public int getCount() {
            return count;
        }
        void inc () {
            this.count++;
        }
    }
    public static ArrayList <WordRepetitions> listForAkhmatova;
    static {
        listForAkhmatova = new ArrayList<WordRepetitions>();
        listForAkhmatova.add(new WordRepetitions("не знаю", 0));
        listForAkhmatova.add(new WordRepetitions("ничего", 0));
    }
    public PoemAnalyzer (String source, String target) throws FileNotFoundException, IOException {
        FileInputStream fi = new FileInputStream(source);
        FileOutputStream fo = new FileOutputStream(target);
        fi.close();
        fo.close();
        this.source = source;
        this.target = target;
    }
    public PoemAnalyzer (String fileParams) throws FileNotFoundException, NoSuchElementException, IOException {
        Scanner reader = new Scanner(new FileInputStream(fileParams));
        this.source = reader.nextLine();
        this.target = reader.nextLine();
        FileInputStream fi = new FileInputStream(this.source);
        FileOutputStream fo = new FileOutputStream(this.target);
        fi.close();
        fo.close();
        reader.close();
    }
    public void estimateFrequencyNnAkhmatova () throws NoSuchElementException, IOException {
        Scanner reader = new Scanner(new FileInputStream(this.source));
        FileOutputStream fo = new FileOutputStream(this.target);
        PrintStream pfo = new PrintStream(fo);

        String line;
        while (reader.hasNextLine()) {
            line = reader.nextLine();
            for (WordRepetitions s : this.listForAkhmatova) {
                String sample = s.getWord().toLowerCase();
                int index = line.toLowerCase().indexOf(sample);
                while (index != -1) {
                    s.inc();
                    index = line.indexOf(sample, index + 1);
                }
            }
        }
        Collections.sort(this.listForAkhmatova);
        for (WordRepetitions s : this.listForAkhmatova)
            pfo.println("Слово: " + s.getWord() + "\nКоличество в тексте: " + s.getCount() + "\n");
        pfo.close();
        reader.close();
        fo.close();
    }
    public void replacingLettersInZabolotsky () throws NoSuchElementException, IOException {
        Scanner reader = new Scanner(new FileInputStream(this.source));
        FileOutputStream fo = new FileOutputStream(this.target);
        PrintStream pfo = new PrintStream(fo);

        String line;
        while (reader.hasNextLine()) {
            line = reader.nextLine();
            String[] words = line.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                String firstLetter = words[i].substring(0, 1);
                String rest = words[i].substring(1);
                words[i] = firstLetter.toUpperCase() + rest;
            }
            String result = String.join(" ", words);
            pfo.println(result);
        }

        pfo.close();
        reader.close();
        fo.close();
    }
}