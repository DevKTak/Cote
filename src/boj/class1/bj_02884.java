package boj.class1;

import java.util.Scanner;

public class bj_02884 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int H = scanner.nextInt();
        int M = scanner.nextInt();

        if (M - 45 < 0 && H > 0) {
            M = 60 + M - 45;
            H--;
        } else if (M - 45 < 0 && H == 0) {
            M = 60 + M - 45;
            H = 23;
        } else if (M - 45 >= 0) {
            M = M - 45;
        }

        System.out.println(H + " " + M);
    }
}
