package programmers.level1;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {

  public static void main(String[] args) {
    System.out.println(solution());
  }

  private static int solution() {
    int[] nums = {3,3,3,2,2,4};
    Set<Integer> set = new HashSet<>();

    for (int num : nums) {
      set.add(num);
    }
    int saveCount = nums.length / 2;

    return set.size() > saveCount ? saveCount : set.size();
  }
}
