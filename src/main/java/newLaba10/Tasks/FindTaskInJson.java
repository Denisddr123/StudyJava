package newLaba10.Tasks;

import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FindTaskInJson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название задачи:");
        String title = scanner.nextLine().trim();
        try {
            JSONParser parser = new JSONParser();
            Object o = parser.parse(new FileReader("example/task.json"));
            JSONObject jsonObject = (JSONObject) o;
            JSONArray jsonArray = (JSONArray) jsonObject.get("tasks");

            List<JSONObject> list = jsonArray.stream().map(task -> (JSONObject) task).toList();
            list.stream().filter(task -> title.equalsIgnoreCase((String) task.get("title"))).forEach(task -> {
                System.out.println("\nТекущий элемент: task");
                System.out.println("Название задачи: " + task.get("title"));
                System.out.println("Описание: " + task.get("description"));
                System.out.println("Дата выполнения: " + task.get("date"));
                System.out.println("Время: " + task.get("time"));
                System.out.println("Стадия выполнения: " + task.get("close"));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
