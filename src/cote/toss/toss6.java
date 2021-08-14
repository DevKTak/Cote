package cote.toss;

public class toss6 {

  static int dfsCnt = 0;

  public static void main(String[] args) {
    int numOfStairs = 4; // 계단의 수
    System.out.println(solution(numOfStairs)); // [1, 1, 1, 1], [1, 2, 1], [2, 1, 1], [1, 1, 2], [2, 2], [1, 3], [3, 1] 7 가지
  }

  /**
   * 주어진 계단의 수 N(numOfStairs)로부터, 계단을 오를 수 있는 방법의 수를 반환합니다.
   */
  private static long solution(int numOfStairs) {
    if (numOfStairs == 1) {
      return 1;
    } else if (numOfStairs == 2) {
      return 2;
    } else {
      dfs(0, numOfStairs, 0);
    }

    return dfsCnt;
  }

  private static void dfs(int num, int numOfStairs, int sum) {
    if (sum == numOfStairs) {
      dfsCnt++;
      return;
    } else if (sum > numOfStairs) {
      return;
    }

    for (int i = 1; i < 4; i++) {
      dfs(i, numOfStairs, sum + i);
    }
  }
}
