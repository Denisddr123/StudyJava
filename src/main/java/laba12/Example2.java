package laba12;

import java.io.*;

public class Example2 {
    public static void main(String[] args) {
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        int lineCount = 0;
        String str;
        try {
            File folder = new File("storage");
            if (!folder.exists()) {
                if (folder.mkdir()) {
                    System.out.println("storage создана!!!");
                }
            }
            bufferedWriter = new BufferedWriter(new FileWriter("storage/MyFile.txt"));
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
            bufferedReader = new BufferedReader(new FileReader("storage/MyFile.txt"), 1024);
            bufferedWriter = new BufferedWriter(new FileWriter("storage/MyFile2.txt"));

            while ((str = bufferedReader.readLine()) !=null) {
                lineCount++;
                System.out.println(lineCount+": " + str);
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Ошибка!!!!");
        }
    }
}
