package boj.level10_재귀;

import java.util.Scanner;

/**
 * 하노이 탑 이동 순서
 */
public class boj_11729 {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        sb.append((int) Math.pow(2, N) - 1).append(System.lineSeparator());

        hanoi(N, 1, 2, 3);
        System.out.println(sb);
    }

    private static void hanoi(int n, int from, int mid, int to) {

        // Base condition
        if (n == 1) {
            sb.append(from).append(" ").append(to).append(System.lineSeparator());
            return;
        }

        hanoi(n - 1, from, to, mid);
        sb.append(from).append(" ").append(to).append(System.lineSeparator());

        hanoi(n - 1, mid, from, to);
    }
}
