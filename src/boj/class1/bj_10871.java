package boj.class1;

import java.util.Scanner;

public class bj_10871 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        int X = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            int A = scanner.nextInt();

            if (A < X) {
                System.out.print(A + " ");
            }
        }
    }
}
