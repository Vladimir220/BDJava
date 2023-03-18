package bdjava.lab3.var4;

import java.util.ArrayList;

/*
Создать приложение, удовлетворяющее требованиям, приведенным в задании. Аргументировать принадлежность
классу каждого создаваемого метода и корректно переопределить для каждого класса методы equals(), hashCode(), toString().
5. Создать объект класса Дом, используя классы Окно, Дверь. Методы: закрыть на ключ, вывести на консоль количество окон, дверей.
6. Создать объект класса Роза, используя классы Лепесток, Бутон. Методы: расцвести, завять, вывести на консоль цвет бутона.
 */
public class Program {
    public static void main(String[] args) {

    }
}

class House{
    private ArrayList<Window> windows;
    private ArrayList<Door> doors;

    House(){
        this.windows = new ArrayList<Window>();
        this.windows.add(new Window());
        this.doors = new ArrayList<Door>();
        this.doors.add(new Door());
    }
    House(short numOfWindows, short numOfDoors){
        this.windows = new ArrayList<Window>();
        this.doors = new ArrayList<Door>();
        for (short i=0; i<numOfWindows; i++)
            this.windows.add(new Window());
        for (short i=0; i<numOfWindows; i++)
            this.doors.add(new Door());
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
        return this.windows.equals(((House) obj).windows) && this.doors.equals(((House) obj).doors);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public String toString() {
        return super.toString();
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
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public String toString() {
        return super.toString();
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
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public String toString() {
        return super.toString();
    }
}