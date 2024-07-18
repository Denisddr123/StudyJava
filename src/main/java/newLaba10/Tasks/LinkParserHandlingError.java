package newLaba10.Tasks;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class LinkParserHandlingError {
    public static void main(String[] args) {
        String url = "https://ria.ru/world/";
        JSONObject newslinks = new JSONObject();
        JSONArray news = new JSONArray();
        JSONObject jsonObject;
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            Elements links = doc.getElementsByTag("a");
            if (links.isEmpty()) {
                throw new RuntimeException("Нет html элементов <a>.");
            }
            for (Element link : links) {
                String newsLink = link.attr("abs:href");
                String newsText = link.text().trim();
                if (!newsText.isBlank() && !newsLink.isBlank()) {
                    jsonObject = new JSONObject();
                    jsonObject.put("link", newsLink);
                    jsonObject.put("title", newsText);
                    news.add(jsonObject);
                    System.out.println(newsText);
                    System.out.println(newsLink);
                }
            }
            newslinks.put("news", news);
            if (news.isEmpty()) throw new RuntimeException("Список новостей пуст.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter fileWriter = new FileWriter("example/news.json")) {
            fileWriter.write(newslinks.toJSONString());
            System.out.println("Json файл успешно записан!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
