package bdjava.lab5;
import bdjava.lab3.var1.ContinuedFraction;
import bdjava.lab3.var1.Fraction;
import java.io.*;
import java.util.Scanner;

import static java.lang.System.out;

public class Part1 {
    public static void main(String[] args) {
        try {
            String fileName1 = "./src/bdjava/lab5/text1.txt";
            String fileName2 = "./src/bdjava/lab5/text2.txt";

            out.println("Создаём цепные дроби...");
            ContinuedFraction cf1 = new ContinuedFraction((short) 3, 2f);
            out.println(cf1.toString());
            ContinuedFraction cf2 = new ContinuedFraction((short) 2, 0f);
            out.println(cf2.toString());
            out.println("На ноль всё делется по законам математики.");
            out.println(cf2.calculate(false));

            out.println("Записываем в файл...");
            FileOutputStream fOutSteam = new FileOutputStream(fileName1);
            ObjectOutputStream outputObjStream = new ObjectOutputStream(fOutSteam);
            out.println("d");
            outputObjStream.writeObject(cf1);
            outputObjStream.writeObject(cf2);
            fOutSteam.close();
            outputObjStream.close();

            out.println("Читаем из файла...");
            FileInputStream fInSteam = new FileInputStream(fileName1);
            ObjectInputStream inputObjStream = new ObjectInputStream(fInSteam);
            cf1 = (ContinuedFraction) inputObjStream.readObject();
            cf2 = (ContinuedFraction) inputObjStream.readObject();
            fOutSteam.close();
            inputObjStream.close();

            out.println("Смотрим, что причли из файла...");
            out.println(cf1.toString());
            out.println(cf2.toString());

            out.println("------------------------------------------------");
            out.println("Создаём обычные дроби...");
            Fraction f1 = new Fraction(3, 4);
            out.println(f1.toString());
//            Fraction f2 = new Fraction(0, 32);
//            out.println(f2.toString());
//            out.println("Провоцируем ситуацию деления на 0...");
            Fraction f2 = new Fraction(2, 32);
            out.println(f2.toString());
            out.println("Делим первую дробь на вторую 0...");
            out.println(Fraction.division(f1, f2).toString());

            out.println("Записываем в файл...");
            fOutSteam = new FileOutputStream(fileName2);
            outputObjStream = new ObjectOutputStream(fOutSteam);
            outputObjStream.writeObject(f1);
            outputObjStream.writeObject(f2);
            fOutSteam.close();
            outputObjStream.close();

            out.println("Читаем из файла...");
            fInSteam = new FileInputStream(fileName2);
            inputObjStream = new ObjectInputStream(fInSteam);
            f1 = (Fraction) inputObjStream.readObject();
            f2 = (Fraction) inputObjStream.readObject();
            fOutSteam.close();
            inputObjStream.close();

            out.println("Смотрим, что причли из файла...");
            out.println(f1.toString());
            out.println(f2.toString());

        } catch (ArithmeticException ex) {
            out.println("Арифметическая ошибка!\nСистемная ошибка:");
            out.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
            out.println("Файл не найден\nСистемная ошибка:");
            out.println(ex.getMessage());
        } catch (IOException ex) {
            out.println("Ошибка записи в поток или создания потока\nСистемная ошибка:");
            out.println(ex.getMessage());
            out.println(ex.getStackTrace().toString());
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            out.println("Не найден класс\nСистемная ошибка:");
            out.println(ex.getMessage());
        }
    }
}