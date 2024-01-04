import java.util.Scanner;

public class CLockShift {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int gh = s.nextInt();
        int gm = s.nextInt();

        int rh = s.nextInt();
        int rm = s.nextInt();

        int hShift = Math.min(Math.abs(rh - gh), Math.min(Math.abs(rh + (24 - gh)), Math.abs(gh + 24 - rh)));
        int rShift = Math.min(Math.abs(rm - gm), Math.min(Math.abs(rm + (60 - gm)), Math.abs(gm + 60 - rm)));

        System.out.println(hShift + rShift);
    }
}
