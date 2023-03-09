package bdjava.lab2.var2;
import static java.lang.System.*;
import static java.lang.Math.*;
import java.util.Scanner;

public class Program {
/*
Ввести с консоли n – размерность матрицы a[n][n]. Задать значения элементов
матрицы в интервале значений от -n до n с помощью датчика случайных чисел.
6. Вычислить норму матрицы.
7. Повернуть матрицу на 90 (180, 270) градусов против часовой стрелки.
 */
	private static byte n;

	public static void main(String[] args) {
		Scanner reader = new Scanner(in);
		out.println("Введдите ранг матрицы");
		n = reader.nextByte();
		float[][] matrix = new float[n][n];
		out.println("Сгенерированная матрица:");
		for(byte i=0; i<n; i++) {
			for (byte j = 0; j < n; j++) {
				matrix[i][j] = (float) (random() * n * 2 - n);
				out.printf("%2.2f ", matrix[i][j]);
			}
			out.println();
		}
		norm(matrix);
		out.println();

		out.println("Исходная матрица:");
		matrixOutput(matrix);
		float[][] rotatedMatrix = rotation90(matrix);
		out.println("Поворот на 90:");
		matrixOutput(rotatedMatrix);
		rotatedMatrix = rotation90(rotatedMatrix);
		out.println("Поворот на 180:");
		matrixOutput(rotatedMatrix);
		rotatedMatrix = rotation90(rotatedMatrix);
		out.println("Поворот на 270:");
		matrixOutput(rotatedMatrix);

		reader.close();
	}

	private  static  float[][] rotation90(float[][] matrix){
		float[][] buf = new float[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				buf[i][j] = matrix[n - j - 1][i];
		return buf;
	}
	private static void norm (float[][] matrix){
		float[] buf = new float[n];
		float norm3=0;
		for(byte i=0; i<n; i++)
			for(byte j=0; j<n; j++)
				buf[i] += abs(matrix[i][j]);
		out.println("Норма по максимуму суммы модулей элементов в строке: " + maximum(buf));
		buf = new float[n];
		for(byte i=0; i<n; i++)
			for(byte j=0; j<n; j++)
				buf[i] += abs(matrix[j][i]);
		out.println("Норма по максимуму суммы модулей элементов в столбце: " + maximum(buf));
		for(byte i=0; i<n; i++)
			for(byte j=0; j<n; j++)
				norm3 += pow(matrix[i][j], 2);
		norm3 = (float) sqrt(norm3);
		out.println("Норма через квадратный корень из суммы квадратов элементов: " + norm3);
	}

	private static float maximum(float[] buf){
		float max = buf[0];
		out.println("Массив для определения максимума:");
		for(byte i=0;i<n;i++)
			out.printf("%2.2f ",buf[i]);
		out.println();
		for(byte i=0; i<n; i++)
			if(buf[i] > max)
				max = buf[i];
		return max;
	}

	private static void matrixOutput(float[][] matrix){
		for(byte i=0; i<n; i++) {
			for (byte j = 0; j < n; j++)
				out.printf("%2.2f ", matrix[i][j]);
			out.println();
		}
	}
}
