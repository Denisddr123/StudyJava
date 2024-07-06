package laba1;

import java.util.Scanner;
import java.util.Calendar;

class example_10_13
{
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);	
		Calendar calendar = Calendar.getInstance();
		
		int year = calendar.get(1);
		
		System.out.print("Введите ваше имя: ");
		String name = in.nextLine();
		
		System.out.print("Введите год рождения: ");
		int wasBorn = in.nextInt();
		
		int age = year-wasBorn;
		 
		System.out.printf("Вы: %s и вам %d лет \n", name, age);
		in.close();
	}
}
