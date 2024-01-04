package dsa.random.sliding_window;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeIntegerInEveryWindowOfSizeK {
    public static void main(String[] args) {
        long[] a = {2, 3, -1, 3, -90, 2, -1, 5, 4, 1};
        int k = 3;
//        long[] result = printFirstNegativeInteger(a, k);
        long[] result = printFirstNegativeIntegerApproach02(a, k);
        for (long num : result) {
            System.out.print(num + " ");
        }
    }

    public static long[] printFirstNegativeInteger(long A[], int K) {
        Queue<Integer> q = new LinkedList<>();
        int resultIdx = 0;
        long[] list = new long[A.length - K + 1];
        int j = 0;
        for (int i = 0; i <= A.length - K; i++) {
            while (j < A.length && j - i + 1 <= K) {
                if (A[j] < 0) {
                    q.add(j);
                }
                if (j - i + 1 == K) {
                    if (!q.isEmpty()) {
                        list[resultIdx] = A[q.peek()];
                    } else {
                        list[resultIdx] = 0l;
                    }
                    resultIdx++;
                }
                j++;
            }

            // Remove element from Queue if window does not contains the queued element
            if (!q.isEmpty() && q.peek() == i) {
                q.remove();
            }
        }

        return list;
    }

    public static long[] printFirstNegativeIntegerApproach02(long A[], int K) {
        Queue<Integer> q = new LinkedList<>();
        int resultIdx = 0;
        long[] list = new long[A.length - K + 1];
        int j = 0;
        for (int i = 0; i < A.length; i++) {

            // if (j - i + 1 < windowSize) then keep recording the effect of jth element(from window start to one less than window right boundary) and increment j
            while (j < A.length && j - i + 1 < K) {
                if (A[j] < 0) {
                    q.add(j);
                }

                j++;
            }

            /*if (j - i + 1 == windowSize) then record the effect of jth element(window right boundary element) and compare and form answer,
            remove/reset the effect of ith(first element in this window) and increment j*/
            if (j < A.length && j - i + 1 == K) {
                if (A[j] < 0) {
                    q.add(j);
                }

                if (!q.isEmpty()) {
                    list[resultIdx] = A[q.peek()];
                } else {
                    list[resultIdx] = 0l;
                }
                resultIdx++;

                // Remove element from Queue if window does not contains the queued element
                if (!q.isEmpty() && q.peek() == i) {
                    q.remove();
                }

                j++;
            }
        }

        return list;
    }
}
