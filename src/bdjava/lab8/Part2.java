package bdjava.lab8;

//2.	Реализовать многопоточное приложение “Робот”. Надо написать
// робота, который умеет ходить. За движение каждой его ноги отвечает отдельный
// поток. Шаг выражается в выводе в консоль LEFT или RIGHT.
public class Part2 {
    public static void main(String[] args) {
        Thread leftLegT = new Thread(new LeftLeg());
        Thread rightLegT = new Thread(new RightLeg());

        leftLegT.start();
        rightLegT.start();
    }
}

class LeftLeg implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("LEFT");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class RightLeg implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("RIGHT");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}