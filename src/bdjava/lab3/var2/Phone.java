package bdjava.lab3.var2;
import java.io.Serializable;
import bdjava.lab5.Lab5Exceptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Phone implements Comparable<Phone>, Serializable{
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
    public Phone(String name, String surname, String patronymic, String address, String creditCardNumber,
          int debit, int credit, short cityTalkTime, short longDistanceCallTime)
            throws Lab5Exceptions.NegativeNumberException, Lab5Exceptions.EmptyLineException{
        if (name.isEmpty())
            throw new Lab5Exceptions.EmptyLineException("Phone(...name...)");
        else this.name = name;
        if (surname.isEmpty())
            throw new Lab5Exceptions.EmptyLineException("Phone(...surname...)");
        else this.surname = surname;
        if (patronymic.isEmpty())
            throw new Lab5Exceptions.EmptyLineException("Phone(...patronymic...)");
        else this.patronymic = patronymic;
        if (address.isEmpty())
            throw new Lab5Exceptions.EmptyLineException("Phone(...address...)");
        else this.address = address;
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
