package dsa.catalogueOrder;


public class RotateNumber {


    public static void main(String[] args) throws Exception {

    }

    private static void add(int m1, Integer m2) {
        System.out.println(m1 + m2);
    }

    private static void add(Integer m1, int m2) {
        System.out.println(m1 + m2);
    }

    public static void printEncodings(String str, String ans) {
        if (str.isEmpty()) {
            System.out.println(ans);
            return;
        }

        int oneCharCode = str.charAt(0) - '0';
        if (oneCharCode == 0) {
            return;
        }
        char encoding1 = (char) (oneCharCode + 'a' - 1);
        String ros1 = str.substring(1);
        printEncodings(ros1, ans + encoding1);

        if (str.length() >= 2) {
            int secondCharacterCode = str.charAt(1) - '0';
            int twoCharacterCode = oneCharCode * 10 + secondCharacterCode;
            if (twoCharacterCode <= 26) {
                char encoding2 = (char) (twoCharacterCode + 'a' - 1);
                String ros2 = str.substring(2);
                printEncodings(ros2, ans + encoding2);
            }
        }
    }
}
