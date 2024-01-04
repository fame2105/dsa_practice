package dsa.catalogueOrder.foundation.HashMapAndHeap;

import java.util.HashMap;
import java.util.Map;

public class HashMapQuestions {

    public static void main(String[] args) {
        driver();
    }

    private static void driver() {
        String str = "zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc";
        printHighestFrequencyCharacter(str);
    }

    private static void printHighestFrequencyCharacter(String str) {
        Map<Character, Integer> map = new HashMap<>();

        // create frequency map
        for(char c : str.toCharArray()) {
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        char maxFreqCharacter = 'a';
        int maxFrq = 0;
        for(Character key : map.keySet()) {
            if(map.get(key) > maxFrq) {
                maxFrq = map.get(key);
                maxFreqCharacter = key;
            }
        }

        System.out.println(maxFreqCharacter);
    }

    private static void printCommonElements(int[] a1, int[] a2) {
        Map<Integer, Integer> map = new HashMap<>();
        // add all elements from array1 in map uniquely
        for(int item : a1)  // we don't need frequency of each element from a1
            map.put(item, 1);


        for(int item : a2) {
            if(map.containsKey(item)) {
                System.out.println(item);
                map.remove(item);
            }
        }
    }

    private static void printCommonElement_II(Integer[] a1, Integer[] a2) {
        Map<Integer, Integer> map = new HashMap<>();
        // create frequency map
        for(int item : a1) {
            if(map.containsKey(item))
                map.put(item, map.get(item) + 1);
            else
                map.put(item, 1);
        }

        for(int item : a2) {
            if(map.containsKey(item) && map.get(item) > 0) {
                System.out.println(item);
                map.put(item, map.get(item)-1);
            }
        }
    }

    // we need to figure out the length and starting points of each sequqnce
    private static void printLongestConsecutiveSequence(int[] arr) {
        // 1. add all elements into hashmap
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int item : arr)
            map.put(item, true);

        // mark all the elements that are not the starting points as false
        for(int key : arr) {
            if(map.containsKey(key-1))
                map.put(key, false);
        }

        // Get Length and starting points
        int maxLength = 0;
        int starting = 0;
        for (int key : arr) {
            if (map.get(key)) {
                // this key is starting point of a sequence
                int len = 1;
                int st = key;
                while(map.containsKey(key + 1) == true) {
                    len++;
                    key++;
                }
                if(maxLength < len) {
                    maxLength = len;
                    starting = st;
                }
            }
        }

        for(int i = 1; i <= maxLength; i++) {
            System.out.println(starting);
            starting++;
        }
    }
}
