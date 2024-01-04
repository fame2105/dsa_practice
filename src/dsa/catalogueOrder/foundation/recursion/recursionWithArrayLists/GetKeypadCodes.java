package dsa.catalogueOrder.foundation.recursion.recursionWithArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class GetKeypadCodes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        ArrayList<String> words = getKeypadCodes(str);
        System.out.println(words);
    }

    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    private static ArrayList<String> getKeypadCodes(String str) {
        if (str.length() == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        char ch = str.charAt(0);
        int keypadValue = Integer.parseInt(String.valueOf(ch));
        String ros = str.substring(1);
        ArrayList<String> keypadCodes = getKeypadCodes(ros);
        ArrayList<String> allKeyPadCodes = new ArrayList<>();

        for (String val : keypadCodes) {
            for (char c : codes[keypadValue].toCharArray()) {
                allKeyPadCodes.add(c + val);
            }
        }
        return allKeyPadCodes;
    }
}
