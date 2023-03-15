package bdjava.lab3.var1;
import static java.lang.System.*;
import java.util.Scanner;
public class Program {
	public static void main(String[] args) {
		ContinuedFraction frac = new ContinuedFraction((short) 5,3.6f);
		out.println("Результат: " + frac.calculate());
		out.println(frac.getFrac());
	}
}

class ContinuedFraction {
	private short n;
	private float[] a;
	private float x;
	private double bufRes;
	private Scanner reader;
	ContinuedFraction(short n, float x){
		this.a = new float[n];
		this.n = n;
		this.x = x;
		inputConst(n);
	}
	private void inputConst(short n){
		reader = new Scanner(in);
		out.println("Введите " + n +" констант(ы), начиная с нижнего уровня цепной дроби");
		for(short i=0; i<n; i++)
			a[i] = reader.nextFloat();
		reader.close();
	}
	public double calculate(){
		if (this.bufRes != 0)
			return  bufRes;
		else {
			double buf = this.a[0] + this.x;
			for(short i=0; i<(this.n-1); i++)
				buf = this.a[i] + x/buf;
			this.bufRes = buf;
			return buf;
		}
	}
	public String getFrac(){
		String buf = "Созданная цепная дробь:\n";
		for(short i=1; i<=this.n; i++)
			buf = buf + this.a[this.a.length-i] + " + " + this.x + "/(";
		buf = buf + "1 ...)";
		return buf;
	}
}
