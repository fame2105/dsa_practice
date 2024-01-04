package dsa.catalogueOrder.levelUp.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class FruitsInBasket {
    public static void main(String[] args) {
        int[] fruits1 = new int[] {1, 2, 1, 3, 2, 2, 3};
        int[] fruits2 = new int[] {3,3,3,1,2,1,1,2,3,3,4};
        int[] fruits3 = new int[] {0};
        int[] fruits4 = new int[] {1,2,1};
        System.out.println(totalFruit(fruits1));
        System.out.println("----------------------------");
        System.out.println(totalFruit(fruits2));
        System.out.println("----------------------------");
        System.out.println(totalFruit(fruits3));
        System.out.println("----------------------------");
        System.out.println(totalFruit(fruits4));
    }

    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> fmap = new HashMap<>();
        int capacity = 2;
        int count = 0;
        int maxFruitsInBasket = 0;
        int j = 0;
        for (int i = 0; i < fruits.length; i++) {
            while (j < fruits.length && fmap.size() <= capacity) {
                putInMap(fmap, fruits[j]);
                count++;

                if (fmap.size() <= capacity) {
                    maxFruitsInBasket = Math.max(maxFruitsInBasket, count);
                }

                j++;
            }

            if (fmap.size() >= capacity) {
                if(fmap.containsKey(fruits[i]) && fmap.get(fruits[i]) > 0) count--;
                removeFromMap(fmap, fruits[i]);
            }
        }
        return maxFruitsInBasket;
    }

    private static void putInMap(Map<Integer, Integer> map, int key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }

    private static void removeFromMap(Map<Integer, Integer> map, int key) {
        if (map.containsKey(key)) {
            if (map.get(key) > 1) {
                map.put(key, map.get(key) - 1);
            } else {
                map.remove(key);
            }
        }
    }
}
