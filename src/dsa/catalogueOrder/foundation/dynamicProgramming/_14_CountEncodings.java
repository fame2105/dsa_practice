package dsa.catalogueOrder.foundation.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _14_CountEncodings {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String digits = s.next();

        System.out.println(countEncodings(digits));
        printEncodingRecursivePreOrder(digits, 0, ""); // processing string from front
        System.out.println(getEncodingRecursivePostorder(digits, digits.length() - 1)); // processing String from back
        System.out.println(countEncodingRecursive(digits, digits.length() - 1));
    }

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

    private static int countEncodingRecursive(String digits, int idx) {
        if (idx == -1) {
            return 1;
        }

        int count = 0;
        int d1 = digits.charAt(idx) - '0';
        if (d1 != 0) {
            count += countEncodingRecursive(digits, idx - 1);
        }

        if (idx - 1 >= 0) {
            int firstDigitOfD2 = digits.charAt(idx - 1) - '0';
            if (firstDigitOfD2 != 0) {
                int d2 = firstDigitOfD2 * 10 + d1;
                if (d2 < 27) {
                    count += countEncodingRecursive(digits, idx - 2);
                }
            }
        }

        return count;
    }

    private static int countEncodingRecursiveMemoized(String digits, int idx, int[][] dp) {
        if (idx == -1) {
            return 1;
        }

        int count = 0;
        int d1 = digits.charAt(idx) - '0';
        if (d1 != 0) {
            count += countEncodingRecursive(digits, idx - 1);
        }

        if (idx - 1 >= 0) {
            int firstDigitOfD2 = digits.charAt(idx - 1) - '0';
            if (firstDigitOfD2 != 0) {
                int d2 = firstDigitOfD2 * 10 + d1;
                if (d2 < 27) {
                    count += countEncodingRecursive(digits, idx - 2);
                }
            }
        }

        return count;
    }

    private static int countEncodings(String digits) {
        int[] dp = new int[digits.length()];
        dp[0] = 1; // no of encodings that can be made with a single character is always 1 -> assuming 1st character is never 0

        for (int i = 1; i < dp.length; i++) {
            char currentChar = digits.charAt(i);
            char previousChar = digits.charAt(i - 1);
            if (currentChar == '0' && previousChar == '0') {
                dp[i] = 0;
            } else if (currentChar == '0' && previousChar != '0') {
                if (previousChar == '2' || previousChar == '1') {
                    dp[i] = i >= 2 ? dp[i - 2] : 1;
                } else {
                    dp[i] = 0;
                }
            } else if (currentChar != '0' && previousChar == '0') {
                dp[i] = dp[i - 1];
            } else {
                if (Integer.parseInt(digits.substring(i - 1, i + 1)) <= 26) {
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[digits.length() - 1];
    }
}
