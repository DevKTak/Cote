package programmers.kdc2.simulation;

import java.util.Arrays;

public class 숫자게임 {

  public static void main(String[] args) {
    System.out.println(solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}));
  }

  private static int solution(int[] A, int[] B) {
    Arrays.sort(A);
    Arrays.sort(B);
    int index = B.length - 1;
    int answer = 0;

    for (int i = A.length - 1; i >= 0; i--) {
      if (A[i] < B[index]) {
        index--;
        answer++;
      }
    }

    return answer;
  }
}
