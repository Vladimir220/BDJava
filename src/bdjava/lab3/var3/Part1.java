package bdjava.lab3.var3;
import static java.lang.System.*;
import java.util.ArrayList;

/*
Создать приложение, удовлетворяющее требованиям, приведенным в задании. Аргументировать принадлежность
классу каждого создаваемого метода и корректно переопределить для каждого класса методы equals(), hashCode(), toString().
5. Создать объект класса Дом, используя классы Окно, Дверь. Методы: закрыть на ключ, вывести на консоль количество окон, дверей.
6. Создать объект класса Роза, используя классы Лепесток, Бутон. Методы: расцвести, завять, вывести на консоль цвет бутона.
 */
public class Part1 {
    public static void main(String[] args) {
        House h1 = new House((short) 3,(short) 4);
        House h2 = new House((short) 3,(short) 4);
        House h3 = new House((short) 5,(short) 4);
        out.println("Сравнение идентичных квартир: " +h1.equals(h2));
        out.println("Сравнение неидентичных квартир: " +h1.equals(h3));
        out.println("Информация по дому h1:");
        out.println(h1);
        h1.accessChangeDoor(1);
        h1.accessChangeWindow(2);
        out.println("Информация по дому h1 после открытия окна и двери:");
        out.println(h1);
        out.println("Хеши идентичных домов: " + h1.hashCode() + " И " + h2.hashCode());

    }
}

class House{
    private ArrayList<Window> windows;
    private ArrayList<Door> doors;
    private final int ID;
    private static int numOfHouses;
    House(){
        this.windows = new ArrayList<Window>();
        this.windows.add(new Window());
        this.doors = new ArrayList<Door>();
        this.doors.add(new Door());
        this.ID = House.numOfHouses;
        House.numOfHouses++;
    }
    House(short numOfWindows, short numOfDoors){
        this.windows = new ArrayList<Window>(numOfWindows);
        this.doors = new ArrayList<Door>(numOfDoors);
        for (short i=0; i<numOfWindows; i++)
            this.windows.add(new Window());
        for (short i=0; i<numOfWindows; i++)
            this.doors.add(new Door());
        this.ID = House.numOfHouses;
        House.numOfHouses++;
    }
    public void accessChangeWindow(int id){
        this.windows.get(id).accessChange();
    }
    public void accessChangeDoor(int id){
        this.doors.get(id).accessChange();
    }
    public int getNumberOfWindows(){
        return this.windows.size();
    }
    public int getNumberOfDoor(){
        return this.doors.size();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        House h = (House) obj;
        if (this.getNumberOfDoor() != h.getNumberOfDoor()) return false;
        if (this.getNumberOfWindows() != h.getNumberOfWindows()) return false;
        return true;
    }
    @Override
    public int hashCode() {
        return 31 * (this.getNumberOfDoor() + this.getNumberOfWindows());
    }
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder("Дом номер: " + this.ID + "\n");
        buf.append("Двери:\n");
        for(Door d : this.doors)
            buf.append(d + "\n");
        buf.append("Окна:\n");
        for(Window w : this.windows)
            buf.append(w + "\n");
        return buf.toString();
    }
}
class Window{
    private final int ID;
    private boolean isOpen;
    private static int numOfWindows;
    Window(){
        this.ID = Window.numOfWindows;
        Window.numOfWindows++;
    }
    public void accessChange(){
        this.isOpen = !this.isOpen;
    }
    public boolean getIsOpen(){
        return isOpen;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Window w = (Window) obj;
        if (this.ID != w.ID) return false;
        return true;
    }
    @Override
    public int hashCode() {
        return this.ID*31;
    }
    @Override
    public String toString() {
        return "Окно номер " + this.ID + (this.isOpen ? "\nОкно открыто\n" : "\nОкно закрыто\n");
    }
}
class Door{
    private final int ID;
    private boolean isOpen;
    private static int numOfDoors;
    Door(){
        this.ID = Door.numOfDoors;
        Door.numOfDoors++;
    }
    public boolean getIsOpen(){
        return isOpen;
    }
    public void accessChange(){
        this.isOpen = !this.isOpen;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Door d = (Door) obj;
        if (this.ID != d.ID) return false;
        return true;
    }
    @Override
    public int hashCode() {
        return this.ID*31;
    }
    @Override
    public String toString() {
        return "Древь номер " + this.ID + (this.isOpen ? "\nДверь открыта\n" : "\nДверь закрыта\n");
    }
}