package laba1;

import java.util.Calendar;
import java.util.Scanner;

class example_10_12
{
    public static void main(String[] array) {
        Scanner in = new Scanner(System.in);	
				Calendar calendar = Calendar.getInstance();
		
				int year = calendar.get(1);
				
				System.out.print("Введите год рождения: ");
				int wasBorn = in.nextInt();
		
				int age = year-wasBorn;
				
				System.out.printf("Вам %d лет \n", age);
				in.close();
    }
}
