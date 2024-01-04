package dsa.dpMasterCourseUdemy;


import java.util.Scanner;

//https://www.codechef.com/ZCOPRAC/submit/ZCO14002
// fame2105/para
public class SUPW {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] work = new int[N];
        for(int i = 0; i < N; i++) {
            work[i] = s.nextInt();
        }

        System.out.println(minWorkTime(work));
    }

    private static int minWorkTime(int[] work) {
        if(work.length == 1) return work[0];
        else if( work.length == 2) return Math.min(work[0], work[1]);
        else if(work.length == 3) return Math.min(work[0], Math.min(work[1], work[2]));

        int[] minWork = new int[work.length];

        for(int i = 0; i < work.length; i++) {
            if(i == 0 || i == 1 || i == 2) {
                minWork[i] = work[i];
            } else {
                minWork[i] = Math.min(minWork[i-1], Math.min(minWork[i-2], minWork[i-3])) + work[i];
            }
        }

        int i = minWork.length - 1;
        return Math.min(minWork[i], Math.min(minWork[i-1], minWork[i-2]));
    }
}
