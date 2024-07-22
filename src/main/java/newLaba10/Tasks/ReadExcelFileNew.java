package newLaba10.Tasks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ReadExcelFileNew {

    public static void main(String[] args) {
        String str;
        Scanner scanner = new Scanner(System.in);
        XSSFWorkbook workbook;
        //Example "example/example.xlsx";
        System.out.println("Введите имя файла:");
        str = scanner.next();
        try {
            if (!str.endsWith("xlsx")) {
                throw new RuntimeException("Неверный формат файла, чтение файлов только с расширением xlsx");
            }
            try (FileInputStream inputStream = new FileInputStream(str)) {

                workbook = new XSSFWorkbook(inputStream);
            }

            //Example Товары
            System.out.println("Введите название страницы:");
            str = scanner.next();
            XSSFSheet sheet = workbook.getSheet(str);

            while (true) {

                if (sheet == null) {
                    System.out.println("Нет такой страницы!");
                    System.out.println("Введите название страницы заново:");
                    str = scanner.next();
                    sheet = workbook.getSheet(str);
                } else break;
            }

            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }
            workbook.close();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
