package boj.etc;

import java.util.Scanner;

public class bj_09095 {

  static int dfsCnt = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    for (int i = 0; i < T; i++) {
      dfs(sc.nextInt(), 0);
      System.out.println(dfsCnt);
      dfsCnt = 0;
    }
  }

  private static void dfs(int numOfStairs, int sum) {
    if (sum == numOfStairs) {
      dfsCnt++;
      return;
    } else if (sum > numOfStairs) {
      return;
    }

    for (int i = 1; i < 4; i++) {
      dfs(numOfStairs, sum + i);
    }
  }
}
