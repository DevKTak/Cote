package programmers.kdc2.mockTest.b;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class test1 {

  public static void main(String[] args) {
    int[][] result = solution(3, 4, 2, new int[][]{{3, 2}, {3, 2}, {2,2},{3,2},{1,4},{3,2},{2,3},{3,1}});

    for (int[] arr : result) {
      System.out.println(Arrays.toString(arr));
    }
  }

  static class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private static int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
    int[][] answer = new int[rows][columns];

    for (int i = 0; i < queries.length; i++) {
      bfs(queries[i][0], queries[i][1], max_virus, rows, columns, answer);
    }

    return answer;
  }

  private static void bfs(int queryRow, int queryColumn, int max_virus, int rows, int columns, int[][] answer) {
    int[][] check = new int[rows][columns];

    // 상, 하, 좌, 우
    int[] dx= {-1, 1, 0, 0}; // 행
    int[] dy = {0, 0, -1, 1}; // 열


    Queue<Pair> q = new LinkedList<>();
    q.offer(new Pair(queryRow - 1, queryColumn - 1));
    check[queryRow - 1][queryColumn - 1] = 1;

    if (answer[queryRow - 1][queryColumn - 1] != max_virus) {
      answer[queryRow - 1][queryColumn - 1]++;
    } else {
      while (!q.isEmpty()) {
        Pair pair = q.poll();

        for (int i = 0; i < 4; i++) {
          int nx = pair.x + dx[i];
          int ny = pair.y + dy[i];

          if (0 <= nx && nx < rows && 0 <= ny && ny < columns) { // 배열 범위 안에 속하는지 검사
            if (check[nx][ny] == 0) { // 방문한적이 없고
              if (answer[nx][ny] != max_virus) { // 최대 세균이 아닐 경우 + 1
                check[nx][ny] = 1;
                answer[nx][ny]++;
              } else { // 최대 세균일 경우 상, 하, 좌, 우 검사
                q.offer(new Pair(nx, ny));
                check[nx][ny] = 1;
              }
            }
          }
        }
      }
    }
  }
}







