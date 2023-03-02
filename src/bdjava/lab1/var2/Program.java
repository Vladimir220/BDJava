package bdjava.lab1.var2;
import static java.lang.System.*;
import java.util.Scanner;

public class Program {

/**
 * Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести: 
 * 1. Четные и нечетные числа. 
 * 2. Наибольшее и наименьшее число. 
 */
	
	public static void main(String[] args) {
		int n;
		Scanner reader = new Scanner(in);
		
		try {
			out.println("Enter number of numbers");
			n = reader.nextInt();
			if(n<1)
				throw new Exception("The number of input is less than 1");
			int buf[] = new int[n];
			for(int i=0;i<n;i++) {
				buf[i] = reader.nextInt();
			}
			evenAndOdd(buf);
			largestAndSmallest(buf);
		}
		catch(Exception e) {
			out.println("Error("+e.getMessage()+')');
		}
		finally {
			reader.close();
		}
	}

	private static void evenAndOdd (int buf[]) {
		for(int i : buf) 
			if(i%2 == 0)
				out.println(i+" - even");
			else
				out.println(i+" - odd");
	}
	
	private static void largestAndSmallest(int buf[]) {
		int largest = buf[0];
		int smallest = buf[0];
		
		for(int i : buf) {
			if(i > largest)
				largest = i;
			if(i < smallest)
				smallest = i;
		}
		out.println("Largest:"+largest);
		out.println("Smallest:"+smallest);
	}
}
