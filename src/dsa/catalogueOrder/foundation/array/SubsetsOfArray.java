package dsa.catalogueOrder.foundation.array;

import java.util.Scanner;

// Iterative Procedure
// Refer PrintBinaryTable problem -> this question leverages the same concept.

public class SubsetsOfArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.next();
        }
        printSubsets(arr);
    }

    private static void printSubsets(String arr[]) {
        int limit = (int) Math.pow(2, arr.length);
        for(int i = 0; i < limit; i++) {

            String set = "";
            int temp = i;

            // Inner loop runs in reverse order because last bit is operated first
            for(int j = arr.length - 1; j>=0; j--) {
                int r = temp % 2;
                temp = temp / 2;

                if(r == 0) {
                    set = "-\t" + set;
                }else {
                   set = arr[j] + "\t" + set;
                }
            }
            System.out.println(set);
        }
    }
}
