package bdjava.lab3.var4;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
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

class TelephoneStation {
    private TreeSet <Subscriber> subscribers;
    private TreeSet <Service> services;
    private ArrayDeque<Administrator> freeAdmins;
    public boolean addService (int subID, int servID) {
        if (freeAdmins.size() == 0 && this.services != null && this.subscribers != null) return false;
        Administrator admin = this.freeAdmins.getFirst();
        Service serv = services.stream().filter(c -> subID == c.getID()).findAny().get();
        Subscriber sub = subscribers.stream().filter(c -> servID == c.getID()).findAny().get();
        boolean isAdd = admin.addService(sub, serv);
        this.freeAdmins.addLast(admin);
        return isAdd;
    }
    public boolean delService (int subID, int servID) {
        if (freeAdmins.size() == 0 && this.services != null && this.subscribers != null) return false;
        Administrator admin = this.freeAdmins.getFirst();
        this.busyAdmins.addLast(admin);
        Service serv = services.stream().filter(c -> subID == c.getID()).findAny().get();
        Subscriber sub = subscribers.stream().filter(c -> servID == c.getID()).findAny().get();
        return admin.delService(sub, serv);
    }

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
    public int getID() {
        return ID;
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
    private final int ID;
    private static int numOfAdmins;
    private final String name;
    private final String surname;

    Administrator (String name, String surname) {
        this.ID = Administrator.numOfAdmins;
        Administrator.numOfAdmins++;
        this.name = name;
        this.surname = surname;
    }
    public boolean addService (Subscriber sub, Service serv) {
        return sub.addService(serv);
    }
    public boolean delService (Subscriber sub, Service serv) {
        return sub.delService(serv);
    }
    public void block (Subscriber s) {
        s.block();
    }
    public int getID() {
        return ID;
    }
    public String getSurname() {
        return surname;
    }
    public String getName() {
        return name;
    }
    public void unlock (Subscriber s) {
        s.unlock();
    }
    public void cancelAll (Subscriber s) {
        s.cancelAll(s);
    }
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
    public void cancelAll (Subscriber s) {
        this.services = new TreeSet<Service>();
    }
    public boolean addService (Service s) {
        return this.services.add(s);
    }
    public boolean delService (Service s) {
        return this.services.remove(s);
    }
    public String getSurname() {
        return surname;
    }
    public String getName() {
        return name;
    }
    public int getBalance() {
        return balance;
    }
    public int getID() {
        return ID;
    }
    public boolean getIsBlocked () {
        return isBlocked;
    }
}
