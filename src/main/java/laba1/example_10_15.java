package laba1;

import java.util.Scanner;

class example_10_15
{
    public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);	
		
		System.out.print("Введите первое число: ");
		int a = in.nextInt();
		
		System.out.print("Введите второе число: ");
		int b = in.nextInt();
		
		int sum = a+b;
		
		System.out.printf("сумма равна %d \n", sum);
		in.close();
	}
}

