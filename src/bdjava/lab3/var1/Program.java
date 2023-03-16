package bdjava.lab3.var1;
import static java.lang.System.*;
import java.util.Scanner;
import java.lang.Math;
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
		out.println("Часть 1:");
		ContinuedFraction frac1 = new ContinuedFraction((short) 5,3.6f);
		out.println("Результат: " + frac1.calculate(true));
		out.println(frac1);
		out.println();
		out.println("Часть 2:");
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
		Fraction[] fracs = new Fraction[15];
		out.println("Сгенерированный набор дробей:");
		for(short i=0; i<15; i++) {
			fracs[i] = new Fraction((int) (Math.random() * 20), (int) (Math.random() * 20));
			out.println(fracs[i]);
		}
		Fraction.neighborAddition(fracs);
		out.println("Набор после преобразования:");
		for(short i=0; i<15; i++)
			out.println(fracs[i]);
	}
}

class ContinuedFraction {
	private final short N;
	private final float[] A;
	private float x;
	private double bufRes;
	private Scanner reader;
	ContinuedFraction(short n, float x){
		this(n);
		this.x = x;
	}
	ContinuedFraction(short n){
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
		for(short i=0; i<n; i++)
			A[i] = reader.nextFloat();
		reader.close();
	}
	public double calculate(boolean detail){
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
	public static void neighborAddition(Fraction[] fracs){
		for (short i=0; i<fracs.length-1; i++)
			if(i % 2 == 0)
				fracs[i] = Fraction.addition(fracs[i], fracs[i+1]);
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
