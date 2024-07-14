package newLaba10.Tasks;

import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import  org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.OutputKeys;
import java.io.File;

public class CreateTasksXML {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();
            Element rootElement = document.createElement("Scheduler");
            document.appendChild(rootElement);

            Element task1 = document.createElement("task");
            rootElement.appendChild(task1);

            Element title1 = document.createElement("title");
            title1.appendChild(document.createTextNode("Ремонт"));
            task1.appendChild(title1);

            Element description1 = document.createElement("description");
            description1.appendChild(document.createTextNode("Заменить окна"));
            task1.appendChild(description1);

            Element date1 = document.createElement("date");
            date1.appendChild(document.createTextNode("2 June"));
            task1.appendChild(date1);

            Element time1 = document.createElement("time");
            time1.appendChild(document.createTextNode("16:00"));
            task1.appendChild(time1);

            Element close1 = document.createElement("close");
            close1.appendChild(document.createTextNode("не завершена"));
            task1.appendChild(close1);

            Element task2 = document.createElement("task");
            rootElement.appendChild(task2);

            Element title2 = document.createElement("title");
            title2.appendChild(document.createTextNode("Покупка"));
            task2.appendChild(title2);

            Element description2 = document.createElement("description");
            description2.appendChild(document.createTextNode("Купить холодильник"));
            task2.appendChild(description2);

            Element date2 = document.createElement("date");
            date2.appendChild(document.createTextNode("21 June"));
            task2.appendChild(date2);

            Element time2 = document.createElement("time");
            time2.appendChild(document.createTextNode("10:00"));
            task2.appendChild(time2);

            Element close2 = document.createElement("close");
            close2.appendChild(document.createTextNode("не завершена"));
            task2.appendChild(close2);

            Element task3 = document.createElement("task");
            rootElement.appendChild(task3);

            Element title3 = document.createElement("title");
            title3.appendChild(document.createTextNode("Экзамен"));
            task3.appendChild(title3);

            Element description3 = document.createElement("description");
            description3.appendChild(document.createTextNode("Сдать экзамен по БД"));
            task3.appendChild(description3);

            Element date3 = document.createElement("date");
            date3.appendChild(document.createTextNode("30 June"));
            task3.appendChild(date3);

            Element time3 = document.createElement("time");
            time3.appendChild(document.createTextNode("8:00"));
            task3.appendChild(time3);

            Element close3 = document.createElement("close");
            close3.appendChild(document.createTextNode("не завершена"));
            task3.appendChild(close3);

            document.setXmlStandalone(true);
            document.normalizeDocument();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);

            File file = new File("example");
            if (!file.exists()) {
                if (file.mkdir()) {
                    System.out.println("Каталог example создан!!!");
                }
            }

            file = new File("example/task.xml");
            if (file.delete()) {
                System.out.println("example/task.xml удалён.");
            }
            if (file.createNewFile()) {
                System.out.println("example/task.xml Создан!!!");
            }

            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);

            System.out.println("XML-файл успешно создан");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
