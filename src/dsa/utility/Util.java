package dsa.utility;

import java.util.List;
import java.util.Scanner;

public class Util {
    public static void display(int[] arr, Boolean nextLine) {
        System.out.println();
        for (int value : arr)
            if (nextLine == Boolean.TRUE)
                System.out.println(value + "\t");
            else
                System.out.print(value + "\t");

        System.out.println();
    }

    public static <E> void display(E[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void display(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @param size -> takes input the size of the 1D array.
     * @return -> 1-D array of given size by asking user to provide input into it.
     */
    public static int[] takeInputAndReturnArray(Scanner scanner, int size) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = scanner.nextInt();
        }
        return a;
    }

    public static int getMaxElementInArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        return max;
    }

    public static int getMinxElementInArray(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i])
                min = arr[i];
        }
        return min;
    }

    public static <T> List<T> reverseList(List<T> list, int leftIndex, int rightIndex) {
        while (leftIndex < rightIndex) {
            T le = list.get(leftIndex);
            T re = list.get(rightIndex);

            list.remove(rightIndex);
            list.remove(leftIndex);

            list.add(leftIndex, re);
            list.add(rightIndex, le);

            leftIndex++;
            rightIndex--;
        }
        return list;
    }

}
