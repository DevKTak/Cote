package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 나누어떨어지는숫자배열 {

  public static void main(String[] args) {
    int[] arr = new int[]{5,9,7,10};
    int divisor = 5;
    System.out.println(Arrays.toString(solution(arr, divisor)));
  }

  private static int[] solution(int[] arr, int divisor) {
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % divisor == 0) {
        list.add(arr[i]);
      }
    }
    int[] answer = new int[list.size()];

    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }
    Arrays.sort(answer);

    return answer.length > 0 ? answer : new int[]{-1};
  }
}
