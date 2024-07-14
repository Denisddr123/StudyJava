package newLaba10.Tasks;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class FindTaskInXML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название задачи:");
        String title = scanner.nextLine().trim();
        System.out.println("Введите дату выполнения задачи:");
        String date = scanner.nextLine().trim();
        try {
            File file = new File("example/task.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("task");
            Stream<Node> nodeStream = IntStream.range(0, nodeList.getLength())
                    .mapToObj(nodeList::item);
            List<Element> tasks = nodeStream.filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                    .map(node -> (Element) node)
                    .filter(element -> {
                        String t =
                                element.getElementsByTagName("title").item(0).getTextContent();
                        String d = element.getElementsByTagName("date").item(0).getTextContent();
                        return t.equalsIgnoreCase(title) ||
                                d.equalsIgnoreCase(date);
                    }).toList();
            for (Element element : tasks) {
                System.out.println("Название задачи: " + element.getElementsByTagName("title").item(0)
                        .getTextContent());
                System.out.println("Описание: " + element.getElementsByTagName("description").item(0)
                        .getTextContent());
                System.out.println("Дата выполнения: " + element.getElementsByTagName("date").item(0)
                        .getTextContent());
                System.out.println("Время: " + element.getElementsByTagName("time").item(0)
                        .getTextContent());
                System.out.println("Стадия выполнения: " + element.getElementsByTagName("close").item(0)
                        .getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
