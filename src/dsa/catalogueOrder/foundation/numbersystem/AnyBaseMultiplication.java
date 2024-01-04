package dsa.catalogueOrder.foundation.numbersystem;

public class AnyBaseMultiplication {

    private static int anyBaseMultiplication(int num1, int num2, int base) {
        int counter = 0;
        int sum = 0;
        while(num2 > 0) {
            int d = num2 % 10;
            int mult = getProductWithSingleDigit(num1, base, d);
            sum = anyBaseAddition(sum, mult * (int)Math.pow(10, counter), base);
            counter++;
            num2 /= 10;
        }
        return sum;
    }

    private static int getProductWithSingleDigit(int num1, int base, int mulDigit) {
        int resultantValue = 0;
        int carry = 0;
        int pow = 0;
        while (num1 > 0 || carry > 0) {
            int digit = num1 % 10;
            num1 /= 10;

            int currentDigit = (digit * mulDigit) + carry;

            carry = currentDigit / base;

            resultantValue += ((currentDigit % base) * (int)Math.pow(10, pow));

            pow++;
        }
        return resultantValue;
    }

    private static int anyBaseAddition(int num1, int num2, int base) {
        int carry = 0;
        int sum = 0;
        int pow = 0;

        while (num1 > 0 || num2 > 0 || carry > 0) {
            int digit1 = num1 % 10;
            int digit2 = num2 % 10;

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

    public static void main(String[] args) {
        System.out.println(anyBaseMultiplication(1220, 31, 5));
    }
}
