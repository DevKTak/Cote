package programmers.kdc.sort;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {

  public static void main(String[] args) {
    System.out.println(solution(new int[]{0, 0, 0}));
  }

  private static String solution(int[] numbers) {
    String strNumbers[] = new String[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      strNumbers[i] = String.valueOf(numbers[i]);
    }

    Arrays.sort(strNumbers, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        return (s2 + s1).compareTo(s1 + s2);
      }
    });
    System.out.println(Arrays.toString(strNumbers));

    String answer = "";
    for (String num : strNumbers) {
      answer += num;
    }

    // numbers 배열이 0, 0, 0 일 경우
    if (answer.startsWith("0")) {
      return "0";
    }

    return answer;
  }
}
