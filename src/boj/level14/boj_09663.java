package boj.level14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N-Queen
 */
public class boj_09663 {

    public static int[] arr;
    public static int N;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    public static void nQueen(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
         
            if (isPossibility(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    public static boolean isPossibility(int col) {
        for (int i = 0; i < col; i++) {

            // 컬럼의 위치가 수평 || 대각선(열의 차와 행의 차와 같을 경우는 대각선에 놓여있는 경우!)
            if ((arr[col] == arr[i])
                    || (Math.abs(i - col) == Math.abs(arr[i] - arr[col]))) {
                return false;
            }
        }

       return true;
    }
}
