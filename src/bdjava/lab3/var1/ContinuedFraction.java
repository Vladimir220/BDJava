package bdjava.lab3.var1;

import java.io.Serializable;
import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

public class ContinuedFraction implements Serializable {
    private final short N;
    private final float[] A;
    private float x;
    private double bufRes;
    transient private Scanner reader;
    public ContinuedFraction(short n, float x){
        this(n);
        this.x = x;
    }
    public ContinuedFraction(short n){
        this.A = new float[n];
        this.N = n;
        inputConst(n);
    }
    public void changeX(float x){
        this.x = x;
    }
    private void inputConst(short n){
        reader = new Scanner(in);
        out.println("Введите " + n +" констант(ы), начиная с нижнего уровня цепной дроби");
        for(short i=0; i<n; i++) {
            A[i] = reader.nextFloat();
        }
    }
    public double calculate(boolean detail) {
        if (this.bufRes != 0)
            return  bufRes;
        else {
            double buf = this.A[0] + this.x;
            if(detail)
                out.println(this.A[0] + " + " + this.x + " / 1 = " + buf);
            for(short i = 1; i<this.N; i++) {
                if(detail)
                    out.print(this.A[i] + " + " + this.x + " / " + buf + " = ");
                buf = this.A[i] + this.x / buf;
                if(detail)
                    out.println(buf);
            }
            this.bufRes = buf;
            return buf;
        }
    }
    public String toString(){
        String buf = "Созданная цепная дробь:\n";
        for(short i = 1; i<=this.N; i++)
            buf = buf + this.A[this.A.length-i] + " + " + this.x + "/(";
        buf = buf + "1 ...)";
        return buf;
    }
}