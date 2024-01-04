package design.lld.random;

public class __1_UsingRandomMethod {
    public static void main(String[] args) {

        // Generating Random numbers
        System.out.println("1st Random Number: " + Math.random());
        System.out.println("2nd Random Number: " + Math.random());
        System.out.println("3rd Random Number: " + Math.random());
        System.out.println("4th Random Number: " + Math.random());


        int min = 200;
        int max = 400;
        //Generate random double value from 200 to 400
        System.out.print("Random value of type double between "+min+" to "+max+ ": ");
        double a = Math.random()*(max-min+1)+min;
        System.out.println(a);

    }
}
