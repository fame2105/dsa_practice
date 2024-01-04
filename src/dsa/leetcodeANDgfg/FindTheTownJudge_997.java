package dsa.leetcodeANDgfg;

 //https://leetcode.com/problems/find-the-town-judge/submissions/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

// kinda based on celebrity problem

public class FindTheTownJudge_997 {
    // Bad Solution -> not optimized
    public int findJudge1(int N, int[][] trust) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < trust.length; i++) {
            int key = trust[i][0];
            int val = trust[i][1];
            if (map.containsKey(key)) {
                map.get(key).add(val);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(val);
                map.put(key, list);
            }
        }

        Stack<Integer> st = new Stack<>();
        for (int i = 1; i <= N; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int c1 = st.pop();
            int c2 = st.pop();
            if (map.containsKey(c1)) {
                // c1 cannot be a judge
                st.push(c2);
            } else {
                st.push(c1);
            }
        }

        int potentialCandidate = st.pop();

        int count = 0;
        for (int i : map.keySet()) {
            if (i == potentialCandidate) return -1;
            for (int j : map.get(i)) {
                if (j == potentialCandidate) count++;
            }
        }

        if (count != N - 1) {
            return -1;
        }

        return potentialCandidate;
    }

    public int findJudge2(int N, int[][] trust) {
        // edge case : if only 1 person is given, assume he's the judge.
            if(N == 1) return 1;

        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < trust.length; i++) {
            int key = trust[i][0];
            int val = trust[i][1];
            set.add(key);
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }

        for (int key : map.keySet()) {
            if (set.contains(key)) {
                continue;
            } else {
                if (map.get(key) == N - 1) return key;
            }
        }

        return -1;
    }
}
