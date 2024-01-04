package dsa.catalogueOrder.levelUp.recursionAndBacktracking;

public class PalindromicPartitioningOfString {
    public static void main(String[] args) {
        String input = "mam";
        printPalindromicPartitions(input, "");
    }

    private static void printPalindromicPartitions(String str, String asf) {
        if (str.isEmpty()) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String prefix = str.substring(0, i + 1);
            if (isPalindrome(prefix)) {
                String ros = str.substring(i + 1);
                printPalindromicPartitions(ros, asf + "(" + prefix + ") ");
            }
        }
    }



    private static boolean isPalindrome(String str) {
        int lo = 0;
        int hi = str.length() - 1;
        while (lo <= hi) {
            if (str.charAt(lo) != str.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
