package dsa.leetcodeANDgfg;

// 1108. Defanging an IP Address

import java.util.Scanner;

public class DefangingAnIPAddress_1108 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String ipAddr = s.next();

        System.out.println(defangIpAddr(ipAddr));
    }

    private static String defangIpAddr(String ipAddr) {
        return ipAddr.replaceAll("\\.", "[.]");
    }
}
