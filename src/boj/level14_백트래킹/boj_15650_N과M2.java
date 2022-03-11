package boj.level14_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N과 M (2)
 */
public class boj_15650_N과M2 {

    public static int N;
    public static int M;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        dfs(1, 0);
        System.out.print(sb);
    }

    private static void dfs(int ascNum, int depth) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append(System.lineSeparator());
            return;
        }

        for (int i = ascNum; i <= N; i++) {
            arr[depth] = i;

            dfs(i + 1, depth + 1);
        }
    }
}
