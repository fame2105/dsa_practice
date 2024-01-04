package dsa.leetcodeANDgfg;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame7 {
    public static void main(String[] args) {
        canReach("011010", 2, 3);
    }

    public static boolean canReach(String s, int minJump, int maxJump) {
        int len = s.length();
        if (s.charAt(len - 1) == '1') return false;

        Queue<Integer> q = new LinkedList<>(); // will contain idx
        q.add(0);

        // This variable tells us till which index we have processed
        int farthest = 0;
        while (q.size() > 0) {
            int rem = q.remove();

            // If we reached the last index
            if (rem == len - 1) return true;

            System.out.println("farthest so far :" + farthest);

            // start the loop from max of [current maximum (rem + minJump), maximum processed index (maxReach)]
            for (int j = Math.max(rem + minJump, farthest); j <= Math.min(rem + maxJump, len - 1); j++) {
                if (s.charAt(j) == '0') q.add(j);
            }
            // since we have processed till rem + maxJump so update maxReach to next index
            farthest = Math.min(rem + maxJump + 1, len - 1);
        }

        return false;
    }
}
