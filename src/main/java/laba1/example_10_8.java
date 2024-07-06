package laba1;

import java.util.Scanner;

class example_10_8
{
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		System.out.print("Ваша фамилия: ");
		String lastname = in.nextLine();
		
		System.out.print("Ваше имя: ");
		String name = in.nextLine();
		
		System.out.print("Ваше отчество: ");
		String firstname = in.nextLine();
		 
		System.out.printf("Фамилия: %s Имя: %s Отчество: %s \n", lastname,
		name, firstname);
		in.close();
	}
}
