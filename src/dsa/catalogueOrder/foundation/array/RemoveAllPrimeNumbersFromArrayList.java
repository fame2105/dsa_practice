package dsa.catalogueOrder.foundation.array;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveAllPrimeNumbersFromArrayList {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(s.nextInt());
        }

        System.out.println(removeAllPrimeNumbersFromArrayList(list));
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static ArrayList<Integer> removeAllPrimeNumbersFromArrayList(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (isPrime(list.get(i))) {
                list.remove(i);
            }
        }
        return list;
    }
}
