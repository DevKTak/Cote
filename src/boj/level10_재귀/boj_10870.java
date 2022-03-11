package boj.level10_재귀;

import java.util.Scanner;

/**
 * 피보나치 수 5
 */
public class boj_10870 {

    private static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new int[N + 1];

        System.out.println(fibonacci(N));
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else if (dp[n] != 0) {
            return dp[n]; // 메모이제이션 DP 테이블 값 바로 리턴
        } else {
            return dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
