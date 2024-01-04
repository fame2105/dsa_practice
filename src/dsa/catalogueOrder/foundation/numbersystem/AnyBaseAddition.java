package dsa.catalogueOrder.foundation.numbersystem;

public class AnyBaseAddition {

    private static long anyBaseAddition(int num1, int num2, int base) {
        int carry = 0;
        int sum = 0;
        int pow = 0;

        while (num1 > 0 || num2 > 0 || carry > 0) {
            int digit1 = num1 == 0 ? 0 :num1 % 10;
            int digit2 = num2 == 0 ? 0 : num2 % 10;

            num1 /= 10;
            num2 /= 10;

            int currentDigit = digit1 + digit2 + carry;

            carry = currentDigit / base;
            currentDigit = currentDigit % base;
            sum += currentDigit * Math.pow(10, pow);
            pow++;
        }
        return sum;
    }

    private static String anyBaseAddition(String a, String b, int base) {
        String result = "";
        int carry = 0;
        int i = a.length() - 1; // idx iterator for String a
        int j = b.length() - 1; // idx iterator for String b

        while(i >= 0 || j >= 0 || carry != 0) {
            int num1 = (i >= 0) ? a.charAt(i) - 48 : 0;
            int num2 = (j >= 0) ? a.charAt(j) - 48 : 0;

            i--;
            j--;

            int sum = num1 + num2 + carry;

            carry = sum / base;
            result = (sum % base) + result;
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(anyBaseAddition(67, 3903, 10));
        System.out.println(anyBaseAddition("0", "1", 2));

    }
}
