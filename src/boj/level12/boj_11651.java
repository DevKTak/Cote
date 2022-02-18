package boj.level12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 좌표 정렬하기 2 */
public class boj_11651 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    Location[] arr = new Location[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    Arrays.sort(arr);

    for (Location location : arr) {
      System.out.println(location.x + " " + location.y);
    }
  }

  private static class Location implements Comparable<Location> {

    private int x;
    private int y;

    public Location(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Location location) {
      if (this.y > location.y) {
        return 1;
      } else if (this.y == location.y) {
        if (this.x > location.x) {
          return 1;
        } else {
          return -1;
        }
      } else {
        return -1;
      }
    }
  }
}
