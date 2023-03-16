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
		out.println("Часть 1:");
		ContinuedFraction frac = new ContinuedFraction((short) 5,3.6f);
		out.println("Результат: " + frac.calculate(true));
		out.println(frac.getFrac());
		out.println();
		out.println("Часть 2:");

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
	
}
