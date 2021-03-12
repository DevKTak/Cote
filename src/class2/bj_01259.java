package class2;

import java.util.Arrays;
import java.util.Scanner;

public class bj_01259 {

    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            String N = sc.next();

            if (N.equals("0")) {
                break;
            }
            StringBuilder sb = new StringBuilder(N);

            if (N.equals(sb.reverse().toString())) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
