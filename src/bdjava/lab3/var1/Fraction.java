package bdjava.lab3.var1;


import java.io.Serializable;

public class Fraction implements Serializable {
    private int m;
    private int n;

    public Fraction(int m){
        this.m = m;
        this.n = 1;
    }
    public Fraction(int m, int n){
        this.m = m;
        this.n = n;
    }
    Fraction(){
        this(1);
    }
    public static Fraction addition(Fraction first, Fraction second){
        Fraction bufF = new Fraction();
        int bufI1, bufI2;
        Fraction.fracReduction(first);
        Fraction.fracReduction(second);
        bufF.n = first.n * second.n;
        bufI1 = first.m * second.n;
        bufI2 = second.m * first.n;
        bufF.m = bufI1 + bufI2;
        Fraction.fracReduction(bufF);
        return bufF;
    }
    public static Fraction subtraction(Fraction first, Fraction second){
        Fraction bufF = new Fraction();
        int bufI1, bufI2;
        Fraction.fracReduction(first);
        Fraction.fracReduction(second);
        bufF.n = first.n * second.n;
        bufI1 = first.m * second.n;
        bufI2 = second.m * first.n;
        bufF.m = bufI1 - bufI2;
        Fraction.fracReduction(bufF);
        return bufF;
    }
    public static Fraction multiplication(Fraction first, Fraction second){
        Fraction bufF = new Fraction();
        Fraction.fracReduction(first);
        Fraction.fracReduction(second);
        bufF.n = first.n * second.n;
        bufF.m = first.m * second.m;
        Fraction.fracReduction(bufF);
        return bufF;
    }
    public static Fraction division(Fraction first, Fraction second){
        Fraction bufF = new Fraction(), divisor = new Fraction(second.n, second.m);
        Fraction.fracReduction(first);
        Fraction.fracReduction(divisor);
        bufF.n = first.n * divisor.n;
        bufF.m = first.m * divisor.m;
        Fraction.fracReduction(bufF);
        return bufF;
    }
    public static void neighborAddition(Fraction[] fracs){
        for (short i=0; i<fracs.length-1; i++)
            if(i % 2 == 0)
                fracs[i] = Fraction.addition(fracs[i], fracs[i+1]);
    }
    private static void fracReduction(Fraction frac){
        int first = frac.m;
        int second = frac.n;
        int nod;
        if (second == 0)
            throw new ArithmeticException("Деление на ноль в операциях с обыкновенными дробями!");
        else if (first != 0)
        {
            while (first != second)
                if (first > second)
                    first -= second;
                else
                    second -= first;
            nod = first;
            frac.m /= nod;
            frac.n /= nod;
        }
    }
    public String toString(){
        return this.m + "/" + this.n;
    }
}