package dsa.leetcodeANDgfg.Greedy;

// https://leetcode.com/problems/gas-station/    #Greedy
public class _134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // check if solution exists or not
        int totalFuel = 0;
        for(int g : gas) {
            totalFuel += g;
        }

        int totalCost = 0;
        for(int c : cost) {
            totalCost += c;
        }

        // if totalFuel that can be acquired during the traversal is less than total distance that needs to be travelled then we conclude that there is no
        // way that we can make one trip.
        if(totalFuel < totalCost) {
            return -1;
        }

        // we have determined that a path exists, now we need to find the starting station
        // we can start from a station where (gas[i] > cost[i])
        int currentFuel = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++) {
            currentFuel += gas[i] - cost[i];
            if(currentFuel < 0) {
                currentFuel = 0;
                start = i+1;
            }
        }

        return start;
    }
}
