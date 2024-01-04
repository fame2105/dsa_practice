package dsa.catalogueOrder.levelUp.HeapAndHashMap;

public class MaxConsecutiveOnes_II {

    public static int solution(int[] arr, int k){
        int count = 0;
        int ans = 0;
        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            while(j < arr.length && count <= k) {
                int num = arr[j++];
                if(num == 0) count++;
                if(count <= k) {
                    ans = Math.max(ans, j-i);
                }
            }

            if(i < j && count > k) {
                int num = arr[i];
                if(num == 0) count--;
            }
        }

        return ans;
    }
}
