package dsa.leetcodeANDgfg.Greedy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/task-scheduler/   #Greedy
public class _621_TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        System.out.println(leastInterval(tasks, 2));
    }


    private static class Pair implements Comparable<Pair> {
        char c;
        int f;
        int rt;
        Pair(char c, int f, int rt) {
            this.rt = rt;
            this.f = f;
            this.c = c;
        }

        public int compareTo(Pair o) {
            return o.f - this.f;
        }
    }

    /**
     * Idea is to perform those tasks first that have the highest frequency
     * Algo : (Dry Run it once with a small example : {A, A, B, B} n = 2
     * Do this while (either pq or q is not empty)
     * 1. Get element from PQ.
     * 2. increase time // maintain a counter to count the time
     * 3. Decreased the frequency of removed task from step 1 .... if the frequency becomes 0, then don't do anything on this task
     * 4. if frequency > 0 then push this element in a standard queue (set resumeTime/IdleTime for this task as [time + n]
     * 5. Check if the element at the peek of queue is == current time then remove from queue and input into PQ
     * @param tasks
     * @param n
     * @return
     */
    public static int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(); // Max Heap, in terms of frequency of tasks
        for(Character key : map.keySet()) {
            pq.add(new Pair(key, map.get(key), 0));
        }

        int time = 0;
        Queue<Pair> q = new LinkedList<>();
        while(pq.size() >0 || q.size() > 0) {
            time++;

            if(pq.size() > 0) {
                Pair rem = pq.remove();
                rem.f = rem.f - 1;
                if(rem.f > 0) {
                    rem.rt = time + n;
                    q.add(rem);
                }
            }

            if(q.size() > 0 && q.peek().rt == time) {
                pq.add(q.remove());
            }
        }
        return time;
    }
}
