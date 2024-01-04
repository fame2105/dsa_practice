package dsa.leetcodeANDgfg;

// https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition/
//Editorial : https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition/discuss/2358236/Explanation-of-O(logn)-with-proof-and-image-JavaC%2B%2BPython
public class _2358_MaxNumberOfGroupsEnteringCompetition {
    public int maximumGroups(int[] grades) {
        return (int) (Math.sqrt(grades.length * 8 + 1) - 1) / 2;
    }
}
