package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _08MaxProductOfThreeNums {
    public static int maximumProduct(int[] arr) {
        int firstMax = Integer.MIN_VALUE; // biggest
        int secondMax = Integer.MIN_VALUE; // 2nd max (just smaller than the max element in arr)
        int thirdMax = Integer.MIN_VALUE; // 3rd max (just smaller than the secondMax element in arr)

        int firstMin = Integer.MAX_VALUE; // smallest
        int secondMin = Integer.MAX_VALUE; // 2nd smallest (just bigger than smallest)

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = arr[i];
            } else if (arr[i] > secondMax) {
                thirdMax = secondMax;
                secondMax = arr[i];
            } else if (arr[i] > thirdMax) {
                thirdMax = arr[i];
            }

            if (arr[i] < firstMin) {
                secondMin = firstMin;
                firstMin = arr[i];
            } else if (arr[i] < secondMin) {
                secondMin = arr[i];
            }
        }

        return Math.max(firstMax * secondMax * thirdMax, firstMin * secondMin * firstMax);
    }
}
