package ndb.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임개발 {

    public static int direction;

    static void turnLeft() {
        direction--;

        if (direction < 0) {
            direction += 4;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        // 북 동 남 서
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        visited[a][b] = true;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시뮬레이션 시작
        int count = 1;
        int turnCount = 0;

        while (true) {
            turnLeft();

            // 왼쪽 방향에 아직 가보지 않은 칸 일 경우
            int nx = a + dx[direction];
            int ny = b + dy[direction];

            if (map[nx][ny] == 0 && !visited[nx][ny]) { // 육지이면서 방문한적 없을 경우 한 칸 이동
                visited[nx][ny] = true;
                count++;
                a = nx;
                b = ny;
                turnCount = 0;

                continue;
            } else { // 회전하고 앞이 바다이거나 방문했던 곳 일 경우
                turnCount++;
            }

            if (turnCount == 4) { // 네 방향 모두 이미 가본 칸이거나 바다일 경우
                nx = a - dx[direction];
                ny = b - dy[direction];

                if (map[nx][ny] == 0) {
                    a = nx;
                    b = ny;
                    turnCount = 0;
                } else {
                    // 뒤 쪽 방향 한 칸 이동한 곳이 바다라서 뒤로 갈 수 없는 경우
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
