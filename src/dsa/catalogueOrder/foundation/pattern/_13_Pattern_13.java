package dsa.catalogueOrder.foundation.pattern;

import java.util.Scanner;

public class _13_Pattern_13 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for(int i = 0; i < n; i++) {
            int val = 1;
            for(int j = 0; j <= i; j++) {
                System.out.print(val + "\t");
                int nextVal = (val * (i - j)) / (j + 1);
                val = nextVal;
            }
            System.out.print("\n");
        }
    }
}