package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {

  public static void main(String[] args) {
    int[] answers = {1, 3, 2, 4, 2, 3, 2};
    System.out.println(Arrays.toString(solution(answers)));
  }

  private static int[] solution(int[] answers) {
    int[] stu1 = {1, 2, 3, 4, 5};
    int[] stu2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] stu3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    int stu1Sum = 0;
    int stu2Sum = 0;
    int stu3Sum = 0;

    for (int i = 0; i < answers.length; i++) {
      if (answers[i] == stu1[i % 5]) stu1Sum++;
      if (answers[i] == stu2[i % 8]) stu2Sum++;
      if (answers[i] == stu3[i % 10]) stu3Sum++;
    }

    int maxPoint = Math.max(stu1Sum, stu2Sum);
    maxPoint = Math.max(maxPoint, stu3Sum);
    int[] arr = {stu1Sum, stu2Sum, stu3Sum};
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      if (maxPoint == arr[i]) {
        list.add(i + 1);
      }
    }

    int[] result = new int[list.size()];

    for (int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }

    return result;
  }
}
