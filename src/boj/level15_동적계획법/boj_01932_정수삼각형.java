package boj.level15_동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 정수 삼각형
 */
public class boj_01932_정수삼각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(getSum(arr, n));
    }

    private static int getSum(int[][] arr, int n) {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[i][j] >= arr[i][j + 1]) {
                    arr[i - 1][j] += arr[i][j];
                } else {
                    arr[i - 1][j] += arr[i][j + 1];
                }
            }
        }

        return arr[0][0];
    }
}
