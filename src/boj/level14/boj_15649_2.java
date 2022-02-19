package boj.level14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N과 M (1)
 */
public class boj_15649_2 {

    public static int N;
    public static int M;
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 1 ~ N 까지 자연수 중
        M = Integer.parseInt(st.nextToken()); // M 개를 고른다

        arr = new int[M]; // 한 줄씩 찍을 임시 저장 배열
        visit = new boolean[N]; // 노드 방문 체크

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int v : arr) {
                sb.append(v).append(" ");
            }
            sb.append(System.lineSeparator());
            return;
        }


        for (int i = 0; i < N; i++) {
            if (!visit[i]) { // 방문 한적이 없는 경우
                visit[i] = true;
                arr[depth] = i + 1;

                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
