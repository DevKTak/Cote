package cote.devMatching;

import java.util.Arrays;

public class devMatching2 {

  public static void main(String[] args) {
    System.out.println(solution(4, "FRI", new int[]{2, 6, 17, 29}));
  }

  public static int solution(int leave, String day, int[] holidays) {
    boolean[] arr = new boolean[31]; // 0 ~ 30
    String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    int sIndex = Arrays.asList(days).indexOf(day)  + 1;
    int weekend = 7 - sIndex;
    int weekend2 = weekend + 1;

    for (int i = 1; i < 31; i++) {
      if (i % weekend == 0 || i % weekend2 == 0) {
        arr[i] = true;
      }
    }

    System.out.println(Arrays.toString(arr));


    return 0;
  }
}
