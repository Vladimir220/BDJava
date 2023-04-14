package bdjava.lab4;

import java.util.PrimitiveIterator;

import static java.lang.System.out;

public class Program4 {
    public static void main(String[] args) {

    }
}

interface Doctor {
    public String examine (String complaints, Patient p);
    public boolean treat (String examination, Patient p);
    public String writePrescription (String examination, Patient p);
}

abstract class Surgeon implements Doctor {
    public boolean cut (String examination, Patient p) {
        return true;
    }
    public boolean sewUp (String examination, Patient p) {
        return true;
    }
    @Override
    public String writePrescription(String examination, Patient p) {
        return "Выписанный рецепт";
    }
}

class Neurosurgeon extends Surgeon {
    @Override
    public boolean treat(String examination, Patient p) {
        out.println("Лечим со знаниями нейрохирургии");
        return true;
    }
    @Override
    public String examine(String complaints, Patient p) {
        return "Обследуем со знаниями нейрохирургии";
    }
}

class Patient {

}