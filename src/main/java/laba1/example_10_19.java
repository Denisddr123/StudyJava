package laba1;

import java.util.Scanner;

class example_10_19
{
		static double a, b, c;
		public static double hyp(double a, double b){
			return c = Math.exp(0.5*Math.log(Math.exp(2*Math.log(a))+Math.exp(2*Math.log(b))));
		}
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			System.out.print("katet а=");
			double a = in.nextInt();
			System.out.print("katet b=");
			double b = in.nextInt();
			System.out.println("hypotenuse с=" + hyp(a, b));
			in.close();
			
		}
}

