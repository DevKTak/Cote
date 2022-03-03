package boj.level14_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/**
 * N과 M (10)
 */
public class boj_15664 {

    private static int N, M;
    private static int[] arr, tempArr;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();
    private static LinkedHashSet<String> lhs = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        tempArr = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());


        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0, 0);

        for (String s : lhs) {
            System.out.println(s);
        }
    }

    private static void dfs(int depth, int asc) {

        // Base condition
        if (depth == M) {
            sb = new StringBuilder();

            for (int val : tempArr) {
                sb.append(val).append(" ");
            }
            lhs.add(sb.toString());
            return;
        }

        for (int i = asc; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tempArr[depth] = arr[i];

                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
