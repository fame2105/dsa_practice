package dsa.catalogueOrder.foundation.numbersystem;

public class AnyBaseSubtraction {

    /**
     * @param num1 : this should be the bigger number
     * @param num2 : this should be the smaller number
     * @param base : base of num1 and num2
     * @return num1 - num2
     */
    private static long anyBaseSubtraction(int num1, int num2, int base) {
        int borrow = 0;
        int resultantValue = 0;
        int pow = 0;

        while (num1 > 0) {
            int digit1 = num1 % 10;
            int digit2 = num2 % 10;

            num1 /= 10;
            num2 /= 10;

            int currentDigit = 0;
            digit1 += borrow;

            if (digit1 >= digit2) {
                currentDigit = digit1 - digit2;
                borrow = 0; // we haven't taken any borrow from the neighbouring number
            } else {
                currentDigit = digit1 + base - digit2;
                borrow = -1;
            }
            resultantValue += currentDigit * Math.pow(10, pow);
            pow++;
        }
        return resultantValue;
    }

    public static void main(String[] args) {
        System.out.println(anyBaseSubtraction(1212, 256, 8));
    }
}
