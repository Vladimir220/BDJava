package bdjava.lab2.var1;
import static java.lang.System.*;
import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;

public class Program {
/*
 * 6. Ввести n слов с консоли. Найти слово, символы в котором идут в строгом порядке 
 * возрастания их кодов. Если таких слов несколько, найти первое из них.
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
			String buf[] = new String[n];
			out.println("Enter "+n+" lines");
			for(int i=0;i<n;i++) {
				buf[i] = reader.nextLine();
			} // ввели полностью, как в задании требуется, но можно было бы прервать, когда слово бы нашлось
			for(int i=0;i<n;i++) {
				boolean isInc = true;
				for(int j=1;j<buf[i].length();j++)
					if(buf[i].charAt(j) <= buf[i].charAt(j-1))
						isInc = false;
				if(isInc) {
					out.println(buf[i]+" - first ascending word");
					break;
				}
				else
					isInc = true;
			}
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
		out.println("Task completion: " + currentDate.toString());
		
	}

}
