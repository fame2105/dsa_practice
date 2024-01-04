package dsa.catalogueOrder.foundation.recursion.printRecursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintEncodings {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();

        printEncodingRecursivePreOrder(input, 0,"");
    }

    // input -> digits -> string
    // asf -> answer so far / path so far
    // idx -> starts from 0
    private static void printEncodingRecursivePreOrder(String digits, int idx, String psf) {
        if (idx >= digits.length()) {
            System.out.println(psf);
            return;
        }

        // extract 1st digit
        int d1 = digits.charAt(idx) - '0';
        char cd1 = (char) (d1 - 1 + 'a');
        if (d1 == 0) return;
        printEncodingRecursivePreOrder(digits, idx + 1, psf + cd1); // print encodings for remaining strings

        // extract 2nd digit
        if (idx + 1 < digits.length()) {
            int d2 = d1 * 10 + digits.charAt(idx + 1) - '0';
            if (d2 < 27) {
                char cd2 = (char) (d2 - 1 + 'a');
                printEncodingRecursivePreOrder(digits, idx + 2, psf + cd2); // print encodings for remaining strings
            }
        }

    }

    // input -> digits -> string
    // current index -> start from (digits.length()-1)
    private static List<String> getEncodingRecursivePostorder(String digits, int idx) {
        if (idx == -1) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }

        List<String> result = new ArrayList<>();
        List<String> internalResults;
        int d1 = digits.charAt(idx) - '0';
        if (d1 != 0) {
            char cd1 = (char) (d1 - 1 + 'a');
            internalResults = getEncodingRecursivePostorder(digits, idx - 1);
            for (String str : internalResults) {
                result.add(str + cd1);
            }
        }

        if (idx - 1 >= 0) {
            int firstDigitOfD2 = digits.charAt(idx - 1) - '0';
            if (firstDigitOfD2 != 0) {
                int d2 = firstDigitOfD2 * 10 + d1;
                if (d2 < 27) {
                    char cd2 = (char) (d2 - 1 + 'a');
                    internalResults = getEncodingRecursivePostorder(digits, idx - 2);
                    for (String str : internalResults) {
                        result.add(str + cd2);
                    }
                }
            }
        }

        return result;
    }

}
