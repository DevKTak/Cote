package programmers.kdc2.binarySearch;

import java.util.stream.IntStream;

/**
 * 예를 들어, 전체 국가예산이 485이고 4개 지방의 예산요청이 각각 120, 110, 140, 150일 때,
 * 상한액을 127로 잡으면 위의 요청들에 대해서 각각 120,110, 127, 127을 배정하고
 * 그 합이 484로 가능한 최대가 됩니다.
 * 각 지방에서 요청하는 예산이 담긴 배열 budgets 총 예산 M이 매개변수로 주어질 때,
 * 위 의 조건을 모두 만족하는 상한액을 return 하도록 solution 함수를 작성해주세요.
 *
 * budgets: [120, 110, 140, 150]
 * M     : 485
 * return: 127
 */
public class 예산 {

  public static void main(String[] args) {
    System.out.println(solution(new int[]{120, 110, 140, 150}, 485));
  }

  private static int solution(int[] budgets, int M) {
    int min = 0;
    int max = IntStream.of(budgets).max().orElse(0); // return Optional(Int)
    /*int max = Integer.MIN_VALUE;

    for (int v : budgets) {
      if (v > max) {
        max = v;
      }
    }*/
    int answer = 0;

    while (min <= max) {
      final int mid = (min + max) / 2;

      int sum = IntStream.of(budgets)
        .map(v -> Math.min(v, mid))
        .sum();
      /*int sum = 0;
      for (int v : budgets) {
        sum += Math.min(v, mid);
      }*/

      if (sum <= M) {
        min = mid + 1;
        answer = mid;
      } else {
        max = mid - 1;
      }
    }

    return answer;
  }
}
