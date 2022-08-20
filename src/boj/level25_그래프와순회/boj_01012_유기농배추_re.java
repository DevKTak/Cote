package boj.level25_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 유기농 배추
 */
public class boj_01012_유기농배추_re {

    private static int M, N, K;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static class Pair {

        int x;
        int y;

        private Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        int col, row;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로길이 (열)
            N = Integer.parseInt(st.nextToken()); // 세로길이 (행)
            K = Integer.parseInt(st.nextToken()); // 배추가 있는 위치의 개수
            int cnt = 0;

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                col = Integer.parseInt(st.nextToken()); // 열 10
                row = Integer.parseInt(st.nextToken()); // 행 6
                map[row][col] = 1;
            }

            for (int k = 0; k < N; k++) {
                for (int j = 0; j < M; j++) {
                    if (map[k][j] == 1 && !visited[k][j]) {
                        cnt++;

                        bfs(k, j);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void bfs(int row, int col) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));
        visited[row][col] = true;

        while (!q.isEmpty()) {
            Pair pair = q.poll();

            for (int k = 0; k < 4; k++) {
                int sumX = pair.x + dx[k];
                int sumY = pair.y + dy[k];

                if (0 <= sumX && sumX < N && 0 <= sumY && sumY < M) { // 범위 체크
                    if (!visited[sumX][sumY] && map[sumX][sumY] == 1) {
                        visited[sumX][sumY] = true;
                        q.offer(new Pair(sumX, sumY));
                    }
                }
            }
        }
    }
}
