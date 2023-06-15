package bdjava.lab5;
import bdjava.lab3.var1.ContinuedFraction;
import bdjava.lab3.var2.Phone;
import bdjava.lab3.var2.House;
import static java.lang.System.out;

import java.io.*;
import java.util.ArrayList;

public class Part2 {
    public static void main(String[] args) {
        out.println("Часть 1:");
        ArrayList<House> buf;
        ArrayList<House> l = new ArrayList<>();
        try {
            for (short i = 0; i < 20; i++)
                l.add(new House((short) (Math.random() * 100 + 1), (float) (Math.random() * 100 + 1),
                        (short) (Math.random() * 40 + 1), (short) (Math.random() * 10 + 1), "Вешняки",
                        "Жилое строение", (short) (Math.random() * 100 + 1)));
            out.println("Сгенерированные квартиры:");
            for(House ap : l)
                out.println(ap);
            out.println();
            out.println("Поиск по номеру квартиры (3):");
            buf = House.search(l, (short)3, null, null, null);
            for(House ap : buf)
                out.println(ap);
            out.println();
            out.println("Квартиры, имеющие заданное число комнат (3) и расположенных на этаже, " +
                    "который находится в заданном промежутке (2,25):");
            buf = House.search(l, (short)3, null, (short)2, (short)25);
            for(House ap : buf)
                out.println(ap);
            out.println();
            out.println("Квартиры, имеющие площадь, превосходящую 20 кв.м:");
            buf = House.search(l, null, 20f, null, null);
            for(House ap : buf)
                out.println(ap);
            out.println();
            String fileName = "./src/bdjava/lab5/text3.txt";
            out.println("Записываем в файл...");
            FileOutputStream fOutSteam = new FileOutputStream(fileName);
            ObjectOutputStream outputObjStream = new ObjectOutputStream(fOutSteam);
            outputObjStream.writeObject(l.get(0));
            fOutSteam.close();
            outputObjStream.close();
            out.println("Читаем из файла...");
            FileInputStream fInSteam = new FileInputStream(fileName);
            ObjectInputStream inputObjStream = new ObjectInputStream(fInSteam);
            House q = (House) inputObjStream.readObject();
            fOutSteam.close();
            inputObjStream.close();
            out.println("Смотрим, что причли из файла...");
            out.println(q.toString());

            out.println("Часть 2:");
            ArrayList<String> names = new ArrayList<String>();
            names.add("Дима");
            names.add("Вова");
            names.add("Ваня");
            names.add("Лёня");
            names.add("Гоша");
            ArrayList<String> surname = new ArrayList<String>();
            surname.add("Иванов");
            surname.add("Борисов");
            surname.add("Вадисов");
            surname.add("Петросян");
            surname.add("Степанов");
            ArrayList<Phone> l2 = new ArrayList<>();
            for(short i=0; i<10; i++)
                l2.add(new Phone(names.get((int)(Math.random()*5)), surname.get((int)(Math.random()*5)), "Александрович",
                        "Старый Гай 28 кв 5", "232354353", 21312, 6564, (short) (Math.random()*300),
                        (short) (Math.random()*100)));
            out.println("Сгенерированные абоненты:");
            for(Phone ph : l2)
                out.println(ph);
            out.println();
            out.println("Сведения об абонентах, у которых время внутригородских разговоров превышает заданное (150):");
            ArrayList<Phone> buf2 = Phone.search(l2, (short)150, null, null);
            for(Phone ph : buf2)
                out.println(ph);
            out.println();
            out.println("Сведения об абонентах, которые пользовались междугородной связью:");
            buf2 = Phone.search(l2, null, true, null);
            for(Phone ph : buf2)
                out.println(ph);
            out.println();
            out.println("Сведения об абонентах в алфавитном порядке:");
            buf2 = Phone.search(l2, null, null, true);
            for(Phone ph : buf2)
                out.println(ph);
            fileName = "./src/bdjava/lab5/text4.txt";
            out.println("Записываем в файл...");
            fOutSteam = new FileOutputStream(fileName);
            outputObjStream = new ObjectOutputStream(fOutSteam);
            outputObjStream.writeObject(l2.get(0));
            fOutSteam.close();
            outputObjStream.close();
            out.println("Читаем из файла...");
            fInSteam = new FileInputStream(fileName);
            inputObjStream = new ObjectInputStream(fInSteam);
            Phone q2 = (Phone) inputObjStream.readObject();
            fOutSteam.close();
            inputObjStream.close();
            out.println("Смотрим, что причли из файла...");
            out.println(q2.toString());
        }
        catch (Lab5Exceptions.NegativeNumberException ex) {
            out.println(ex.getMessage());
            out.println(ex.getErrorLocation());
        }
        catch (Lab5Exceptions.EmptyLineException ex) {
            out.println(ex.getMessage());
            out.println(ex.getErrorLocation());
        }
        catch (FileNotFoundException ex) {
            out.println("Файл не найден\nСистемная ошибка:");
            out.println(ex.getMessage());
        }
        catch (IOException ex) {
            out.println("Ошибка записи в поток или создания потока\nСистемная ошибка:");
            out.println(ex.getMessage());
            out.println(ex.getStackTrace().toString());
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            out.println("Не найден класс\nСистемная ошибка:");
            out.println(ex.getMessage());
        }
    }
}
