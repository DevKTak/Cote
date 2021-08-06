package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 제일작은수제거하기 {

  public static void main(String[] args) {
    int[] arr = {4,3,2,1};
    System.out.println(Arrays.toString(solution(arr)));
  }

  private static int[] solution(int[] arr) {
    if (arr.length > 1) {
      int min = arr[0];
      int index = 0;

      for (int i = 0; i < arr.length; i++) {
        if (arr[i] < min) {
          min = arr[i];
          index = i;
        }
      }
      List<Integer> list = new ArrayList<>();

      for (int val : arr) {
        list.add(val);
      }
      list.remove(index);
      int[] answer = new int[list.size()];

      for (int i = 0; i < list.size(); i++) {
        answer[i] = list.get(i);
      }

      return answer;
    }

    return new int[]{-1};
  }
}
