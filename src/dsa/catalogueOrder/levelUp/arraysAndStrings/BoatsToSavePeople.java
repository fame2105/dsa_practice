package dsa.catalogueOrder.levelUp.arraysAndStrings;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;

        int boats = 0;
        while (left <= right) {
            int sum = people[left] + people[right];

            if (sum <= limit) {
                left++;
                right--;
            } else {
                right--;
            }

            boats++;
        }

        return boats;
    }
}
