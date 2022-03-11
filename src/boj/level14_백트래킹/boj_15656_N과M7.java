package boj.level14_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N과 M (7)
 */
public class boj_15656_N과M7 {

    private static int[] arr, tempArr;
    private static int N, M;
    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N개의 자연수
        M = Integer.parseInt(st.nextToken()); // M개를 고름

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        tempArr = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {

        // Base condition
        if (depth == M) {
            for (int val : tempArr) {
                sb.append(val).append(" ");
            }
            sb.append(System.lineSeparator());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            tempArr[depth] = arr[i];

            dfs(depth + 1);
        }
    }
}
