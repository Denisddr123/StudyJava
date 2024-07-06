package laba1;

import java.util.Scanner;

class example_10_17
{
    public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);	
		
		System.out.print("Введите первое число: ");
		int a = in.nextInt();
		
		System.out.print("Введите второе число: ");
		int b = in.nextInt();
		
		int incr = a+b;
		int decr = a-b;
		
		System.out.printf("сумма: %d разность: %d \n", incr, decr);
		in.close();
	}
}

