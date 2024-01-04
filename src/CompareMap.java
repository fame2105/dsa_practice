import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CompareMap {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String alice = s.nextLine();
        String cross = s.nextLine();

        Map<Double, Integer> mapAlice = new HashMap<>();
        Map<Double, Integer> mapCross = new HashMap<>();

        String[] aliceArr = alice.split(",");
        for (String entry : aliceArr) {
            String[] value = entry.split("->");
            mapAlice.put(Double.valueOf(value[0].trim()), Integer.valueOf(value[1].trim()));
        }

        System.out.println(mapAlice);

        String[] crossArr = cross.split(",");
        for (String entry : aliceArr) {
            String[] value = entry.split("->");
            mapCross.put(Double.valueOf(value[0].trim()), Integer.valueOf(value[1].trim()));
        }
        System.out.println(mapCross);

        System.out.println(mapAlice.equals(mapCross));



    }
}
