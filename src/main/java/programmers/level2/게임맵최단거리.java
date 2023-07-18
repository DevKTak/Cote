package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

  public static void main(String[] args) {
    int[][] maps = { { 1,0,1,1,1 },
                     { 1,0,1,0,1 },
                     { 1,0,1,1,1 },
                     { 1,1,1,0,1 },
                     { 0,0,0,0,1 } };
    System.out.println(solution(maps));
  }

  static class Pair {
    int x;
    int y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private static void bfs(int[][] maps, int[][] check, int n, int m) {
    // 상, 하, 좌, 우
    int[] dx = { -1, 1, 0 , 0 }; // 행
    int[] dy = { 0, 0, -1, 1 }; // 열

    // 최초 셋팅
    Queue<Pair> q = new LinkedList<>();
    q.offer(new Pair(0, 0));
    check[0][0] = 1;

    while (!q.isEmpty()) {
      Pair pair = q.poll();

      for (int k = 0; k < 4; k++) {
        int nx = pair.x + dx[k];
        int ny = pair.y + dy[k];

        if (0 <= nx && nx < n && 0 <= ny && ny < m) { // maps 배열 범위 안에 속하는지 검사
          if (maps[nx][ny] == 1 && check[nx][ny] == 0) { // 벽이 아니면서 방문하지 않은 곳
            q.offer(new Pair(nx, ny));
            check[nx][ny] = check[pair.x][pair.y] + 1;
          }
        }
      }
    }
  }

  private static int solution(int[][] maps) {
    int n = maps.length; // 행
    int m = maps[0].length; // 열
    int[][] check = new int[n][m];

    bfs(maps, check, n, m);
    int answer = check[n - 1][m - 1];

    return answer > 1 ? answer : -1;
  }
}
