package bdjava.lab8;
import java.util.Random;

public class Part1 {
    public static void main(String[] args) {
        Bank bank = new Bank(1000);

        Thread depositThread = new Thread(() -> {
            Random random = new Random();

            while (true) {
                int amount = random.nextInt(100) + 1;
                bank.deposit(amount);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        Thread withdrawThread = new Thread(() -> {
            Random random = new Random();

            while (true) {
                int amount = random.nextInt(100) + 1;
                bank.withdraw(amount);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        depositThread.start();
        withdrawThread.start();
    }
}



class Bank {
    private int balance;

    public Bank(int balance) {
        this.balance = balance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Пополнение на " + amount + " рублей. Текущий баланс: " + balance + " рублей.");
    }

        public synchronized void withdraw(int amount) {
        if (balance < amount) {
            System.out.println("Недостаточно денежных средств на счете. Текущий баланс: " + balance + " рублей.");
        } else {
            balance -= amount;
            System.out.println("Снятие " + amount + " рублей. Текущий баланс: " + balance + " рублей.");
        }
    }
}