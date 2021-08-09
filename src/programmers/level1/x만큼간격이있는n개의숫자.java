package programmers.level1;

import java.util.Arrays;

public class x만큼간격이있는n개의숫자 {

  public static void main(String[] args) {
    int x = 2;
    int n = 5;

    System.out.println(Arrays.toString(solution(x, n)));
  }

  private static long[] solution(int x, int n) {
    long[] answer = new long[n];
    long sum = 0;

    for (int i = 0; i < n; i++) {
      sum += x;
      answer[i] = sum;
    }

    return answer;
  }
}
