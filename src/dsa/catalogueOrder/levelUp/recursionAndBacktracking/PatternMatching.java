package dsa.catalogueOrder.levelUp.recursionAndBacktracking;

import java.util.HashMap;
import java.util.HashSet;

public class PatternMatching {
    public static void solution(String str, String pattern, HashMap<Character,String> map, String op){
        if(pattern.length() == 0) {
            if(str.length() == 0){
                HashSet<Character> set = new HashSet<>();
                for(int i = 0; i < op.length(); i++) {
                    char ch = op.charAt(i);
                    if(!set.contains(ch)) {
                        System.out.print(ch + "->" + map.get(ch) + ", ");
                        set.add(ch);
                    }
                }
            }
            return;
        }

        char ch = pattern.charAt(0);
        String remainingPattern = pattern.substring(1);
        if(map.containsKey(ch)) {
            String prevMapping = map.get(ch);
            if(str.length() >= prevMapping.length()) {
                String pref = str.substring(0, prevMapping.length());
                String ros = str.substring(prevMapping.length());
                if(pref.equals(prevMapping)) {
                    solution(ros, remainingPattern, map, op);
                }
            }
        } else {
            for(int i = 0; i < str.length(); i++) {
                String prefix = str.substring(0, i+1);
                String ros = str.substring(i+1);
                map.put(ch, prefix);
                solution(ros, remainingPattern, map, op);
                map.remove(ch);
            }
        }
    }
    public static void main(String[] args) {
        String str = "graphtreesgraph";
        String pattern = "pep";
        HashMap<Character,String> map = new HashMap<>();
        solution(str,pattern,map,pattern);
    }
}
