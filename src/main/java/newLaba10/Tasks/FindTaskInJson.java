package newLaba10.Tasks;

import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/*import org.json.JSONArray;
import org.json.JSONObject;*/
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
            //System.out.println("Корневой элемент: " + jsonObject.keySet().iterator().next());
            JSONArray jsonArray = (JSONArray) jsonObject.get("tasks");
            Stream<JSONObject> jsonObjectStream = IntStream.range(0, jsonArray.size())
                    .mapToObj(jsonArray.);
jsonObjectStream.filter(task -> task != null)
                            .map(task -> (JSONObject) task)
                                    .filter(task -> title.equals(task.get("title")))
                                            .forEach(task -> {
                                                System.out.println("\nТекущий элемент: task");
                                                System.out.println("Название задачи: " + task.get("title"));
                                                System.out.println("Описание: " + task.get("description"));
                                                System.out.println("Дата выполнения: " + task.get("date"));
                                                System.out.println("Время: " + task.get("time"));
                                                System.out.println("Стадия выполнения: " + task.get("close"));
                                            });

           /* jsonArray.stream().filter(task -> task instanceof JSONObject)
                    //.map(task -> (JSONObject) task)
            jsonArray.stream().filter(task -> title.equals()).forEach(task -> {
                        System.out.println("\nТекущий элемент: task");
                        System.out.println("Название задачи: " + task.get("title"));
                        System.out.println("Описание: " + task.get("description"));
                        System.out.println("Дата выполнения: " + task.get("date"));
                        System.out.println("Время: " + task.get("time"));
                        System.out.println("Стадия выполнения: " + task.get("close"));
                    });*/

            for (Object object : jsonArray) {
                JSONObject task = (JSONObject) object;
                System.out.println("\nТекущий элемент: task");
                System.out.println("Название задачи: " + task.get("title"));
                System.out.println("Описание: " + task.get("description"));
                System.out.println("Дата выполнения: " + task.get("date"));
                System.out.println("Время: " + task.get("time"));
                System.out.println("Стадия выполнения: " + task.get("close"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
