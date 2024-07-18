package newLaba10.Tasks;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;

public class RemoveTaskFromJson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название задачи:");
        String title = scanner.nextLine().trim();
        try {
            JSONParser parser = new JSONParser();
            Object o = parser.parse(new FileReader("example/task.json"));
            JSONObject scheduler = (JSONObject) o;
            var ref = new Object() {
                int x;
                final JSONArray jsonArray = (JSONArray) scheduler.get("tasks");
            };
            Iterator<JSONObject> iterator = ref.jsonArray.iterator();
            iterator.forEachRemaining(obj -> {
                if (title.equalsIgnoreCase((String) obj.get("title"))) {
                    ref.x = ref.jsonArray.indexOf(obj);
                    System.out.println(obj.get("description")+" "+obj.get("date"));
                }
            });
            if (!ref.jsonArray.isEmpty()) {
                ref.jsonArray.remove(ref.x);
            }

            FileWriter fileWriter = new FileWriter("example/task.json");
            fileWriter.write(scheduler.toJSONString());
            fileWriter.flush();
            fileWriter.close();

            for (Object object: ref.jsonArray) {
                System.out.println("\nТекущий элемент: task");
                JSONObject task = (JSONObject) object;
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
