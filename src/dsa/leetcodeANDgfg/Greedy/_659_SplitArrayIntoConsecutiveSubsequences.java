package dsa.leetcodeANDgfg.Greedy;

import java.util.HashMap;

// https://www.youtube.com/watch?v=Ty8EZlxVNC8&ab_channel=CodingDecoded
public class _659_SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> availability = new HashMap<>();
        HashMap<Integer, Integer> vacancy = new HashMap<>();

        for(int num : nums)
            availability.put(num, availability.getOrDefault(num, 0) + 1);

        for(int num : nums) {
            if(availability.get(num) <= 0)
                continue;
            else if(vacancy.getOrDefault(num, 0) > 0) {
                availability.put(num, availability.getOrDefault(num, 0) - 1);
                vacancy.put(num, vacancy.getOrDefault(num, 0) - 1);

                vacancy.put(num + 1, vacancy.getOrDefault(num+1, 0) + 1); // openORincrease availability for num+1
            } else if(availability.getOrDefault(num,0) > 0 && availability.getOrDefault(num + 1, 0) > 0 && availability.getOrDefault(num + 2, 0) > 0){
                availability.put(num, availability.getOrDefault(num, 0) - 1);
                availability.put(num+1, availability.getOrDefault(num+1, 0) - 1);
                availability.put(num+2, availability.getOrDefault(num+2, 0) - 1);

                vacancy.put(num + 3, vacancy.getOrDefault(num+3, 0) + 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
