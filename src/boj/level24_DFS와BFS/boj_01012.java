package boj.level24_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 유기농 배추
 */
public class boj_01012 {

    private static int[][] map;
    private static boolean[][] check;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0 , -1, 1};
    private static  int M, N, K;

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

            map = new int[N][M];
            check = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                col = Integer.parseInt(st.nextToken()); // 열
                row = Integer.parseInt(st.nextToken()); // 행
                map[row][col] = 1;
            }

            int cnt = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if ((map[j][k] == 1) && (!check[j][k])) {
                        cnt++;

                        bfs(j, k);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static class Pair {

        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int row, int col) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(row, col));
        check[row][col] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xSum = dx[i] + pair.x;
                int ySum = dy[i] + pair.y;

                if ((0 <= xSum) && (xSum < N) && (0 <= ySum) && (ySum < M)) {
                    if ((map[xSum][ySum] == 1) && !check[xSum][ySum]) {
                        check[xSum][ySum] = true;
                        queue.offer(new Pair(xSum, ySum));
                    }
                }
            }
        }
    }

}
