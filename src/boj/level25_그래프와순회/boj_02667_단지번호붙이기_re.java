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
public class boj_02667_단지번호붙이기_re {

    private static int[][] arr;
    private static int[][] group;
    private static int groupNum = 0;

    static class Pair {

        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        group = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && group[i][j] == 0) { // 집이 있으면서 아직 그룹이 정해지지 않은곳 기준으로 탐색
                    groupNum++;

                    bfs(i, j, N);
                }
            }
        }

        int[] cnt = new int[groupNum];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (group[i][j] > 0) {
                    ++cnt[group[i][j] - 1];
                }
            }
        }
        System.out.println(groupNum);

        Arrays.sort(cnt);

        for (int i = 0; i < groupNum; i++) {
            System.out.println(cnt[i]);
        }
    }

    private static void bfs(int i, int j, int N) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        group[i][j] = groupNum;

        while (!q.isEmpty()) {
            Pair pair = q.poll();

            for (int k = 0; k < 4; k++) {
                int sumX = pair.x + dx[k];
                int sumY = pair.y + dy[k];

                if (0 <= sumX && sumX < N && 0 <= sumY && sumY < N) { // 범위 확인
                    if (arr[sumX][sumY] == 1 && group[sumX][sumY] == 0) {
                        group[sumX][sumY] = groupNum;
                        q.offer(new Pair(sumX, sumY));
                    }
                }
            }
        }
    }
}


























