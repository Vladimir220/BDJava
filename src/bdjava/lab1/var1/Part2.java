package bdjava.lab1.var1;
import static java.lang.System.*;

public class Part2 {

/** 
 * Задание 5
 * Создать программу ввода целых чисел как аргументов командной строки, 
 * подсчета их суммы (произведения) и вывода результата на консоль
 * */
	
	public static void main(String[] args) {
		int mulRes = 1;
		int sumRes = 0;
		
		try {
			if(args.length < 1)
				throw new Exception("No input");
			out.println("Input:");
			for(String str:args) {
				try {
					out.println(str);
					mulRes *= Integer.parseInt(str);
					sumRes += Integer.parseInt(str);
				}
				catch (NumberFormatException e) {
					out.println("Error("+e.getMessage()+") - will be skipped");
				}
			}
		}
		catch (Exception e) {
			out.println(e.getMessage());
		}
		out.println("Sum = "+sumRes+'\n'+"Mul = "+mulRes);
	}
	
}
