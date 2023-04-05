package bdjava.lab3.var4;


import java.util.*;

import static java.lang.System.out;

/*
6. Система Конструкторское бюро. Заказчик представляет Техническое Задание (ТЗ) на проектирование многоэтажного Дома.
Конструктор регистрирует ТЗ, определяет стоимость проектирования и строительства, выставляет Заказчику Счет за
проектирование и создает Бригаду Конструкторов для выполнения Проекта.
 */
public class Part1 {
    public static void main(String[] args) {
        DesignDepartment d = new DesignDepartment();
        HashMap <String, String> tt = new HashMap<String, String>();
        tt.put("Name", "Пётр Первый");
        out.println(d.processTT(tt));
        out.println(d.processTT(tt));
    }
}

class DesignDepartment {
    private ChiefDesigner chiefDesigner;
    private ArrayDeque<Designer> freeDesigners;
    private ArrayDeque<Designer> busyDesigners;
    private DatabaseOfTechnicalTask dbTT;
    DesignDepartment () {
        this.chiefDesigner = new ChiefDesigner("Василий", "Степанов");
        this.dbTT = new DatabaseOfTechnicalTask();
        this.freeDesigners = new ArrayDeque<Designer>();
        this.busyDesigners = new ArrayDeque<Designer>();
        // например
    }
    public Bill processTT (HashMap<String, String> tt) {
        this.chiefDesigner.loadTechnicalTask(tt);
        this.chiefDesigner.regTechnicalTask(dbTT);
        this.chiefDesigner.getDesignCost();
        this.chiefDesigner.getConstructionCost();
        this.chiefDesigner.createBrigade(freeDesigners, busyDesigners);
        return this.chiefDesigner.getBill();
    }

}
class Designer {
    public final int ID;
    static int numOfDesigners;
    public String name;
    public String surname;
    Designer (String name, String surname) {
        this.ID = Designer.numOfDesigners;
        Designer.numOfDesigners++;
        this.name = name;
        this.surname = surname;
    }
    Designer (Designer designer) {
        this(designer.name, designer.surname);
    }
}
class ChiefDesigner extends Designer {
    private BufferOfChiefDesigner buf;
    ChiefDesigner (String name, String surname) {
        super(name, surname);
    }
    ChiefDesigner (Designer designer) {
        super(designer);
    }
    public boolean loadTechnicalTask(HashMap<String, String> tt) {
        this.buf = new BufferOfChiefDesigner();
        String authorName = tt.get("Name");
        if (authorName == null)
            return false;
        this.buf.tt = new TechnicalTask(authorName , this, tt);
        return true;
    }
    public boolean regTechnicalTask (DatabaseOfTechnicalTask db) {
        // тут какие-нибудь условия и/или ручная проверка конструктора с последующим подтверждением
        if(buf != null)
            db.regTechnicalTask(this.buf.tt);
        return true;
    }
    public long getDesignCost () {
        long cost = 0;
        // тут какие-нибудь автоматические расчёты и/или ручная корректировка цены конструктором
        //if(buf != null)
        //  if(this.buf.tt['...'] > ...
        return cost;
    }
    public long getConstructionCost () {
        long cost = 0;
        // тут какие-нибудь автоматические расчёты и/или ручная корректировка цены конструктором
        //if(buf != null)
        //  if(this.buf.tt['...'] > ...
        return cost;
    }
    public ArrayList <Designer> createBrigade (ArrayDeque<Designer> free, ArrayDeque<Designer> busy) {
        short numOfDesigners = 0;
        this.buf.selectedDesigners = new ArrayList<>();
        // определение конструктором или системой требуемого числа конструкторов на проектирование
        if (free.size() < numOfDesigners) {
            out.println("Недостаточно свободных конструкторов");
            return null;
        }
        else {
            for (short i = 0; i < numOfDesigners; i++) {
                Designer d = free.removeFirst();
                busy.addLast(d);
                this.buf.selectedDesigners.add(d);
            }
            return this.buf.selectedDesigners;
        }
    }
    public Bill getBill () {
        String description = "";
        if(this.buf.designCost == 0 && this.buf.selectedDesigners == null)
            return null;
        //описание создаёт редактор
        return new Bill(this.buf.designCost, description, (short) this.buf.selectedDesigners.size());
    }
}
class BufferOfChiefDesigner {
    public TechnicalTask tt;
    public long designCost;
    public long constructionCost;
    public ArrayList<Designer> selectedDesigners;
    BufferOfChiefDesigner () {}
}
//написать все методы
class DatabaseOfTechnicalTask {
    ArrayList <TechnicalTask> technicalTasks;
    DatabaseOfTechnicalTask () {
        this.technicalTasks = new ArrayList<TechnicalTask>();
    }
    public boolean regTechnicalTask (TechnicalTask tt) {
        this.technicalTasks.add(tt);
        return true;
    }
    public boolean searchTechnicalTask (HashMap<String, String> parameters) {
        return true;
    }
    public boolean delTechnicalTask (int id) {
        return true;
    }
}
//сделать тустр
class TechnicalTask {
    private final int ID;
    private static int numOfTechnicalTasks;
    private String author;
    private Designer inspector;
    private Date date;
    private HashMap <String, String> technicalTask;
    TechnicalTask(String author, Designer inspector, HashMap <String, String> technicalTask) {
        this.ID = TechnicalTask.numOfTechnicalTasks;
        TechnicalTask.numOfTechnicalTasks++;
        this.author = author;
        this.inspector = inspector;
        this.technicalTask = technicalTask;
        this.date = new Date();
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
//сделать тустр
class  Bill {
    private final int ID;
    private static int numOfBills;
    private long designСost;
    private String description;
    private short numOfDesigners;
    private Date date;

    Bill (long designСost, String description, short numOfDesigners) {
        this.ID = Bill.numOfBills;
        Bill.numOfBills++;
        this.designСost = designСost;
        this.description = description;
        this.numOfDesigners = numOfDesigners;
        this.date = new Date();
    }
    @Override
    public String toString() {
        return "ID: " + ID + " " + designСost + " " + description + " " + numOfDesigners + " " + date;
    }
}