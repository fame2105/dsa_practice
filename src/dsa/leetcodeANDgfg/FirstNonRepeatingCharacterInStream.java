package dsa.leetcodeANDgfg;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1#
public class FirstNonRepeatingCharacterInStream {
    public String FirstNonRepeating(String s) {
        HashMap<Character, Integer> fmap = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder("");

        /**
         * 1. Add item in the HasMap while updating its frequency
         * 2. Add item in the queue
         * 3. Check that item at the peek of the queue is always of frequency = 1 in the hashMap... if not keep removing until we find the item in the queue with freq = 1
         * 4. Now, add the unique/non-repeating item from the queue to ans.
         *
         * (We always want to ensure that item at the peek of the queue is a non-repeating item)
         * which is why  Update frequency, then add in queue, then check the peek item is unique or not, keep removing till we find a unique item
         */

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            q.add(c);
            fmap.put(c, fmap.getOrDefault(c, 0) + 1);

            while(q.size() > 0) {
                if(fmap.get(q.peek()) > 1)
                    q.remove();
                else
                    break;
            }

            if(q.size() > 0) ans.append(q.peek());
            else ans.append('#');
        }

        return ans.toString();
    }
}
