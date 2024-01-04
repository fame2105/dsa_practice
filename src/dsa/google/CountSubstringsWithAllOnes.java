package dsa.google;

// https://binarysearch.com/problems/Count-Substrings-With-All-1s
public class CountSubstringsWithAllOnes {
    public int solve(String s) {
        int i = -1;
        int j = 0;

        int count = 0;

        while(j < s.length()) {
            char c = s.charAt(j);
            if(c == '1') {
                count += j - i;
            } else {
                i = j;
            }
            j++;
        }

        int mod = (int)1e9 + 7;
        return count % mod;
    }
}
