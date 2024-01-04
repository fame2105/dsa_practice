package dsa.leetcodeANDgfg.Greedy;

//https://leetcode.com/problems/minimum-time-to-make-rope-colorful/   #Greedy
public class _1578_MinTimeToMakeRopeColorful {

    /**
     * If there are X consecutive balloons then we will have to remove X-1 balloons in order to make the rope
     * colorful and check further.
     * If SumOfCost of X balloons = Y then we would want to remove the X-1 ballons that have the least cost
     * Therefore always maintain a MaxCostInGroup along with SumOfCostOfSameColorBalloonsInGroup
     * For calculating cost of removing X-1 baloons do :
     * (SumOfCostOfSameColorBalloonsInGroup - MaxCostInGroup) .... this means we have excluded X-1 consecutive balloons of same Color while not removing the balloon of the highest cost.
     */

    public int minCost(String colors, int[] neededTime) {
        int minCost = 0;
        int groupCost = 0; // sum of cost of consecutive balloons that are of same color
        int maxInGroup = 0; // max cost of the balloon in the group of same color balloon

        for(int i = 0; i < colors.length(); i++) {

            // make answer for previous set of same color balloons, when two consecutive balloons are of different color and reinitialize groupCost and maxInGroup for the next group.
            if(i > 0 && colors.charAt(i) != colors.charAt(i-1)) {
                minCost += groupCost - maxInGroup;
                groupCost = 0;
                maxInGroup = 0;
            }

            groupCost += neededTime[i];
            maxInGroup = Math.max(maxInGroup, neededTime[i]);
        }

        // In case there are consecutive baloons towards the end of the array of the colors/rope then we
        // won't be able to calculate the cost for the last group, therefore calculate here
        // this will be 0 if there aren't any consecutive baloons of same color in the lastOdx of the array
        minCost += groupCost - maxInGroup;

        return minCost;
    }
}
