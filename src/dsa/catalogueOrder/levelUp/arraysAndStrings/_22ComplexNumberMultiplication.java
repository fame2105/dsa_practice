package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _22ComplexNumberMultiplication {

    public static String complexNumberMultiply(String num1, String num2) {
        Integer a1 = Integer.parseInt(num1.substring(0, num1.indexOf('+')));

        // we are extracting b1(imaginary part) only till string.length() -1 because, we do
        // not want to include the character 'i' in our substring, as i being in the substring cannot be parsed into an Integer.
        Integer b1 = Integer.parseInt(num1.substring(num1.indexOf('+') + 1, num1.length() - 1));

        Integer a2 = Integer.parseInt(num2.substring(0, num2.indexOf('+')));

        // we are extracting b2(imaginary part) only till string.length() -1 because, we do
        // not want to include the character 'i' in our substring, as i being in the substring cannot be parsed into an Integer.
        Integer b2 = Integer.parseInt(num2.substring(num2.indexOf('+') + 1, num2.length() - 1));

        int a = (a1 * a2) - (b1 * b2);
        int b = (a1 * b2) + (a2 * b1);
        return a + "+" + b + "i";
    }
}
