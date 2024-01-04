package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class PrintAllSubArraysSum_Exercise {
    public static void main(String[] args) {
        int[] input1 = new int[]{1,2,3};
        printAllSubArraySum(input1);

        System.out.println("--------------------------------------------------");

        int[] input2 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        printAllSubArraySum(input2);
    }

    // Better way to do this is kadane's algorithm
    public static void printAllSubArraySum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                System.out.print("[");
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    System.out.print(arr[k] + " ");
                }
                System.out.print("] sum -> " + sum);
                maxSum = Math.max(maxSum, sum);
                sum = 0;
                System.out.println();
            }
        }
        System.out.println("Max Sum -> : " + maxSum);
    }
}
