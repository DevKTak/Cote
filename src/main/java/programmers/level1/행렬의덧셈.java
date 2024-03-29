package programmers.level1;

import java.util.Arrays;

public class 행렬의덧셈 {

  public static void main(String[] args) {
    int[][] arr1 = {{1, 2}, {2, 3}};
    int[][] arr2 = {{3, 4}, {5, 6}};

    int[][] answer = new int[arr1.length][arr1[0].length];

    for (int i = 0; i < arr1.length; i++) {
      for (int j = 0; j < arr1[0].length; j++) {
        answer[i][j] = arr1[i][j] + arr2[i][j];
      }
    }

    for (int[] val : answer) {
      System.out.println(Arrays.toString(val));
    }
  }
}
