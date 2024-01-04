package dsa.catalogueOrder.levelUp.HeapAndHashMap;

public class MaxConsecutiveOnes_I {

    public static int solution(int[] arr){
        int count = 0;
        int ans = 0;
        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            while(j < arr.length && count <= 1) {
                int num = arr[j++];
                if(num == 0) count++;
                if(count <= 1) {
                    ans = Math.max(ans, j-i);
                }
            }

            if(i < j && count > 1) {
                int num = arr[i];
                if(num == 0) count--;
            }
        }

        return ans;
    }
}
