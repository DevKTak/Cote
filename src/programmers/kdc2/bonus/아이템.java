package programmers.kdc2.bonus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 못푼 문제
public class 아이템 {

  public static void main(String[] args) {
    System.out.println(solution(new int[]{200,120,150}, new int[][]{{30,100}, {500,30}, {100, 400}}));
  }

  private static int solution(int[] healths, int[][] items) {
    Arrays.sort(healths);
    Arrays.sort(items, new Comparator<int[]>() {
      @Override
      public int compare(int[] t1, int[] t2) {
        if (t1[0] == t2[0]) {
          return t1[1] - t2[1];
        } else {
          return t2[0] - t1[0];
        }
      }
    });

    for (int i = 0; i < items.length; i++) {
      System.out.println(Arrays.toString(items[i]));
    }
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < healths.length; i++) {
      for (int j = 0; j < items.length; j++) {
        if (healths[i] - items[j][1] > 100) {
          items[j][1] = 1000000;
          list.add(items[j][0]);
          break;
        }
      }
    }

    System.out.println(list);
    return 0;
  }
}
