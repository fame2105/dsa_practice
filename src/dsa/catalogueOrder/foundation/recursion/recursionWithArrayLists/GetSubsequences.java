package dsa.catalogueOrder.foundation.recursion.recursionWithArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class GetSubsequences {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        ArrayList<String> subsequences = getSubsequences(input);
        System.out.println(subsequences);
    }

    private static ArrayList<String> getSubsequences(String str) {
        if (str.length() == 0) {
            ArrayList<String> emptyArrayList = new ArrayList<String>();
            emptyArrayList.add("");
            return emptyArrayList;
        }

        char fc = str.charAt(0);
        str = str.substring(1);
        ArrayList<String> subsequences = getSubsequences(str);
        ArrayList<String> allSubsequences = new ArrayList<String>();
        for (String s : subsequences) {
            allSubsequences.add("" + s);
            allSubsequences.add(fc + s);
        }
        return allSubsequences;


    }
}
