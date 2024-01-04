package dsa.google;

// https://binarysearch.com/problems/Removing-Triple-Successive-Duplicates
public class RemoveTripleSuccessiveDuplicates {

    public int removeTripleSuccessiveDuplicates(String s) {
        if (s.length() == 0)
            return 0;

        int ans = 0;
        int count = 1;
        for(int i = 1; i < s.length(); i++) {
            char cc = s.charAt(i);
            char pc = s.charAt(i-1);

            if(cc == pc)
                count++;
            else
                count = 1;

            if(count == 3) {
                ans++;
                count = 0;
            }
        }

        return ans;
    }
}
