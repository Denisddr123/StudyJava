package newLaba10;

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

public class Example1_1 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();
            Element rootElement = document.createElement("Library");
            document.appendChild(rootElement);

            Element book1 = document.createElement("book");
            rootElement.appendChild(book1);

            Element title1 = document.createElement("title");
            title1.appendChild(document.createTextNode("Война и мир"));
            book1.appendChild(title1);

            Element author1 = document.createElement("author");
            author1.appendChild(document.createTextNode("Лев Толстой"));
            book1.appendChild(author1);

            Element year1 = document.createElement("year");
            year1.appendChild(document.createTextNode("1869"));
            book1.appendChild(year1);

            Element book2 = document.createElement("book");
            rootElement.appendChild(book2);

            Element title2 = document.createElement("title");
            title2.appendChild(document.createTextNode("Мастер и Маргарита"));
            book2.appendChild(title2);

            Element author2 = document.createElement("author");
            author2.appendChild(document.createTextNode("Михаил Булгаков"));
            book2.appendChild(author2);

            Element year2 = document.createElement("year");
            year2.appendChild(document.createTextNode("1967"));
            book2.appendChild(year2);

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

            file = new File("example/example.xml");
            if (file.delete()) {
                System.out.println("example/example.xml удалён.");
            }
            if (file.createNewFile()) {
                System.out.println("example/example.xml Создан!!!");
            }

            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);

            System.out.println("XML-файл успешно создан");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
