package cote.grep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class grep2 {

  public static String[] gradeIndex = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D+", "D0", "D-", "F"};

  public static void main(String[] args) {
    String[] grades = {"DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+", "AI0001 F", "DB0001 B-", "AI5543 D+", "DS7651 A+", "OS1808 B-"};
    System.out.println(Arrays.toString(solution(grades)));
  }

  private static String[] solution(String[] grades) {
    List<String> answerList = new ArrayList<>();
    answerList.add(grades[0]);

    for (int i = 1; i < grades.length; i++) {
      String[] arrGrade = grades[i].split(" ");
      boolean sameFlag = false;

      for (int j = 0; j < answerList.size(); j++) {
        String[] listGrade = answerList.get(j).split(" ");

        if (listGrade[0].equals(arrGrade[0])) { // 학정번호가 같을 경우
          System.out.println(listGrade[1] + " = " + Arrays.asList(gradeIndex).indexOf(listGrade[1]));
          System.out.println(arrGrade[1] + " = " + Arrays.asList(gradeIndex).indexOf(arrGrade[1]));
          if (Arrays.asList(gradeIndex).indexOf(listGrade[1]) > Arrays.asList(gradeIndex).indexOf(arrGrade[1])) { // 늦게 수강한 과목의 학점이 더 높을 경우
            answerList.remove(j);
            answerList.add(grades[i]);
          }
          sameFlag = true;
        }
      }

      if (!sameFlag) {
        answerList.add(grades[i]);
      }
    }
    System.out.println(answerList);

    String[] answer = new String[answerList.size()];

    for (int i = 0; i < answerList.size(); i++) {
      answer[i] = answerList.get(i);
    }

    return answer;
  }
}
