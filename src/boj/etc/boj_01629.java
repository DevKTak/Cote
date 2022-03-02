package boj.etc;

import java.util.Scanner;

/**
 *  곱셈
 *  메모리 초과
 */
public class boj_01629 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(recursion(A, B, C, 1));
    }

    private static int recursion(int a, int b, int c, int result) {

        // Base condition
        if (b == 1) {
            return result;
        }

        return recursion(a, b - 1, c, result * a % c);
    }
}
