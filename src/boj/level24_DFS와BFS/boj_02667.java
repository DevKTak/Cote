package boj.level24_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 단지번호붙이기
 */
public class boj_02667 {

    private static int[][] map;
    private static int[][] group;
    private static int groupNum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        group = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - 48;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                /* bfs 시작 위치를 찾는 작업
                   bfs 호출할 때마다 group에 groupNum값을 넣어 줄 것이기 때문에
                   문제의 예제 같은 경우에는 세번 호출 될 것임! */
                if ((map[i][j] == 1) && (group[i][j] == 0)) { // 집이 있는곳 이면서 그룹번호가 안매겨진곳
                    groupNum++;
                    bfs(i, j);
                }
            }
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

    private static void bfs(int i, int j) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j));
        group[i][j] = groupNum;
    }
}
