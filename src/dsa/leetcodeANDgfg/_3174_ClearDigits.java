package dsa.leetcodeANDgfg;

// Easy : Learn to use StringBuffer delete functions and how to compare digits in char
public class _3174_ClearDigits {
    public static void main(String[] args) {
        System.out.println(clearDigits("cb34"));
    }
    public static String clearDigits(String s) {
        StringBuffer sb = new StringBuffer(s);

        int i = 0;
        while(i < sb.length()) {
            char currentChar = sb.charAt(i);
            if(isDigit(currentChar)) {
                sb.delete(i-1, i+1);
                i--;
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    private static boolean isDigit(char c){
        return (c >= '0' && c <= '9');
    }
}
