package bdjava.lab4;

import java.util.ArrayList;

import static java.lang.System.out;

public class Program3 {
    public static void main(String[] args) {

    }
}

interface Ship {
    public boolean store (Object obj);
    public boolean swim (double dlatitude, double dlongitude);
    public void dropAnchor ();
    public void raiseAnchor ();
    public String sendSignal (String str);
    public void getSignal (String str);
}

abstract class Warship implements Ship {
    private double longitude;
    private double latitude;
    private boolean isAnchorUp;
    @Override
    public boolean swim(double dlatitude, double dlongitude) {
        this.latitude += dlatitude;
        this.longitude += dlongitude;
        return true;
    }
    @Override
    public void dropAnchor() {
        isAnchorUp = false;
    }
    @Override
    public void raiseAnchor() {
        isAnchorUp = true;
    }
    @Override
    public void getSignal(String str) {
        out.println("Получено сообщение: " + str);
    }
    @Override
    public String sendSignal(String str) {
        return str;
    }
}

class AircraftCarrier extends Warship {
    private ArrayList <Airplane> airplanes;
    @Override
    public boolean store(Object obj) {
        airplanes = new ArrayList<Airplane>();
        airplanes.add((Airplane) obj);
        return true;
    }
    public ArrayList<Airplane> getAirplanes() {
        return airplanes;
    }

}

class Airplane {
    private final int num;
    private final String model;
    Airplane (int num, String model) {
        this.num = num;
        this.model = model;
    }

    public int getNum() {
        return num;
    }

    public String getModel() {
        return model;
    }
}