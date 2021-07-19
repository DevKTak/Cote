package programmers.level1;

import java.util.Arrays;

public class 로또의최고순위와최저순위 {

  public static void main(String[] args) {
    int[] lottos = {44, 1, 0, 0, 31, 25};
    int[] win_nums = {31, 10, 45, 1, 6, 19};
    로또의최고순위와최저순위 참조변수 = new 로또의최고순위와최저순위();
    System.out.println(Arrays.toString(참조변수.solution(lottos, win_nums)));
  }

  private int[] solution(int[] lottos, int[] win_nums) {
    System.out.println(Arrays.toString(lottos));
    Arrays.sort(lottos);
    System.out.println(Arrays.toString(lottos));

    int zeroCnt = 0, sameCnt = 0;

    for (int lotto : lottos) {
      if (lotto == 0) {
        zeroCnt++;
        continue;
      } else {
        for (int win_num : win_nums) {
          if (lotto == win_num) {
            sameCnt++;
            break;
          }
        }
      }
    }
    System.out.println("zeroCnt : " + zeroCnt + "\nsameCnt : " + sameCnt);

    return new int[] {Math.min(7 - (zeroCnt + sameCnt), 6), Math.min(7 - sameCnt, 6)};
  }
}
