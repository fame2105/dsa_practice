package dsa.leetcodeANDgfg;

import java.util.HashMap;
import java.util.PriorityQueue;

public class _2353_DesignFoodRatingSystem {
    private class Food implements Comparable<Food>{
        String name;
        String cuisine;
        int rating;
        Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }

        public int compareTo(Food o) {
            int diff = o.rating - this.rating;
            if(diff == 0) {
                return this.name.compareTo(o.name); // str1.compareTo(str2) returns lexicographically smaller string among str1 and str2
            } else {
                return diff;
            }
        }
    }

    // helps in getting highestRated food for a cuisine name
    // key:cuisine and value = PriorityQueue{FoodObjects belonging to this cuisine}
    HashMap<String, PriorityQueue<Food>> hrm = new HashMap<>();

    // We need to maintain this map in order to get FoodObject for it foodName.... this helps in changing the rating of existing food objects
    // foodName : Food Object
    HashMap<String, Food> cr = new HashMap<>();

    public _2353_DesignFoodRatingSystem(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0; i < foods.length; i++) {
            String name = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];
            if(hrm.containsKey(cuisine) == false) {
                PriorityQueue<Food> pq = new PriorityQueue<>();
                Food food = new Food(name, cuisine, rating);
                pq.add(food);
                hrm.put(cuisine, pq);
                cr.put(name, food);
            } else {
                PriorityQueue<Food> pq = hrm.get(cuisine);
                Food food = new Food(name, cuisine, rating);
                pq.add(food);
                hrm.put(cuisine, pq);
                cr.put(name, food);
            }
        }
    }

    public void changeRating(String food, int newRating) { // make sure to modify the rating of the already added object, do not create a new FoodObject
        Food obj = cr.get(food); // get FoodObject for foodName
        PriorityQueue<Food> pq = hrm.get(obj.cuisine); // using cuisineName from this FoodObject we can remove this object from the relevant queue
        pq.remove(obj); // remove the Food object from ProrityQueue
        obj.rating = newRating; // modify the rating of this food object with newRating
        pq.add(obj); // add this modified Food object in the queue again
        hrm.put(obj.cuisine, pq);
    }

    public String highestRated(String cuisine) {
        return hrm.get(cuisine).peek().name;
    }
}
