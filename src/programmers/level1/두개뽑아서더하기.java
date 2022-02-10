package programmers.level1;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class 두개뽑아서더하기 {

  public static void main(String[] args) {
    int[] numbers = new int[]{2,1,3,4,1};

    Set<Integer> set = new TreeSet<>(); // 중복x 이면서 오름차순 정렬 되서 TreeSet으로 결정

    for (int i = 0; i < numbers.length - 1; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        set.add(numbers[i] + numbers[j]);
      }
    }
    System.out.println(set);

    int[] result = new int[set.size()];
    int cnt = 0;

    for (int val : set) {
      result[cnt++] = val;
      System.out.println(val);
    }

//    System.out.println(Arrays.toString(result));
  }
}
