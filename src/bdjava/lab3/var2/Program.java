package bdjava.lab3.var2;
import org.jetbrains.annotations.NotNull;

import java.lang.Short;
import java.lang.Float;
import static java.lang.System.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.lang.Math;

/*
Создать классы, спецификации которых приведены ниже.
Определить конструкторы и методы setТип(), getТип(), toString().
Определить дополнительно методы в классе, создающем массив объектов.
Задать критерий выбора данных и вывести эти данные на консоль.
6. House: id, Номер квартиры, Площадь, Этаж, Количество комнат, Улица, Тип здания, Срок эксплуатации.
Создать массив объектов. Вывести:
a) список квартир, имеющих заданное число комнат;
b) список квартир, имеющих заданное число комнат и расположенных на этаже, который находится в заданном промежутке;
c) список квартир, имеющих площадь, превосходящую заданную.
7. Phone: id, Фамилия, Имя, Отчество, Адрес, Номер кредитной карточки, Дебет, Кредит, Время городских и
междугородных разговоров. Создать массив объектов. Вывести:
a) сведения об абонентах, у которых время внутригородских разговоров превышает заданное;
b) сведения об абонентах, которые пользовались междугородной связью;
c) сведения об абонентах в алфавитном порядке.
 */
public class Program {
    public static void main(String[] args) {
       /* out.println("Часть 1:");
        ArrayList<House> buf;
        ArrayList<House> l = new ArrayList<>();
        for(short i=0; i<20; i++)
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
        out.println();*/
//        out.println("Часть 2:");
//        ArrayList<String> names = new ArrayList<String>();
//        names.add("Дима");
//        names.add("Вова");
//        names.add("Ваня");
//        names.add("Лёня");
//        names.add("Гоша");
//        ArrayList<String> surname = new ArrayList<String>();
//        surname.add("Иванов");
//        surname.add("Борисов");
//        surname.add("Вадисов");
//        surname.add("Петросян");
//        surname.add("Степанов");
//        ArrayList<Phone> l2 = new ArrayList<>();
//        for(short i=0; i<10; i++)
//            l2.add(new Phone(names.get((int)(Math.random()*5)), surname.get((int)(Math.random()*5)), "Александрович",
//                    "Старый Гай 28 кв 5", "232354353", 21312, 6564, (short) (Math.random()*300),
//                    (short) (Math.random()*2)));
//        out.println("Сгенерированные абоненты:");
//        for(Phone ph : l2)
//            out.println(ph);
//        out.println();
//        out.println("Сведения об абонентах, у которых время внутригородских разговоров превышает заданное (150):");
//        ArrayList<Phone> buf2 = Phone.search(l2, (short)150, null, null);
//        for(Phone ph : buf2)
//            out.println(ph);
//        out.println();
//        out.println("Сведения об абонентах, которые пользовались междугородной связью:");
//        buf2 = Phone.search(l2, null, true, null);
//        for(Phone ph : buf2)
//            out.println(ph);
//        out.println();
//        out.println("Сведения об абонентах в алфавитном порядке:");
//        buf2 = Phone.search(l2, null, null, true);
//        for(Phone ph : buf2)
//            out.println(ph);
    }
}