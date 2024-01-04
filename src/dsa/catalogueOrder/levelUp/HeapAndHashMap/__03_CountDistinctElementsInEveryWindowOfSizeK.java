package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class __03_CountDistinctElementsInEveryWindowOfSizeK {
    public static ArrayList<Integer> solution(int[] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>(); // frequency - map
        int j = 0;
        for(int i = 0; i <= arr.length - k; i++) {
            while(j-i+1 < k) {
                putValueInMap(map, arr[j]);
                j++;
            }

            if(j-i+1 == k) {
                putValueInMap(map, arr[j]);
                j++;
                ans.add(map.keySet().size());
                removeValueFromMap(map, arr[i]);
            }
        }

        return ans;
    }

    private static void putValueInMap(HashMap<Integer, Integer> map, int key) {
        if(map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }

    private static void removeValueFromMap(HashMap<Integer, Integer> map, int key) {
        // remove the element if its frequency is 1 otherwise reduce the frequency by 1
        if(map.containsKey(key)) {
            if(map.get(key) == 1) {
                map.remove(key);
            } else {
                map.put(key, map.get(key) - 1);
            }
        }
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        ArrayList<Integer> ans = solution(arr,k);
        for(int a : ans){
            System.out.print(a + " ");
        }
    }
}
