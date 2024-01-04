package dsa.catalogueOrder.foundation.pattern;

import java.util.Scanner;

public class NumericDiamondPattern {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int space = n / 2;
        int noOfValuesInEachRow = 1;
        int rowVal = 1;
        for (int i = 1; i <= n; i++) {
            // print spaces
            for (int j = 1; j <= space; j++) {
                System.out.print("\t");
            }

            // print numbers
            int columnVal = rowVal;
            for (int j = 1; j <= noOfValuesInEachRow; j++) {
                System.out.print(columnVal + "\t");
                if (j <= noOfValuesInEachRow / 2) {
                    columnVal++;
                } else {
                    columnVal--;
                }
            }

            if (i <= n / 2) {
                space--;
                noOfValuesInEachRow += 2;
                rowVal++;
            } else {
                space++;
                noOfValuesInEachRow -= 2;
                rowVal--;
            }

            System.out.println();
        }
    }
}
