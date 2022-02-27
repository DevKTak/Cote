package boj.level24_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 나이트의 이동
 */
public class boj_07562 {

    static class Pair {

        int x;
        int y;
        int count;

        Pair(int x, int y) {
            this(x, y, 0);
        }

        Pair(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    private static int N;
    private static boolean[][] visited;
    private static Pair start, end;
    private static int dx[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static int dy[] = {-2, -1, 1, 2, -2, -1, 1, 2};
    private static Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 체스판 한변의 길이
            visited = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            start = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            end = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            System.out.println(bfs());
        }
    }

    private static int bfs() {
         visited[start.x][start.y] = true;
         queue.clear();
         queue.offer(start);

         while (!queue.isEmpty()) {
             Pair pair = queue.poll();

             if (pair.x == end.x && pair.y == end.y) {
                 return  pair.count;
             }

             for (int i = 0; i < 8; i++) {
                 int xSum = pair.x + dx[i];
                 int ySum = pair.y + dy[i];

                 if (0 <= xSum && xSum < N && 0 <= ySum && ySum < N) {
                     if (!visited[xSum][ySum]) {
                         visited[xSum][ySum] = true;
                         queue.offer(new Pair(xSum, ySum, pair.count + 1));
                     }
                 }
             }
         }

         return 0;
    }
}
