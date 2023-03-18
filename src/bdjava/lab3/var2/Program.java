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
                    (short) (Math.random()*2)));
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
    }
}

class House {
    private int ID;
    private short num;
    private float square;
    private short floor;
    private short numberOfRooms;
    private String street;
    private String buildingType;
    private short serviceLifeInYears;
    private static int numberOfApartments;
    House(short num, float square, short floor, short numberOfRooms, String street,
          String buildingType, short serviceLifeInYears){
        this.num = num;
        this.square = square;
        this.floor = floor;
        this.numberOfRooms = numberOfRooms;
        this.street = street;
        this.buildingType = buildingType;
        this.serviceLifeInYears = serviceLifeInYears;
        this.ID = House.numberOfApartments;
        House.numberOfApartments++;
    }

    public HashMap<String, String> getHouse(){
        HashMap<String, String> buf = new HashMap<String, String>();
        buf.put("num", String.valueOf(this.num));
        buf.put("square", String.valueOf(this.square));
        buf.put("floor", String.valueOf(this.floor));
        buf.put("numberOfRooms", String.valueOf(this.numberOfRooms));
        buf.put("street", this.street);
        buf.put("buildingType", this.buildingType);
        return buf;
    }
    public void setHouse(HashMap<String, String> set){
        String buf = set.get("num");
        if(buf != null)
            this.num = Short.parseShort(buf);
        buf = set.get("square");
        if(buf != null)
            this.square = Short.parseShort(buf);
        buf = set.get("floor");
        if(buf != null)
            this.floor = Short.parseShort(buf);
        buf = set.get("numberOfRooms");
        if(buf != null)
            this.numberOfRooms = Short.parseShort(buf);
        buf = set.get("street");
        if(buf != null)
            this.street = buf;
        buf = set.get("buildingType");
        if(buf != null)
            this.buildingType = buf;
    }
    @Override
    public String toString() {
        return "ID: " + this.ID + " NUM: " + this.num + " SQUARE: " + this.square + " FLOOR: " + this.floor +
                " NUMBER_OF_ROOMS: " + this.numberOfRooms + " STREET: " + this.street + " BUILDING_TYPE: " +
                this.buildingType;
    }

    //Число комнат, минимальная шлощадь, минимальный этаж, максимальный этаж
    public static ArrayList<House> search(ArrayList<House> apartments, Short numberOfRooms, Float minSquare, Short minLvl, Short maxLvl){
        ArrayList<House> buf = new ArrayList<>();
        for(House ap : apartments){
            boolean hit = true;
            if(numberOfRooms != null)
                if(ap.numberOfRooms != numberOfRooms)
                    hit = false;
            if(minSquare != null)
                if(ap.square < minSquare)
                    hit = false;
            if(minLvl != null)
                if(ap.floor < minLvl)
                    hit = false;
            if(maxLvl != null)
                if(ap.floor > maxLvl)
                    hit = false;
            if(!hit)
                continue;
            buf.add(ap);
        }
        return buf;
    }
}

class Phone implements Comparable<Phone>{
    private int ID;
    private String name;
    private String surname;
    private String patronymic;
    private String address;
    private String creditCardNumber;
    private int debit;
    private int credit;
    private  short cityTalkTime;
    private short longDistanceCallTime;
    private static int numberOfSubscriber;
    Phone(String name, String surname, String patronymic, String address, String creditCardNumber,
          int debit, int credit, short cityTalkTime, short longDistanceCallTime){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.debit = debit;
        this.credit = credit;
        this.cityTalkTime = cityTalkTime;
        this.longDistanceCallTime = longDistanceCallTime;
        this.ID = Phone.numberOfSubscriber;
        Phone.numberOfSubscriber++;
    }

    public HashMap<String, String> getPhone(){
        HashMap<String, String> buf = new HashMap<String, String>();
        buf.put("name", this.name);
        buf.put("surname", this.surname);
        buf.put("patronymic", this.patronymic);
        buf.put("address", this.address);
        buf.put("creditCardNumber", this.creditCardNumber);
        buf.put("debit", String.valueOf(this.debit));
        buf.put("credit", String.valueOf(this.credit));
        buf.put("cityTalkTime", String.valueOf(this.cityTalkTime));
        buf.put("longDistanceCallTime", String.valueOf(this.longDistanceCallTime));
        return buf;
    }
    public void setPhone(HashMap<String, String> set){
        String buf = set.get("name");
        if(buf != null)
            this.name = buf;
        buf = set.get("surname");
        if(buf != null)
            this.surname = buf;
        buf = set.get("patronymic");
        if(buf != null)
            this.patronymic = buf;
        buf = set.get("address");
        if(buf != null)
            this.address = buf;
        buf = set.get("creditCardNumber");
        if(buf != null)
            this.creditCardNumber = buf;
        buf = set.get("debit");
        if(buf != null)
            this.debit = Integer.parseInt(buf);
        buf = set.get("credit");
        if(buf != null)
            this.credit = Integer.parseInt(buf);
        buf = set.get("cityTalkTime");
        if(buf != null)
            this.cityTalkTime = Short.parseShort(buf);
        buf = set.get("longDistanceCallTime");
        if(buf != null)
            this.longDistanceCallTime = Short.parseShort(buf);
    }

    @Override
    public int compareTo(Phone p) {
        int buf = this.name.compareToIgnoreCase(p.name);
        if(buf == 0)
            buf = this.surname.compareToIgnoreCase(p.surname);
        if(buf == 0)
            buf = this.patronymic.compareToIgnoreCase(p.patronymic);
        return buf;
    }

    @Override
    public String toString() {
        return "ID: " + this.ID + " name: " + this.name + " " + this.surname + " " + this.patronymic +
                " address: " + this.address + " creditCardNumber: " + this.creditCardNumber + " debit: " +
                this.debit + " credit: " + this.credit + " cityTalkTime: " + this.cityTalkTime +
                " longDistanceCallTime: " + this.longDistanceCallTime;
    }

    //Минимальное время внутригородских разговоров, кто использовал междугородную связь, вывод в алфовитном порядке
    public static ArrayList<Phone> search(ArrayList<Phone> subscribers, Short minTimeForCityCalls, Boolean isUsedLongDistanceCall,
                                          Boolean isSort){
        ArrayList<Phone> buf = new ArrayList<Phone>();
        for(Phone sub : subscribers){
            boolean hit = true;
            if(minTimeForCityCalls != null)
                if(sub.cityTalkTime < minTimeForCityCalls)
                    hit = false;
            if(isUsedLongDistanceCall != null)
                if(sub.longDistanceCallTime == 0 && isUsedLongDistanceCall)
                    hit = false;

            if(!hit)
                continue;
            buf.add(sub);
        }
        if(isSort != null)
            if(isSort)
                Collections.sort(buf);
        return buf;
    }
}