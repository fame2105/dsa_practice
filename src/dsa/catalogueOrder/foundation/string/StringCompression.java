package dsa.catalogueOrder.foundation.string;

public class StringCompression {
    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        String input = s.next();
//
//        System.out.println(compression1(input));
//        System.out.println(compression2(input));

        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(chars));
    }

    public static String compression1(String str) {

        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < str.length() - 1; i++) {
            char current = str.charAt(i);
            char next = str.charAt(i + 1);
            if (current != next) {
                sb.append(current);
            }
        }
        sb.append(str.charAt(str.length() - 1));
        return sb.toString();
    }

    public static String compression2(String str) {
        int counter = 1;
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < str.length() - 1; i++) {
            char current = str.charAt(i);
            char next = str.charAt(i + 1);
            if (current != next) {
                sb.append(current);
                if (counter != 1) {
                    sb.append(counter);
                }
                counter = 1;
            } else {
                counter++;
            }
        }

        sb.append(str.charAt(str.length() - 1));
        if (counter != 1) {
            sb.append(counter);
        }

        return sb.toString();
    }

    // 443 : https://leetcode.com/problems/string-compression/
    public static int compress(char[] chars) {
        int count = 1;
        int idx = 0;
        for(int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            while(i + 1 < chars.length && chars[i+1] == currentChar) {
                i++;
                count++;
            }

            if(count > 1) {
                chars[idx++] = currentChar;
                for(char c : String.valueOf(count).toCharArray()) {
                    chars[idx++] = c;
                }
                count = 1;
                // i++:
            } else {
                chars[idx++] = currentChar;
            }
        }
        return chars.length;
    }
}
