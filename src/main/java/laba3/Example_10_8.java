package laba3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example_10_8 {
    public static void main(String[] args) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        str = str.toUpperCase();

        Pattern pattern = Pattern.compile("[AEIOU]");
        Matcher matcher = pattern.matcher(str);
        String string = matcher.replaceAll("");
        String[] strings = string.split("");

        for (String key : strings) {
            System.out.print(key+" ");
        }
    }
}
