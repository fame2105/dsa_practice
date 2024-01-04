package dsa.catalogueOrder.levelUp.bitManipulation;

import java.util.Scanner;

public class __4_JosephusProblemSpecailizedCase {
    public static int solution(int n) {
        int l = n - highestPowerOf2Value(n);
        return 2 * l + 1;
    }

    private static int highestPowerOf2Value(int n) {
        int i = 1;
        while (i * 2 <= n) {
            i *= 2;
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solution(n));
    }
}
