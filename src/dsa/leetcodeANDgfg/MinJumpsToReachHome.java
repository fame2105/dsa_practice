package dsa.leetcodeANDgfg;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/minimum-jumps-to-reach-home/
// Failing this testcase on leetcode . based on BFS
public class MinJumpsToReachHome {
    public static void main(String[] args) {
        int[] forbidden = {162,118,178,152,167,100,40,74,199,186,26,73,200,127,30,124,193,84,184,36,103,149,153,9,54,154,133,95,45,198,79,157,64,122,59,71,48,177,82,35,14,176,16,108,111,6,168,31,134,164,136,72,98};
        int a = 29;
        int b = 98;
        int x = 80;
        minimumJumps(forbidden, a, b, x);
    }
    private static class Pair {
        int i; // position
        int direction; // 0 : forward and 1 : backwards
        Pair(int i, int direction) {
            this.i = i;
            this.direction = direction;
        }
    }

    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> fset = new HashSet<>();
        for(int num : forbidden) fset.add(num);

        int farthest = 10000;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        visited.add(0);
        int jump = 0;

        while(q.size() > 0) {
            int size = q.size();

            for(int i = 1; i <= size; i++) {
                Pair rem = q.remove();
                System.out.println("Current Position : " + rem.i);
                if(rem.i == x) return jump;

                if(rem.direction == 0) { // forward direction

                    int i_a = rem.i + a;
                    if(i_a >=0 && !visited.contains(i_a) && i_a <= farthest && !fset.contains(i_a)) {
                        visited.add(i_a);
                        q.add(new Pair(i_a, 0));
                    }

                    int i_b = rem.i - b;
                    if(i_b >=0 && !visited.contains(i_b) && i_b <= farthest && !fset.contains(i_b)) {
                        visited.add(i_b);
                        q.add(new Pair(i_b, 1));
                    }
                } else { // negative direction
                    int i_a = rem.i + a;
                    if(i_a >=0 && !visited.contains(i_a) && i_a <= farthest && !fset.contains(i_a)) {
                        visited.add(i_a);
                        q.add(new Pair(i_a, 0));
                    }
                }
            }

            jump++;
        }

        return -1;
    }
}
