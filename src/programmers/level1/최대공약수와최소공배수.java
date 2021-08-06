package programmers.level1;

import java.util.Arrays;

public class 최대공약수와최소공배수 {

  public static void main(String[] args) {
    int n = 3, m = 12;
    System.out.println(Arrays.toString(solution(n, m)));
  }

  private static int[] solution(int n, int m) {
    return new int[]{getGcd(n, m), n * m / getGcd(n, m)};
  }

  private static int getGcd(int n, int m) {
    int big = Math.max(n, m);
    int small = Math.min(n, m);

    while (small != 0) {
      int temp = big % small;
      big = small;
      small = temp;
    }

    return big;
  }
}
