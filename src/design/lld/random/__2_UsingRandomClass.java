package design.lld.random;

import java.util.Random;

public class __2_UsingRandomClass {
    public static void main(String[] args) {
        Random random = new Random();

        // Generate random integers 0 to 49
        int rand1 = random.nextInt(50);
        System.out.println("Random Integer between 0 to 49 : " + rand1);

        // Generate Random doubles values
        double rand2 = random.nextDouble();
        System.out.println("Random double value : " + rand2);

        // Generate Random boolean value
        boolean rand3 = random.nextBoolean();
        System.out.println("Random boolean value : " + rand3);

        // Generate Random Long value
        long rand4 = random.nextLong();
        System.out.println("Random long value : " + rand4);

        // Generate Random doubles values
        double rand5 = random.nextFloat();
        System.out.println("Random float value : " + rand5);

        // Generate 10 Random Integers between 0 to 99
        System.out.print("10 Random Integers between 0 to 99 : ");
        random.ints(10l, 0, 100).forEach(r -> System.out.print(r + " "));
    }
}
