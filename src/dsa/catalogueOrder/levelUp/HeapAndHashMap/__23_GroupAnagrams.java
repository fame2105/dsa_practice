package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class __23_GroupAnagrams {
    public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> bigMap = new HashMap<>();
        for (String str : strs) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            ArrayList<String> list = bigMap.getOrDefault(map, new ArrayList<>());
            list.add(str);

            bigMap.put(map, list);
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for (ArrayList<String> list : bigMap.values()){
            ans.add(list);
        }

        return ans;
    }
}
