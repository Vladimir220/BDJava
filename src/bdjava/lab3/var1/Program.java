package bdjava.lab3.var1;
import static java.lang.System.*;
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


