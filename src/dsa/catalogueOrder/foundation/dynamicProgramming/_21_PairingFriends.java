package dsa.catalogueOrder.foundation.dynamicProgramming;

public class _21_PairingFriends {
    public static void main(String[] args) {
        perfectFriendsRecursive("1234", "");
        System.out.println(countPairCombinations(4));
    }

    private static void perfectFriendsRecursive(String str, String psf) {
        if (str.length() == 0) {
            System.out.println(psf);
            return;
        }

        char cc = str.charAt(0);
        String ros = str.substring(1);

        // single call
        perfectFriendsRecursive(ros, psf + cc + " ");

        // pair calls
        for (int i = 0; i < ros.length(); i++) {
            String pair = "" + cc + ros.charAt(i);
            String rem = ros.substring(0, i) + ros.substring(i + 1);
            perfectFriendsRecursive(rem, psf + pair + " ");
        }
    }

    private static int countPairCombinations(int n) {
        int a = 1; // base case : if only 1 person is available, then only 1 way to pair this single person... remain single
        int b = 2; // if 2 person available, then 2 ways to pair them 1. either both remain single or 2. both form a pair... 2 ways
        for (int i = 3; i <= n; i++) { //  run a loop for 3 persons to n persons available
            int c = b + (i - 1) * a;
            a = b;
            b = c;
        }
        return b;
    }
}
