package bdjava.lab3.var3;

import java.util.ArrayList;

import static java.lang.System.out;

public class Part2 {
    public static void main(String[] args) {
        Rose r1 = new Rose(5);
        Rose r2 = new Rose(5);
        Rose r3 = new Rose(2);
        out.println("Сравнение идентичных роз: " + r1.equals(r2));
        out.println("Сравнение неидентичных роз: " + r1.equals(r3));
        out.println("Информация по розе r1:");
        out.println(r1);
        out.println("Хеши идентичных роз: " + r1.hashCode() + " И " + r2.hashCode());
        r1.wither();
        out.println("Информация по розе r1 после того, как она завяла:");
        out.println(r1);
        out.println("Хеши ранее идентичных роз, после того как первая роза завяла: " + r1.hashCode() + " И " + r2.hashCode());
        out.println();
        r1.getBudColor(true);
    }
}

class Rose {
    private final int ID;
    private Bud bud;
    private static int numOfRoses;
    Rose() {
        this.ID = Rose.numOfRoses;
        Rose.numOfRoses++;
        bud = new Bud();
    }
    Rose (int numOfPetals) {
        this.ID = Rose.numOfRoses;
        Rose.numOfRoses++;
        bud = new Bud(numOfPetals);
    }
    public void bloom () {
        this.bud.bloom();
    }
    public void wither () {
        this.bud.wither();
    }
    public String getBudColor (boolean toConsole) {
        if (toConsole)
            out.println(this.bud.getColor());
        return this.bud.getColor();
    }
    @Override
    public String toString() {
        return "Роза номер " + this.ID + "\n" + this.bud.toString();
    }
    public Bud getBud () { return this.bud; }
    @Override
    public boolean equals(Object obj) {
        return this.bud.equals(((Rose) obj).getBud());
    }
    @Override
    public int hashCode() {
        return this.bud.hashCode();
    }
}
class Bud {
    private String color;
    private ArrayList<Petal> petals;
    Bud () {
        short n = (short) (Math.random()*20+5);
        this.petals = new ArrayList<Petal>(n);
        for (short i=0; i<n; i++)
            this.petals.add(new Petal());
        this.color = "Red";
    }
    Bud (int numOfPetals) {
        this.petals = new ArrayList<Petal>(numOfPetals);
        for (short i=0; i<numOfPetals; i++)
            this.petals.add(new Petal());
        this.color = "Red";
    }
    public void bloom () {
        this.color = "Red";
        for (Petal p : petals)
            p.bloom();
    }
    public void wither () {
        this.color = "Brown";
        for (Petal p : petals)
            p.wither();
    }
    public String getColor () {
        return this.color;
    }
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder("Цвет бутона: " + this.getColor() + "\n");
        for (Petal p : petals)
            buf.append(p.toString());
        return buf.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Bud b = (Bud) obj;
        if (this.color != b.color) return false;
        if(this.petals.size() != b.petals.size()) return false;
        for (int i=0; i<this.petals.size(); i++)
            if (!this.petals.get(i).equals(b.petals.get(i))) return false;
        return true;
    }
    @Override
    public int hashCode() {
        int res = 0;
        for (Petal p : petals)
            res += p.hashCode();
        return 31 * (res);
    }
}
class Petal {
    private final int ID;
    private static int numOfPetals;
    private String color;
    Petal () {
        this.color = "Red";
        this.ID = Petal.numOfPetals;
        Petal.numOfPetals++;
    }
    public String getColor () {
        return this.color;
    }
    public void bloom () {
        this.color = "Red";
    }
    public void wither () {
        this.color = "Brown";
    }
    @Override
    public String toString() {
        return "Лепесток номер " + this.ID + "\nЦвет: " + this.getColor() + "\n";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Petal p = (Petal) obj;
        if (this.color != p.color) return false;
        return true;
    }
    @Override
    public int hashCode() {
        return this.color == "Red" ? 2 : 1;
    }
}