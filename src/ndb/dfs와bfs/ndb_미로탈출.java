package ndb.dfs와bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ndb_미로탈출 {

    private static int n;
    private static int m;
    private static int[][] miro;
    private static boolean[][] visited;

    static class Pair {

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        miro = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for (int j = 0; j < m; j++) {
                miro[i][j] = s.charAt(j) - 48;
            }
        }

        bfs(0, 0);

        System.out.println(miro[n - 1][m - 1]);
    }

    public static void bfs(int x, int y) {

        // 상, 하, 좌, 우
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int distance = miro[pair.x][pair.y] + 1;

            for (int i = 0; i < 4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (!visited[nx][ny] && miro[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        miro[nx][ny] = distance;
                        queue.offer(new Pair(nx, ny));
                    }
                }
            }
        }
    }
}
