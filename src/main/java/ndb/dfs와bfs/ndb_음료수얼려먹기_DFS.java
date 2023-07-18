package ndb.dfs와bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ndb_음료수얼려먹기_DFS {

    private static int n;
    private static int m;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로 길이 == 행
        m = Integer.parseInt(st.nextToken()); // 가로 길이 == 열
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for (int j = 0; j < m; j++) {
                graph[i][j] = s.charAt(j) - 48;
            }
        }

        for (int[] a : graph) {
            System.out.println(Arrays.toString(a));
        }

        int result = 0;

        // (0, 0)부터 모든 노드 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private static boolean dfs(int x, int y) {

        // 그래프 범위안에 안에 들어가지 않으면 리턴
        if (x > n - 1 || x < 0 || y > m - 1 || y < 0) {
            return false;
        }

        // 그래프 범위안에 들어가면서 얼음(0)이면
        if (graph[x][y] == 0) {
            graph[x][y] = 1;

            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);

            return true; // 41번 라인에서 최초 호출한 후 이 if문에만 들어오면 최소 한 개 짜리 얼음을 만들 수 있다.
        }

        return false;
    }
}
