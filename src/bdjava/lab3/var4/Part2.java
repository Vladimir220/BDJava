package bdjava.lab3.var4;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

import static java.lang.System.out;

public class Part2 {
    public static void main(String[] args) {
        /*Service s = new Service("sw",2, (short) 44,3.5f,(short) 44,62);
        Service s2 = new Service("sw",2, (short) 44,3.5f,(short) 44,62);
        TreeSet<Service> t = new TreeSet<Service>();
        t.add(s);
        t.add(s2);
        out.println(t.remove(s2));*/
    }
}

class TelephoneExchange {

}
class Service implements Comparable <Service> {
    private final int ID;
    private static int numOfServices;
    private final String title;
    private final int cost;
    private final short period;
    private final float internetVolumeGB;
    private final short numOfSMS;
    private final int numOfMinutes;
    Service (String title, int cost, short period, float internetVolumeGB,short numOfSMS, int numOfMinutes) {
        this.ID = Service.numOfServices;
        Service.numOfServices++;
        this.title = title;
        this.period = period;
        this.cost = cost;
        this.internetVolumeGB = internetVolumeGB;
        this.numOfMinutes = numOfMinutes;
        this.numOfSMS = numOfSMS;
    }

    @Override
    public int compareTo(@NotNull Service o) {
        return (this.ID - o.ID);
    }

    public String getTitle () {
        return this.title;
    }
    public int getCost () {
        return this.cost;
    }
    public short getPeriod () {
        return this.period;
    }
    public float getInternetVolumeGB () {
        return this.internetVolumeGB;
    }
    public short getNumOfSMS () {
        return this.numOfSMS;
    }
    public int getNumOfMinutes () {
        return this.numOfMinutes;
    }
}
class Administrator {
    
}
class Subscriber {
    private final int ID;
    private static int numOfSubscribers;
    private final String name;
    private final String surname;
    private int balance;
    private TreeSet<Service> services;
    private boolean isBlocked;
    Subscriber (String name, String surname) {
        this.ID = Subscriber.numOfSubscribers;
        Subscriber.numOfSubscribers++;
        this.name = name;
        this.surname = surname;
        services = new TreeSet<Service>();
    }
    public void block () {
        this.isBlocked = true;
    }
    public void unlock () {
        this.isBlocked = false;
    }
    public int putMoney (int money) {
        this.balance += money;
        return this.balance;
    }
    public int payForServices (int money) {
        // Логику списания за услуги придумает оператор
        return this.balance;
    }
    public boolean addService (Service s) {
        return this.services.add(s);
    }
    public boolean delService (Service s) {
        return this.services.remove(s);
    }
}
