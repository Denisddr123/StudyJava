package laba12;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Project1 {
    public static Pattern pattern = Pattern.compile("(([А-Яа-я])++[.,:;]+$)");
    public static Matcher matcher;
    public static ArrayList<String> arrayList = new ArrayList<>();
    public static Iterator<String> iterator;
    public static void main(String[] args) {
        RandomAccessFile randomAccessFileIn;
        RandomAccessFile randomAccessFileOut;
        List<String> list;
        String[] strings;
        String str;
        int numStr=0;
        try {
            File file = new File("storage");
            if (!file.exists()) {
                if (file.mkdir()) {
                    System.out.println("storage создана!!!");
                }
            }
            file = new File("storage/projectIn.txt");
            if (file.delete()) {
                System.out.println("storage/projectIn.txt remove");
            }
            if (file.createNewFile()) {
                System.out.println("projectIn.txt Создан!!!");
            }
            File file2 = new File("storage/projectOut.txt");
            if (file2.delete()) {
                System.out.println("storage/projectOut.txt remove");
            }
            if (file2.createNewFile()) {
                System.out.println("projectOut.txt Создан!!!");
            }
            randomAccessFileOut = new RandomAccessFile(file, "rw");
            randomAccessFileOut.writeUTF("Октябрь уж наступил — уж роща отряхает\n"+
                    "Последние листы с нагих своих ветвей;\n"+
                    "Дохнул осенний хлад — дорога промерзает.\n" +
                    "Журча еще бежит за мельницу ручей,\n" +
                    "Но пруд уже застыл; сосед мой поспешает\n" +
                    "В отъезжие поля с охотою своей,\n");
            randomAccessFileOut.writeUTF("И страждут озими от бешеной забавы,\n");
            randomAccessFileOut.writeUTF("И будит лай собак уснувшие дубравы.\n");
            randomAccessFileOut.writeUTF("Теперь моя пора: я не люблю весны;\n" +
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
            randomAccessFileOut.close();
            randomAccessFileIn = new RandomAccessFile(file, "r");
            randomAccessFileOut = new RandomAccessFile(file2, "rw");
            System.out.println("____________________________________________________________");
            System.out.println("Стихотворение осень. Запись в первый файл");
            System.out.println("____________________________________________________________");
            while (randomAccessFileIn.length()>(randomAccessFileIn.getFilePointer())) {
                try {
                    str = randomAccessFileIn.readUTF();
                    for (String s : str.split("\n")) {
                        numStr++;
                        strings = getArrayWord(s);
                        strings = getArrayWordOfPattern(strings);
                        list = consonantLetter(strings);
                        str = recordsToFile(list, numStr);
                        randomAccessFileOut.writeUTF(str);

                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage()+" Выход из цикла, конец файла.");
                    randomAccessFileIn.close();
                    randomAccessFileOut.close();
                    break;
                }

            }
            System.out.println("____________________________________________________________");
            System.out.println("Чтение из второго файла");
            System.out.println("____________________________________________________________");
            randomAccessFileIn = new RandomAccessFile(file2, "r");
            while (true) {
                try {
                    System.out.println(randomAccessFileIn.readUTF());
                } catch (IOException e) {
                    System.out.println(e.getMessage()+" Выход из цикла, конец файла.");
                    randomAccessFileIn.close();
                    return;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String[] getArrayWord(String str) {
        String[] strings;
        String s;
        arrayList.clear();
        System.out.println(str);
        for (String s3 : str.split(" ")) {
            arrayList.add(s3.trim());
        }
        iterator = arrayList.listIterator();
        strings = new String[arrayList.size()];
        int i = 0, j;
        while (iterator.hasNext()) {
            s = iterator.next();
            strings[i] = s;
            j = s.length();
            matcher = pattern.matcher(s);
            if (matcher.find()) {
                strings[i] = s.substring(0, j-1);
            }
            i++;
        }
        return strings;
    }
    public static String[] getArrayWordOfPattern(String[] strings) {
        String s, pat;
        int x=0;
        arrayList.clear();
        s = strings[0].trim();
        pat = s.toLowerCase().substring(0, 1);
        arrayList.add(s);

        for (int i=1; i<strings.length; i++) {
            s = strings[i];
            if (s.toLowerCase().substring(0, 1).equals(pat)) {
                arrayList.add(s);
            }
        }
        iterator = arrayList.listIterator();
        strings = new String[arrayList.size()];
        while (iterator.hasNext()) {
            strings[x]=iterator.next();
            x++;
        }
        return  strings;
    }
    public static List<String> consonantLetter(String[] strings) {
        Stream<String> stream = Arrays.stream(strings);
        List<String> list = stream.collect(Collectors.toList());
        stream.close();
        return list;
    }
    public static String recordsToFile(List<String> list, int numStr) throws IOException {
        ListIterator<String> listIterator;
        int count = list.size();
        StringBuilder str = new StringBuilder("Строка номер: " + numStr + " количество слов: " + count + " слова: ");

        listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            str.append(listIterator.next()).append(" ");
        }
        return new String(str);
    }
}
