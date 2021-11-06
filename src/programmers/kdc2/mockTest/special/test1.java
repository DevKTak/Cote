package programmers.kdc2.mockTest.special;

import java.util.Arrays;

public class test1 {

  public static void main(String[] args) {
    System.out.println(solution(new int[]{2, 3}, new int[]{1, 2, 3}));
    System.out.println(solution(new int[]{1, 2, 3}, new int[]{1, 1}));
  }

  private static int solution(int[] people, int[] tshirts) {
    int answer = 0;
    Arrays.sort(people);
    Arrays.sort(tshirts);

    for (int i = 0; i < people.length; i++) {
      for (int j = 0; j < tshirts.length; j++) {
        if (people[i] <= tshirts[j]) {
          tshirts[j] = 0;
          answer++;
          break;
        }
      }
    }

    return answer;
  }
}
