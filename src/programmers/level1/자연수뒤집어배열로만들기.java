package programmers.level1;

import java.util.Arrays;

public class 자연수뒤집어배열로만들기 {

  public static void main(String[] args) {
    int n = 12345;
    System.out.println(Arrays.toString(solution(n)));
  }

  private static int[] solution(long n) {
    // String nStr = String.valueOf(n);
    // String[] nStrArr = nStr.split("");
    // int[] answer = new int[nStr.length()];
    // for (int i = nStr.length() - 1; i >= 0; i--) {
    //     answer[nStr.length() - i -1] = Integer.parseInt(nStrArr[i]);
    // }

    // return answer;

    // 다른 방법
    String nStr = String.valueOf(n);
    StringBuilder sb = new StringBuilder(nStr);
    sb.reverse();
    int[] answer = new int[nStr.length()];
    for (int i = 0; i < nStr.length(); i++) {
      answer[i] = Integer.parseInt(sb.substring(i, i + 1));
    }

    return answer;
  }
}
