package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _12WiggleSort_I {
    public void wiggleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (i % 2 == 0) { // even index
                if (arr[i] > arr[i + 1]) swap(arr, i, i + 1);
            } else { // odd index
                if (arr[i] < arr[i + 1]) swap(arr, i, i + 1);
            }
        }
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
