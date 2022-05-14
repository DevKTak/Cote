package boj.level25_그래프와순회;

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
public class boj_02667_단지번호붙이기 {

    private static int N;
    private static int[][] map;
    private static int[][] group;
    private static int groupNum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
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

                // 집이 있는곳 이면서 그룹번호가 안매겨진곳
                if ((map[i][j] == 1) && (group[i][j] == 0)) {
                    groupNum++;

                    bfs(i, j); // 예제의 시작은 0행 1열
                }
            }
        }

        int[] cntArr = new int[groupNum];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (group[i][j] > 0) {
                    cntArr[group[i][j] - 1]++;
                }
            }
        }
        Arrays.sort(cntArr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cntArr.length; i++) {
            sb.append(cntArr[i]).append(System.lineSeparator());
        }
        System.out.println(groupNum);
        System.out.println(sb);
    }

    static class Pair {

        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //== bfs로 연결된 집들을 순회하면서 하나의 단지를 만든다 ==//
    private static void bfs(int i, int j) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j));
        group[i][j] = groupNum;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int k = 0; k < 4; k++) {
                int xSum = pair.x + dx[k];
                int ySum = pair.y + dy[k];

                // map 범위 안에 있는지
                if ((0 <= xSum) && (xSum < N) && (0 <= ySum) && (ySum < N)) {

                    // 집이 있는 경우(1) 이면서 단지 번호가 붙지 않은곳
                    if ((map[xSum][ySum] == 1) && (group[xSum][ySum] == 0)) {
                        group[xSum][ySum] = groupNum;
                        queue.offer(new Pair(xSum, ySum));
                    }
                }
            }
        }
    }
}
