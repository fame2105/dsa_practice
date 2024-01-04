package dsa.catalogueOrder.levelUp.recursionAndBacktracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class PermuteWordsI {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        String s = "aabb";
        HashMap<Character, Integer> fmap = new HashMap<>();
        for(char ch: s.toCharArray()){
            if(fmap.containsKey(ch)){
                fmap.put(ch, fmap.get(ch) + 1);
            } else {
                fmap.put(ch, 1);
            }
        }
        permutationWords(1, s.length(), fmap, "");
    }

    // cs -> currentSelection
    // ts -> totalSelection
    // asf -> answerSoFar
    private static void permutationWords(int cs, int ts, Map<Character, Integer> fmap, String asf) {
        if (cs > ts) {
            System.out.println(asf);
            return;
        }

        for (Character ch : fmap.keySet()) {
            if (fmap.get(ch) > 0) {
                int oldFreq = fmap.get(ch);
                fmap.put(ch, oldFreq - 1);
                permutationWords(cs + 1, ts, fmap, asf + ch);
                fmap.put(ch, oldFreq);
            }
        }
    }
}
