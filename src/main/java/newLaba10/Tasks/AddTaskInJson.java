package newLaba10.Tasks;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class AddTaskInJson {
    public static void main(String[] args) {
        try {
            JSONParser parser = new JSONParser();
            Object o = parser.parse(new FileReader("example/task.json"));
            JSONObject scheduler = (JSONObject) o;
            JSONArray jsonArray = (JSONArray) scheduler.get("tasks");
            JSONObject jsonObject = new JSONObject();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название задачи:");
            String title = scanner.nextLine().trim();
            System.out.println("Введите описание задачи:");
            String description = scanner.nextLine().trim();
            System.out.println("Введите дату выполнения задачи:");
            String date = scanner.nextLine().trim();
            System.out.println("Введите время выполнения задачи:");
            String time = scanner.nextLine().trim();
            System.out.println("Статус выполнения задачи:");
            String close = scanner.nextLine().trim();

            jsonObject.put("title", title);
            jsonObject.put("description", description);
            jsonObject.put("date", date);
            jsonObject.put("time", time);
            jsonObject.put("close", close);

            jsonArray.add(jsonObject);

            FileWriter fileWriter = new FileWriter("example/task.json");
            fileWriter.write(scheduler.toJSONString());
            fileWriter.flush();
            fileWriter.close();

            for (Object object : jsonArray) {
                JSONObject task = (JSONObject) object;
                System.out.println("\nТекущий элемент: task");
                System.out.println("Название задачи: " + task.get("title"));
                System.out.println("Описание: " + task.get("description"));
                System.out.println("Дата выполнения: " + task.get("date"));
                System.out.println("Время: " + task.get("time"));
                System.out.println("Стадия выполнения: " + task.get("close"));
            }

            System.out.println("Json файл успешно создан!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
