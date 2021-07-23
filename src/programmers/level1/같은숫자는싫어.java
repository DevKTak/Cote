package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 같은숫자는싫어 {

  public static void main(String[] args) {
    int[] arr = {1,1,3,3,0,1,1};
    System.out.println(Arrays.toString(solution(arr))); // [1,3,0,1]
  }

  private static int[] solution(int[] arr) {
    List<Integer> list = new ArrayList<>();
    list.add(arr[0]);

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] != list.get(list.size() - 1)) {
        list.add(arr[i]);
      }
    }
    int[] result = new int[list.size()];

    for (int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }

    return result;
  }
}
