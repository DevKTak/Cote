package programmers.level1;

import java.util.Arrays;

public class 다트게임 {

  public static void main(String[] args) {
    String dartResult = "1D2S#10S";
    System.out.println(solution(dartResult));
  }

  private static int solution(String dartResult) {
    dartResult = dartResult.replaceAll("(\\d+)", "|$1");
    System.out.println("dartResult = " + dartResult);

    String[] splitResult = dartResult.split("\\|");
    System.out.println("splitResult = " + Arrays.toString(splitResult));

    int sumArr[] = new int[splitResult.length];

    for (int i = 1; i < splitResult.length; i++) {
      String scoreStr = "";

      if (splitResult[i].indexOf("S") > -1) {
        scoreStr = splitResult[i].substring(0, splitResult[i].indexOf("S"));
      } else if (splitResult[i].indexOf("D") > -1) {
        scoreStr = splitResult[i].substring(0, splitResult[i].indexOf("D"));
      } else {
        scoreStr = splitResult[i].substring(0, splitResult[i].indexOf("T"));
      }
      int score = Integer.parseInt(scoreStr);
      char lastChar = splitResult[i].charAt(splitResult[i].length() - 1);
      int bonus = 0;

      if (lastChar == '*' || lastChar == '#') {
        char lastCharBefore = splitResult[i].charAt(splitResult[i].length() - 2);

        if (lastCharBefore == 'S') {
          bonus = 1;
        } else if (lastCharBefore == 'D') {
          bonus = 2;
        } else {
          bonus = 3;
        }
      } else {
        if (lastChar == 'S') {
          bonus = 1;
        } else if (lastChar == 'D') {
          bonus = 2;
        } else {
          bonus = 3;
        }
      }

      if (splitResult[i].charAt(splitResult[i].length() - 1) == '*') {
        if (i != 1) {
          sumArr[i - 1] *= 2;
        }
        sumArr[i] += Math.pow(score, bonus) * 2;
      } else if (splitResult[i].charAt(splitResult[i].length() - 1) == '#') {
        sumArr[i] -= Math.pow(score, bonus);
      } else {
        sumArr[i] += Math.pow(score, bonus);
      }
      System.out.println(Arrays.toString(sumArr));
    }
    int sum = 0;

    for (int i = 1; i < splitResult.length; i++) {
      sum += sumArr[i];
    }

    return sum;
  }
}
