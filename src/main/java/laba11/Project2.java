package laba11;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Project2 {
    public static void main(String[] args) {
        BufferedWriter bufferedWriter;
        BufferedReader bufferedReader;
        String str;
        String[] strings;
        int i = 0;
        try {
            File folder = new File("storage");
            if (!folder.exists()) {
                if (folder.mkdir()) {
                    System.out.println("storage создана!!!");
                }
            }
            File file1 = new File("storage/Project2.txt");
            File file2 = new File("storage/Project2Out.txt");
            if (file1.delete()) {
                System.out.println("Project2.txt remove");
            }
            if (file1.createNewFile()) {
                System.out.println("Project2.txt полный путь: "+ file1.getAbsolutePath());
            }
            if (file2.delete()) {
                System.out.println("Project2Out.txt remove");
            }
            if (file2.createNewFile()) {
                System.out.println("Project2Out.txt полный путь: "+ file2.getAbsolutePath());
            }
            bufferedWriter = Files.newBufferedWriter(file1.toPath());
            bufferedWriter.write("Октябрь уж наступил — уж роща отряхает");
            bufferedWriter.newLine();
            bufferedWriter.write("Последние листы с нагих своих ветвей;");
            bufferedWriter.newLine();
            bufferedWriter.write("Дохнул осенний хлад — дорога промерзает.\n" +
                    "Журча еще бежит за мельницу ручей,\n" +
                    "Но пруд уже застыл; сосед мой поспешает\n" +
                    "В отъезжие поля с охотою своей,\n" +
                    "И страждут озими от бешеной забавы,\n" +
                    "И будит лай собак уснувшие дубравы.\n" +
                    "Теперь моя пора: я не люблю весны;\n" +
                    "Скучна мне оттепель; вонь, грязь — весной я болен;\n" +
                    "Кровь бродит; чувства, ум тоскою стеснены.\n" +
                    "Суровою зимой я более доволен,\n" +
                    "Люблю ее снега; в присутствии луны\n" +
                    "Как легкий бег саней с подругой быстр и волен,\n" +
                    "Когда под соболем, согрета и свежа,\n" +
                    "Она вам руку жмет, пылая и дрожа!\n" +
                    "Как весело, обув железом острым ноги,\n" +
                    "Скользить по зеркалу стоячих, ровных рек!\n" +
                    "А зимних праздников блестящие тревоги?\n" +
                    "Но надо знать и честь; полгода снег да снег,\n" +
                    "Ведь это наконец и жителю берлоги,\n" +
                    "Медведю, надоест. Нельзя же целый век\n" +
                    "Кататься нам в санях с Армидами младыми\n" +
                    "Иль киснуть у печей за стеклами двойными.\n" +
                    "Ох, лето красное! любил бы я тебя,\n" +
                    "Когда б не зной, да пыль, да комары, да мухи.\n" +
                    "Ты, все душевные способности губя,\n" +
                    "Нас мучишь; как поля, мы страждем от засухи;\n" +
                    "Лишь как бы напоить, да освежить себя —\n" +
                    "Иной в нас мысли нет, и жаль зимы старухи,\n" +
                    "И, проводив ее блинами и вином,\n" +
                    "Поминки ей творим мороженым и льдом.\n" +
                    "Дни поздней осени бранят обыкновенно,\n" +
                    "Но мне она мила, читатель дорогой,\n" +
                    "Красою тихою, блистающей смиренно.\n" +
                    "Так нелюбимое дитя в семье родной\n" +
                    "К себе меня влечет. Сказать вам откровенно,\n" +
                    "Из годовых времен я рад лишь ей одной,\n" +
                    "В ней много доброго; любовник не тщеславный,\n" +
                    "Я нечто в ней нашел мечтою своенравной.");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();

            bufferedReader = Files.newBufferedReader(file1.toPath());
            bufferedWriter = Files.newBufferedWriter(file2.toPath());
            while (true) {
                i++;
                try {
                    str = bufferedReader.readLine();
                    if (str != null) {
                        strings = getArrayWord(str);
                        recordsToFile(bufferedWriter, consonantLetter(strings), i);
                    } else {
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        bufferedReader.close();
                        return;
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    bufferedReader.close();
                    return;
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static String[] getArrayWord(String str) {
        String[] strings;
        String s;
        int x;
        strings = str.split(" ");
        for (int i=0; i<strings.length; i++) {
            s=strings[i].trim();
            x = s.length();
            if (s.matches("(.+[,.:;])$")) {
                strings[i] = s.substring(0, x-1);
            }
        }
        return strings;
    }
    public static List<String> consonantLetter(String[] strings) {
        Stream<String> stream = Arrays.stream(strings).filter(o -> o.matches("^[йцкнгшщзхфвпрлджчсмтбЦКНГШЩЗХФВПРЛДЖЧСМТБ]+[а-я]*"));
        List<String> list = stream.collect(Collectors.toList());
        stream.close();
        return list;
    }
    public static void recordsToFile(BufferedWriter bufferedWriter, List<String> list, int numStr) throws IOException {
        ListIterator<String> listIterator;
        int count = list.size();
        StringBuilder str = new StringBuilder("Строка номер: " + numStr + " количество слов: " + count + " слова: ");

        listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            str.append(listIterator.next()).append(" ");
        }
        str.append("\n");
        System.out.print(str);
        bufferedWriter.write(String.valueOf(str));
    }
}
