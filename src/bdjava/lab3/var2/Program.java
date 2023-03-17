package bdjava.lab3.var2;
import java.lang.Short;
import java.lang.Float;
import static java.lang.System.*;
import java.util.ArrayList;
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