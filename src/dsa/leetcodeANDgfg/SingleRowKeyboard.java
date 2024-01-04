package dsa.leetcodeANDgfg;

//1165. Single-Row Keyboard

/**
 * There is a special keyboard with all keys in a single row.
 * <p>
 * Given a string keyboard of length 26 indicating the layout of the keyboard (indexed from 0 to 25), initially your finger is at index 0. To type a character, you have to move your finger to the index of the desired character. The time taken to move your finger from index i to index j is |i - j|.
 * <p>
 * You want to type a string word. Write a function to calculate how much time it takes to type it with one finger.
 * <p>
 * Input: keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
 * Output: 4
 * Explanation: The index moves from 0 to 2 to write 'c' then to 1 to write 'b' then to 0 again to write 'a'.
 * Total time = 2 + 1 + 1 = 4.
 * <p>
 * Input: keyboard = "pqrstuvwxyzabcdefghijklmno", word = "dsa.leetcode"
 * Output: 73
 * <p>
 * Constraints:
 * <p>
 * keyboard.length == 26
 * keyboard contains each English lowercase letter exactly once in some order.
 * 1 <= word.length <= 10^4
 * word[i] is an English lowercase letter.
 */
public class SingleRowKeyboard {
    public static void main(String[] args) {
        String word1 = "cba"; // output = 4
        String keyboard1 = "abcdefghijklmnopqrstuvwxyz";

        String word2 = "dsa/leetcodeANDgfg"; // output = 73
        String keyboard2 = "pqrstuvwxyzabcdefghijklmno";
    }

    public int calculateTime(String keyboard, String word) {
        char[] charKeyboard = keyboard.toCharArray();
        int[] countChars = new int[keyboard.length()];
        for (int i = 0; i < 26; i++) {
            countChars[charKeyboard[i] - 'a'] = i;
        }

        return 0;
    }
}
