package boj.level10_재귀;

import java.util.Scanner;

/**
 * 팩토리얼
 */
public class boj_10872 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(factorial(sc.nextInt()));
    }

    private static int factorial(int N) {
        if (N == 0) return 1;

        return N * factorial(N - 1);
    }
}
