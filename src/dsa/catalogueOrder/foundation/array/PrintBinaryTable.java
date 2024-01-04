package dsa.catalogueOrder.foundation.array;

import java.util.Scanner;

public class PrintBinaryTable {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int noOfBits = s.nextInt();
        int limit = (int) Math.pow(2, noOfBits);

        // how many total elements would be printed
        for (int i = 0; i < limit; i++) {
            int temp = i;
            String set = "";
            // this loop determines the value (0 or 1) for each of the positional bit
            for (int j = 0; j < noOfBits; j++) {
                int r = temp % 2;
                temp /= 2;

                if(r == 0) {
                    set = "0\t" + set;
                } else {
                    set = "1" + "\t" + set;
                }
            }
            System.out.println(set);
        }
    }
}
