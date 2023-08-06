import java.util.*;

class Solution {
    
    static class Pair {
    int x;
    int y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
    
     private static void bfs(int[][] maps, int[][] check, int n, int m) {
    int[] dx = { -1, 1, 0 , 0 };
    int[] dy = { 0, 0, -1, 1 };

    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(0, 0));
    check[0][0] = 1;

    while (!q.isEmpty()) {
      Pair pair = q.poll();

      for (int k = 0; k < 4; k++) {
        int nx = pair.x + dx[k];
        int ny = pair.y + dy[k];

       if (0 <= nx && nx < n && 0 <= ny && ny < m) {
          if (maps[nx][ny] == 1 && check[nx][ny] == 0) {
            q.add(new Pair(nx, ny));
            check[nx][ny] = check[pair.x][pair.y] + 1;
          }
        }
      }
    }
  }
    
    public int solution(int[][] maps) {
       int n = maps.length;
        int m = maps[0].length; // 열
    int[][] check = new int[n][m];

                bfs(maps, check, n, m);

    int answer = check[n - 1][m - 1];

    return answer > 1 ? answer : -1;
    }
}