package bdjava.lab1;
import static java.lang.System.*;

public class Program {
	// Создать приложение для ввода пароля из командной строки и сравнения его со строкой-образцом
	public static void main(String[] args) {
		final String sample = "qwerty";
		
		try {
			if(args.length < 1)
				throw new Exception("No input");
			
			if(args[0].equals(sample))
				out.println("Passwords match");
			else
				out.println("Password mismatch");
		}
		catch(Exception e) {
			out.println(e.getMessage());
		}
	}
}
