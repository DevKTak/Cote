package boj.level14_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/**
 * N과 M (9)
 */
public class boj_15663_N과M9 {

    private static int[] arr, tempArr;
    private static boolean[] visited;
    private static int N, M;
    private static StringBuilder sb = new StringBuilder();
    private static LinkedHashSet<String> lhs = new LinkedHashSet<>(); // 삽입된 순서대로 중복 X


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N개의 자연수
        M = Integer.parseInt(st.nextToken()); // M개를 고름

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        tempArr = new int[M];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);

        for (String s : lhs) {
            System.out.println(s);
        }
    }

    private static void dfs(int depth) {

        // Base condition
        if (depth == M) {
            sb = new StringBuilder();

            for (int val : tempArr) {
                sb.append(val).append(" ");
            }
            lhs.add(sb.toString());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tempArr[depth] = arr[i];

                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
