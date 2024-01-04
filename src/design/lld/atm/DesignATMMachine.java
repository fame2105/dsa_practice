package design.lld.atm;

// https://leetcode.com/problems/design-an-atm-machine/
public class DesignATMMachine {
    private int[] denominations = null;
    private long[] count = null;
    private long total = 0l;

    public DesignATMMachine() {
        this.denominations = new int[]{20, 50, 100, 200, 500};
        this.count = new long[]{0l, 0l, 0l, 0l, 0l};
        this.total = 0l;
    }

    public void deposit(int[] banknotesCount) {
        this.total = 0l;
        for(int i = 0; i < banknotesCount.length; i++) {
            int banknoteCount = banknotesCount[i];
            this.count[i] += banknoteCount;
            this.total += denominations[i] * this.count[i];
        }
    }

    public int[] withdraw(int amount) {
        if(amount > this.total) return new int[]{-1};

        int[] result = new int[]{0,0,0,0,0};
        for(int i = 4; i>=0; i--) {
            int denomination = this.denominations[i];
            long currentCount = this.count[i];

            // while(amount >= denomination && currentCount > 0) {
            //     amount -= denomination;
            //     currentCount -= 1;
            //     result[i] += 1;
            // }
            int countOfCurrentDenominationNeeded = (int)Math.min(currentCount, amount/denomination);
            result[i] = countOfCurrentDenominationNeeded;
            amount -= countOfCurrentDenominationNeeded * denomination;
        }

        if(amount == 0) {
            this.total -= amount;
            for(int i = 0; i < count.length; i++) {
                this.count[i] -= result[i];
            }
            return result;
        }

        return new int[]{-1};
    }
}
