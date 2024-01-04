package dsa.catalogueOrder.foundation.recursion.recursionWithArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class GetPermutations {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(getPermutations(str));
    }

    private static ArrayList<String> getPermutations(String str) {
        if (str.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        ArrayList<String> allPermuations = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            ArrayList<String> permutations = getPermutations(ros);

            for (String s : permutations) {
                allPermuations.add(c + s);
            }
        }
        return allPermuations;
    }
}
