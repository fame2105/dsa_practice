package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _13ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            char leftChar = s.charAt(left);
            if(!isVowel(leftChar)) {
                left++;
                continue;
            }

            char rightChar = s.charAt(right);
            if(!isVowel(rightChar)) {
                right--;
                continue;
            }

            swap(arr, left, right);
            left++;
            right--;
        }

        return String.valueOf(arr);
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;

        return false;
    }

    private void swap(char[] arr, int leftIdx, int rightIdx) {
        char temp = arr[leftIdx];
        arr[leftIdx] = arr[rightIdx];
        arr[rightIdx] = temp;
    }
}
