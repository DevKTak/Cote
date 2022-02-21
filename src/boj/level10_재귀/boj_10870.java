package boj.level10_재귀;

import java.util.Scanner;

/**
 * 피보나치 수 5
 */
public class boj_10870 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(fibonacci(sc.nextInt()));
    }

    private static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
