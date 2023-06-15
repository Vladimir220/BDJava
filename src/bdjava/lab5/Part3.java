package bdjava.lab5;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.out;

public class Part3 {
    public static void main(String[] args) {
        try {
            String fileName = "./src/bdjava/lab5/poem1.txt";
            FileInputStream fInSteam = new FileInputStream(fileName);
            Scanner reader = new Scanner(fInSteam);
        }
        catch (FileNotFoundException ex) {
            out.println(ex.getMessage());
        }
    }
}
