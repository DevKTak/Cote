package boj.level15_동적계획법;

import java.math.BigInteger;
import java.util.Scanner;

public class boj_04150_피보나치수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(fibo(sc.nextInt()));
    }

    private static BigInteger fibo(int num) {
        BigInteger[] dp = new BigInteger[num + 1];
        dp[0] = BigInteger.ZERO;

        if (num >= 1) {
            dp[1] = BigInteger.ONE;
        }

        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i - 2].add(dp[i - 1]);
        }

        return dp[num];
    }
}
