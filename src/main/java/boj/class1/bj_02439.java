package boj.class1;

import java.util.Scanner;

public class bj_02439 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }

            for (int k = n - i; k < n; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}