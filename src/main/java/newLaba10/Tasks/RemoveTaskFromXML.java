package newLaba10.Tasks;

import java.io.File;
import java.io.StringReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class RemoveTaskFromXML {
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
            Element task = nodeStream.filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                    .map(node -> (Element) node)
                    .filter(element -> {
                        String t =
                                element.getElementsByTagName("title").item(0).getTextContent();
                        String d = element.getElementsByTagName("date").item(0).getTextContent();
                        return t.equalsIgnoreCase(title) ||
                                d.equalsIgnoreCase(date);
                    }).findFirst().orElse(null);
            if (task != null) {
                System.out.println("Название задачи: " + task.getElementsByTagName("title").item(0)
                        .getTextContent());
                System.out.println("Описание: " + task.getElementsByTagName("description").item(0)
                        .getTextContent());
                System.out.println("Дата выполнения: " + task.getElementsByTagName("date").item(0)
                        .getTextContent());
                System.out.println("Время: " + task.getElementsByTagName("time").item(0)
                        .getTextContent());
                System.out.println("Стадия выполнения: " + task.getElementsByTagName("close").item(0)
                        .getTextContent());
                Node parentNode = task.getParentNode();
                parentNode.removeChild(task);
                System.out.println("Задача успешно удалена.");
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
