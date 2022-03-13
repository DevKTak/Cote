package boj.level14_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N과 M (1)
 */

public class boj_15649_N과M1 {

    public static int N;
    public static int M;
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 1 ~ N까지 자연수 중
        M = Integer.parseInt(st.nextToken()); // M개를 고른다

        arr = new int[M];
        visit = new boolean[N];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        // 출력
        if (depth == M) {
            for (int v : arr) {
                sb.append(v).append(" ");
            }
            sb.append(System.lineSeparator());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) { // 방문한 적이 없으면(노드 중복방지)
                visit[i] = true; //  방문처리
                arr[depth] = i + 1;

                dfs(depth + 1);

                // 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
                visit[i] = false;
            }
        }
    }
}
