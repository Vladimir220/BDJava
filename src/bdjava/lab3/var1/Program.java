package bdjava.lab3.var1;
import static java.lang.System.*;
import java.util.Scanner;

/*
6.	Определить класс Цепная дробь
Определить методы сложения, вычитания, умножения, деления.
Вычислить значение для заданного n, x, a[n].
7.	Определить класс Дробь в виде пары (m,n).
Класс должен содержать несколько конструкторов.
Реализовать методы для сложения, вычитания, умножения и деления дробей.
Объявить массив из k дробей, ввести/вывести значения для массива дробей.
Создать массив объектов и передать его в метод, который изменяет каждый
элемент массива с четным индексом путем добавления следующего за ним элемента массива.
 */
public class Program {
	public static void main(String[] args) {
		/*out.println("Часть 1:");
		ContinuedFraction frac1 = new ContinuedFraction((short) 5,3.6f);
		out.println("Результат: " + frac1.calculate(true));
		out.println(frac1.getFrac());
		out.println();
		out.println("Часть 2:");*/
		Fraction frac2 = new Fraction(232,8);
		Fraction frac3 = new Fraction(32,7);
		Fraction sum = Fraction.addition(frac2, frac3);
		Fraction sub = Fraction.subtraction(frac2, frac3);
		Fraction mul = Fraction.multiplication(frac2, frac3);
		Fraction div = Fraction.division(frac2, frac3);
		out.println(frac2 + " + " + frac3 + " = " + sum);
		out.println(frac2 + " - " + frac3 + " = " + sub);
		out.println(frac2 + " * " + frac3 + " = " + mul);
		out.println(frac2 + " / " + frac3 + " = " + div);
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
	public double calculate(boolean detail){
		if (this.bufRes != 0)
			return  bufRes;
		else {
			double buf = this.a[0] + this.x;
			if(detail)
				out.println(this.a[0] + " + " + this.x + " / 1 = " + buf);
			for(short i=1; i<this.n; i++) {
				if(detail)
					out.print(this.a[i] + " + " + this.x + " / " + buf + " = ");
				buf = this.a[i] + this.x / buf;
				if(detail)
					out.println(buf);
			}
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

class Fraction{
	private int m;
	private int n;

	Fraction(int m){
		this.m = m;
		this.n = 1;
	}
	Fraction(int m, int n){
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
		Fraction.fracReduction(second);
		bufF.n = first.n * divisor.n;
		bufF.m = first.m * divisor.m;
		Fraction.fracReduction(bufF);
		return bufF;
	}
	public static double neighborAddition(Fraction first, Fraction second){
		return 2.2;
	}
	private static void fracReduction(Fraction frac){
		int first = frac.m;
		int second = frac.n;
		int nod;
		while (first != second)
			if(first > second)
				first -= second;
			else
				second -= first;
		nod = first;
		frac.m /= nod;
		frac.n /= nod;
	}
	public String toString(){
		return this.m + "/" + this.n;
	}
}
