package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.System.out;


public class Part2 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        try {
            Scanner reader = new Scanner(new File("src/lab6/input.txt"));
            while (reader.hasNextLine()) {
                strings.add(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            out.println(e.getMessage());
            return;
        }

        Collections.sort(strings);
        for (String str : strings) {
            out.println(str);
        }
    }
}
