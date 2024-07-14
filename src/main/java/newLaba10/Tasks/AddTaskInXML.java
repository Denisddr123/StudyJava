package newLaba10.Tasks;

import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import  org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.OutputKeys;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.io.File;
import java.io.StringReader;
import java.util.Scanner;

public class AddTaskInXML {
    public static void main(String[] args) {
        try {
            File file = new File("example/task.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            Element rootElement = document.getDocumentElement();
            System.out.println("Корневой элемент: " + rootElement.getNodeName());

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

            Element task1 = document.createElement("task");
            rootElement.appendChild(task1);

            Element title1 = document.createElement("title");
            title1.appendChild(document.createTextNode(title));
            task1.appendChild(title1);

            Element description1 = document.createElement("description");
            description1.appendChild(document.createTextNode(description));
            task1.appendChild(description1);

            Element date1 = document.createElement("date");
            date1.appendChild(document.createTextNode(date));
            task1.appendChild(date1);

            Element time1 = document.createElement("time");
            time1.appendChild(document.createTextNode(time));
            task1.appendChild(time1);

            Element close1 = document.createElement("close");
            close1.appendChild(document.createTextNode(close));
            task1.appendChild(close1);

            NodeList nodeList = document.getElementsByTagName("task");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("\nТекущий элемент: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
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
            }

            document.setXmlStandalone(true);
            document.normalizeDocument();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            String string = "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">" +
                    "<xsl:strip-space elements=\"*\"/>" +
                    "<xsl:output method=\"xml\" encoding=\"UTF-8\"/>" +
                    "<xsl:template match=\"@*|node()\">" +
                    "<xsl:copy>" +
                    "<xsl:apply-templates select=\"@*|node()\"/>" +
                    "</xsl:copy>" +
                    "</xsl:template>" +
                    "</xsl:stylesheet>";
            Transformer transformer = transformerFactory.newTransformer(new StreamSource(new StringReader(string)));

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            file = new File("example/task.xml");

            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
