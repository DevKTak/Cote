package boj.class2;

import java.util.Scanner;

public class bj_10250 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int H = scanner.nextInt();
            int W = scanner.nextInt();
            int N = scanner.nextInt();

            if (N % H == 0) {
                System.out.println(H * 100 + N / H);
            } else {
                System.out.println(N % H * 100 + N / H + 1);
            }
        }
    }
}
