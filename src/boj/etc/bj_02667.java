package boj.etc;

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
public class bj_02667 {

  /** 좌표 클래스 **/
  static class Pair {
    int x;
    int y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private static final int[] dx = { -1, 1, 0, 0 };
  private static final int[] dy = { 0, 0, -1, 1 };

  public static void bfs(int[][] maps, int[][] group, int i, int j, int groupNum, int n) {
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(i, j));
    group[i][j] = groupNum;

    while (!q.isEmpty()) {
      Pair pair = q.poll();

      for (int k = 0; k < 4; k++) {
        int nx = pair.x + dx[k];
        int ny = pair.y + dy[k];

        if (0 <= nx && nx < n && 0 <= ny && ny < n) { // maps 배열 범위 안에 속하는지 검사
          if (maps[nx][ny] == 1 && group[nx][ny] == 0) { // 집이 있는곳(1) 이면서 단지번호가 붙지 않은곳
            q.add(new Pair(nx, ny));
            group[nx][ny] = groupNum;
          }
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int[][] maps = new int[n][n]; // 단지 이중배열

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String s = st.nextToken();

      for (int j = 0; j < n; j++) {
        maps[i][j] = s.charAt(j) - '0';
      }
    }
    int groupNum = 0;
    int[][] group = new int[n][n]; // 단지들의 그룹 구분

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (maps[i][j] == 1 && group[i][j] == 0) {
          bfs(maps, group, i, j, ++groupNum, n);
        }
      }
    }
    int answer[] = new int[groupNum];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (group[i][j] != 0) {
          answer[group[i][j] - 1]++;
        }
      }
    }
    Arrays.sort(answer);
    System.out.println(groupNum);

    for (int i = 0; i < answer.length; i++) {
      System.out.println(answer[i]);
    }
  }
}
