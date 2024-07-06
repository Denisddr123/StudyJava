package laba1;

import java.util.Scanner;

class example_10_20
{
		static double a, b, c;
		
		public static double hyp(double a, double b){
			return c = Math.exp(b*Math.log(a));
		}
		public static void main(String[] args) {
		
			Scanner in = new Scanner(System.in);

			System.out.print("Возвести число: " );
			double a = in.nextInt();
			
			System.out.print("в степень: " );
			double b = in.nextInt();
			
			System.out.println("результат: " + hyp(a, b));
			in.close();
		}
}
