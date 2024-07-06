package laba1;

import java.util.Scanner;

class example_10_16
{
    public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);	
		
		System.out.print("Введите число: ");
		int num = in.nextInt();

		int num0 = num-1;
		int num2 = num+1;
		double sq = Math.pow(num+num0+num2, 2);
		
		System.out.printf("%d %d %d %.0f \n", num0, num, num2, sq);
		in.close();
	}
}

