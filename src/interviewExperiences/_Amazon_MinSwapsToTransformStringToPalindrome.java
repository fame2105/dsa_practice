package interviewExperiences;

// https://www.youtube.com/watch?v=h5a0E0OJEAk&list=PLz0XdQ5pUFHpv58qGQAphmqz2UGeZgqaK&index=5
public class _Amazon_MinSwapsToTransformStringToPalindrome {
    public int minMovesToMakePalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        int count = 0;
        char[] sr = s.toCharArray();

        while(left < right) {
            int l = left;
            int r = right;

            while(l < r && sr[l] != sr[r]) r--;

            if(l == r) {
                swap(sr, r, r+1);
                count++;
                continue;
            }

            while(r < right) {
                swap(sr, r, r+1);
                r++;
                count++;
            }


            left++;
            right--;
        }

        return count;
    }

    private void swap(char[] sr, int left, int right) {
        char temp = sr[left];
        sr[left] = sr[right];
        sr[right] = temp;
    }
}
