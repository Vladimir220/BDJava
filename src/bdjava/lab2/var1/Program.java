package bdjava.lab2.var1;
import static java.lang.System.*;
import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

public class Program {
/*
 * Ввести n слов с консоли. 
 * 6. Найти слово, символы в котором идут в строгом порядке 
 * возрастания их кодов. Если таких слов несколько, найти первое из них.
 * 7. Найти слово, состоящее только из различных символов. Если таких 
 * слов несколько, найти первое из них.
 */
	public static void main(String[] args) {
		int n;
		Scanner reader = new Scanner(in);
		
		try {
			out.println("Enter number of str");
			n = reader.nextInt();
			reader.nextLine();
			if(n<1)
				throw new Exception("The number of input is less than 1");
			String[] buf = new String[n];
			out.println("Enter "+n+" lines");
			for(int i=0;i<n;i++)
				buf[i] = reader.nextLine();
			strictInc(buf);
			originalString(buf);			
		}
		catch(Exception e) {
			out.println("Error("+e.getMessage()+')');
		}
		finally {
			reader.close();
		}
		out.println("Trofimov");
		Calendar calendar = new GregorianCalendar(2023, Calendar.FEBRUARY , 17);
		calendar.set(Calendar.HOUR_OF_DAY, 15);
		calendar.set(Calendar.MINUTE, 39);
		out.println("Getting a task: " +calendar.getTime());
		Date currentDate = new Date();
		out.println("Task completion: " + currentDate);
		
	}

	private static void strictInc(String[] buf) {
		for(String str : buf) {
			boolean isInc = true;
			for(int j=1;j<str.length();j++)
				if(str.charAt(j) <= str.charAt(j-1))
					isInc = false;
			if(isInc) {
				out.println(str+" - first ascending word");
				break;
			}
			else
				isInc = true;
		}
	}
	
	private static void originalString(String[] buf) {
		for(String str : buf) {
			HashSet<Character> set = new HashSet<Character>();
			boolean isOriginal = true;
			for(int i=0;i<str.length();i++)
				if(!set.add(str.charAt(i)))
					isOriginal = false;
			if(isOriginal) {
				out.println(str+" - first original word");
				break;
			}
			isOriginal = true;
		}
	}
}
