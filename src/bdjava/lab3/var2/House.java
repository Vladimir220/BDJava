package bdjava.lab3.var2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import bdjava.lab5.Lab5Exceptions;

public class House implements Serializable {
    private int ID;
    private short num;
    private float square;
    private short floor;
    private short numberOfRooms;
    private String street;
    private String buildingType;
    private short serviceLifeInYears;
    private static int numberOfApartments;
    public House(short num, float square, short floor, short numberOfRooms, String street,
          String buildingType, short serviceLifeInYears) throws Lab5Exceptions.NegativeNumberException, Lab5Exceptions.EmptyLineException {
        if (num <= 0)
            throw new Lab5Exceptions.NegativeNumberException("House(...num...)", Integer.toString(this.num));
        else this.num = num;
        if (square <= 0)
            throw new Lab5Exceptions.NegativeNumberException("House(...square...)", Float.toString(this.square));
        else this.square = square;
        if (floor <= 0)
            throw new Lab5Exceptions.NegativeNumberException("House(...floor...)", Integer.toString(this.floor));
        else this.floor = floor;
        if (numberOfRooms <= 0)
            throw new Lab5Exceptions.NegativeNumberException("House(...numberOfRooms...)", Integer.toString(this.numberOfRooms));
        else this.numberOfRooms = numberOfRooms;
        if (street.isEmpty())
            throw new Lab5Exceptions.EmptyLineException("House(...street...)");
        else this.street = street;
        if (buildingType.isEmpty())
            throw new Lab5Exceptions.EmptyLineException("House(...buildingType...)");
        else this.buildingType = buildingType;
        if (serviceLifeInYears <= 0)
            throw new Lab5Exceptions.NegativeNumberException("House(...serviceLifeInYears...)", Integer.toString(this.numberOfRooms));
        else this.serviceLifeInYears = serviceLifeInYears;
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




