package laba1;

import java.util.Calendar;
import java.util.Scanner;

class example_10_14
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int value = Calendar.getInstance().get(1);
        System.out.print("Введите ваш возраст: ");
        int age = in.nextInt();
        
        int wasBorn = value - age;
        System.out.printf("Вы родились в %d году \n", wasBorn);
        in.close();
    }
}
