package laba10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] array = {{3, 2, 1, 7},
                        {9, 11, 5, 4},
                        {6, 0, 13, 17},
                        {7, 21, 14, 15}};
        System.out.println("Чтобы вывести столбец квадратной матрицы 4х4, введите его номер");
        try {
            int x = getInt(scanner);
            checkRange(x);
            System.out.println("Вывод столбца");
            for (int i=0; i<4; i++) {
                System.out.println(array[i][x-1]);
            }
        } catch (InputMismatchException e) {
            System.out.println("Введённое значение не соответствует целочисленному типу.");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void checkRange(int x) throws MyException {
        if (1>x || x>4) throw new MyException("Такого столбца нет.");
    }
    public static int getInt(Scanner scanner) throws InputMismatchException {
        return scanner.nextInt();
    }
}
