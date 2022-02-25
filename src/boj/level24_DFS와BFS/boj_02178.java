package boj.level24_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 미로 탐색
 */
public class boj_02178 {

    private static int[][] map;
    private static int[][] checkArr;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        checkArr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - 48;
            }
        }


        bfs(0, 0);
        System.out.println(checkArr[N - 1][M - 1]);
    }

    static class Pair {

        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));
        checkArr[x][y] = 1;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xSum = pair.x + dx[i];
                int ySum = pair.y + dy[i];

                if ((0 <= xSum) && (xSum < N) && (0 <= ySum) && (ySum < M)) {
                    if (checkArr[xSum][ySum] == 0 && map[xSum][ySum] == 1) {
                        checkArr[xSum][ySum] = checkArr[pair.x][pair.y] + 1;
                        queue.offer(new Pair(xSum, ySum));
                    }
                }
            }
        }
    }
}
