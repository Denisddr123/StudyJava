package newLaba10.Tasks;

import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonCreatorTask {
    public static void main(String[] args) {
        JSONObject scheduler = new JSONObject();
        JSONArray tasks = new JSONArray();

        JSONObject task1 = new JSONObject();
        task1.put("title", "Ремонт");
        task1.put("description", "Заменить окна");
        task1.put("date", "2 June");
        task1.put("time", "16:00");
        task1.put("close", "не завершена");

        JSONObject task2 = new JSONObject();
        task2.put("title", "Покупка");
        task2.put("description", "Купить холодильник");
        task2.put("date", "21 June");
        task2.put("time", "10:00");
        task2.put("close", "не завершена");

        JSONObject task3 = new JSONObject();
        task3.put("title", "Экзамен");
        task3.put("description", "Сдать экзамен по БД");
        task3.put("date", "30 June");
        task3.put("time", "8:00");
        task3.put("close", "не завершена");

        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        scheduler.put("tasks", tasks);

        try (FileWriter fileWriter = new FileWriter("example/task.json")) {
            fileWriter.write(scheduler.toJSONString());
            System.out.println("Json файл успешно создан!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
