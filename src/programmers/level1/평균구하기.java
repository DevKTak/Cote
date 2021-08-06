package programmers.level1;

import java.util.Arrays;

public class 평균구하기 {

  public static void main(String[] args) {
    int[] arr = {1,2,3,4};
    System.out.println(solution(arr));
  }

  private static double solution(int[] arr) {
    double sum = 0.0d;

    for (int val : arr) {
      sum += val;
    }

    return sum / arr.length;
  }
}
