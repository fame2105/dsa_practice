package dsa.catalogueOrder.levelUp.bitManipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class __5_GrayCode {
    public static List<String> grayCode(int n) {
        if(n == 1) {
            List<String> initialGrayCodes = new ArrayList<>();
            initialGrayCodes.add("0");
            initialGrayCodes.add("1");
            return initialGrayCodes;
        }

        List<String> recResult = grayCode(n - 1);
        List<String> myResult = new ArrayList<>();

        for (String code : recResult) {
            myResult.add("0" + code);
        }

        for (int i = recResult.size() - 1; i >= 0; i--) {
            myResult.add("1" + recResult.get(i));
        }
        return myResult;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // n > 0
        List<Integer> ans = grayCode(n).stream().map(x -> Integer.valueOf(x)).collect(Collectors.toList());
        Collections.sort(ans);
        System.out.println(ans);
    }
}
