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

  private static void bfs(int[][] maps, int[][] check, int i, int j, int n) {
    int[] dx = { -1, 1, 0 , 0 };
    int[] dy = { 0, 0, -1, 1 };

    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(i, j));
    check[0][0] = 1;

    while (!q.isEmpty()) {
      Pair pair = q.poll();

      for (int k = 0; k < 4; k++) {
        int nx = pair.x + dx[k];
        int ny = pair.y + dy[k];

        if (0 <= nx && nx < n && 0 <= ny && ny < n) {
          if (maps[nx][ny] == 1 && check[nx][ny] == 0) {
            q.add(new Pair(nx, ny));
            check[nx][ny] = check[pair.x][pair.y] + 1;
          }
        }
      }
    }
  }

  private static int solution(int[][] maps) {
    int n = maps.length;
    int[][] check = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (maps[i][j] == 1 && check[i][j] == 0) {
          bfs(maps, check, i, j, n);
        }
      }
    }
    int answer = check[n - 1][n - 1];

    return answer > 0 ? answer : -1;
  }
}
