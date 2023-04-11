package bdjava.lab3.var4;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.TreeSet;

import static java.lang.System.out;

public class Part2 {
    public static void main(String[] args) {
        TelephoneStation ts = new TelephoneStation();
        out.println(ts.getInfo(0));
        ts.putMoney(0, 233);
        ts.addService(0, 0);
        out.println(ts.getInfo(0));
        ts.changeNum(0, "+7(342)683-35-67");
        ts.delService(0,0);
        ts.putMoney(0,2211);
        out.println(ts.getInfo(0));
    }
}
//putMoney
class TelephoneStation {
    private TreeSet <Subscriber> subscribers;
    private TreeSet <Service> services;
    private ArrayDeque<Administrator> freeAdmins;

    {
        subscribers = new TreeSet<Subscriber>();
        services = new TreeSet<Service>();
        freeAdmins = new ArrayDeque<Administrator>();
        //для теста:
        subscribers.add(new Subscriber("Михаил", "Фролов", "+7(342)234-11-46"));
        services.add(new Service("Переходи на ноль", (short) 400, (short) 30, 15f, (short) 200, (short) 2000));
        freeAdmins.add(new Administrator("Светлана", "Иванова"));
    }
    public boolean addService (int subID, int servID) {
        if (freeAdmins.size() == 0 && this.services == null && this.subscribers == null) return false;
        Administrator admin = this.freeAdmins.getFirst();
        Service serv = services.stream().filter(c -> servID == c.getID()).findAny().get();
        Subscriber sub = subscribers.stream().filter(c -> subID == c.getID()).findAny().get();
        boolean isAdd = admin.addService(sub, serv);
        this.freeAdmins.addLast(admin);
        return isAdd;
    }
    public boolean delService (int subID, int servID) {
        if (freeAdmins.size() == 0 && this.services == null && this.subscribers == null) return false;
        Administrator admin = this.freeAdmins.getFirst();
        Service serv = services.stream().filter(c -> servID == c.getID()).findAny().get();
        Subscriber sub = subscribers.stream().filter(c -> subID == c.getID()).findAny().get();
        boolean isDell = admin.delService(sub, serv);
        this.freeAdmins.addLast(admin);
        return isDell;
    }
    public boolean cancelAllServ (int subID) {
        if (freeAdmins.size() == 0 && this.subscribers == null) return false;
        Administrator admin = this.freeAdmins.getFirst();
        Subscriber sub = subscribers.stream().filter(c -> subID == c.getID()).findAny().get();
        admin.cancelAllServ(sub);
        this.freeAdmins.addLast(admin);
        return true;
    }
    public int putMoney (int subID, int money) {
        if (this.subscribers == null) return -1;
        Subscriber sub = subscribers.stream().filter(c -> subID == c.getID()).findAny().get();
        return sub.putMoney(money);
    }
    public boolean changeNum (int subID, String newNum) {
        if (freeAdmins.size() == 0 && this.subscribers == null) return false;
        Administrator admin = this.freeAdmins.getFirst();
        Subscriber sub = subscribers.stream().filter(c -> subID == c.getID()).findAny().get();
        admin.changeNumber(sub, newNum);
        this.freeAdmins.addLast(admin);
        return true;
    }
    public String getInfo (int subID) {
        if (this.subscribers == null) return "Пользователь не найден";
        Subscriber sub = subscribers.stream().filter(c -> subID == c.getID()).findAny().get();
        return sub.toString();
    }
}
class Service implements Comparable <Service> {
    private final int ID;
    private static int numOfServices;
    private final String title;
    private final short cost;
    private final short period;
    private final float internetVolumeGB;
    private final short numOfSMS;
    private final int numOfMinutes;
    Service (String title, short cost, short period, float internetVolumeGB,short numOfSMS, short numOfMinutes) {
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
    public void changeNumber (Subscriber sub, String num) {
        sub.setPhoneNumber(num);
    }
    public String getName() {
        return name;
    }
    public void unlock (Subscriber s) {
        s.unlock();
    }
    public void cancelAllServ (Subscriber s) {
        s.cancelAllServ(s);
    }
}
class Subscriber implements Comparable <Subscriber> {
    private final int ID;
    private static int numOfSubscribers;
    private final String name;
    private final String surname;
    private String phoneNumber;
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
    Subscriber (String name, String surname, String phoneNumber) {
        this(name, surname);
        this.phoneNumber = phoneNumber;
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
    public void cancelAllServ (Subscriber s) {
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
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(@NotNull Subscriber o) {
        return (this.ID - o.ID);
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder("Имя: " + getName() + "\n" +
                "Фамилия: " + getSurname() + "\n" +
                "Номер: " + getPhoneNumber() + "\n" +
                "Баланс: " + getBalance() + "\n" +
                "Заблокирован: " + (getIsBlocked() ? "Да" : "Нет") + "\n" +
                "Услуги:" + "\n");
        for(Service s : services)
            buf.append("ID:" + s.getID() + "\n" +
                    "Название:" + s.getTitle() + "\n");
        return buf.toString();
    }
}
