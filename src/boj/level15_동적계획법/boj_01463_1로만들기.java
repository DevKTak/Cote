package boj.level15_동적계획법;

import java.util.Scanner;

/**
 * 1로 만들기
 */
public class boj_01463_1로만들기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(getCountMakeOne(N));
    }

    private static int getCountMakeOne(int N) {
        int[] dp = new int[N + 1]; // DP 테이블, 배열 index 까지 구하는 count 값(횟수)을 넣을 배열

        for (int i = 2; i <= N; i++) { // i 가 1 일때는 dp[1] return
            dp[i] = dp[i - 1] + 1; // Base 로 -1 을 깔고 나머지와 비교

            if (i % 2 == 0) {

                // i 가 10 이라고 치면 dp[9] + 1번 과 dp[5] + 1번 중 더 적게 걸리는것으로 결정
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        return dp[N];
    }
}
