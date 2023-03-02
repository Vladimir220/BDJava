package bdjava.lab1.var1;
import static java.lang.System.*;
import java.util.Scanner;

public class Part1 {

// Задание 4
// Создать приложение для ввода пароля из командной строки и сравнения его со строкой-образцом
	
	public static void main(String[] args) {
		final String sample = "qwerty";
		Scanner reader = new Scanner(in);
		
		out.println("Enter password");
		try {
			String buf = reader.nextLine();
			if (buf == "")
				throw new Exception("No input");
			
			if(buf.equals(sample))
				out.println("Passwords match");
			else
				out.println("Password mismatch");
		}
		catch(Exception e) {
			out.println(e.getMessage());
		}
		finally {
			reader.close();
		}
	}
}
