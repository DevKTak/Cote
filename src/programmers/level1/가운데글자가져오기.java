package programmers.level1;

public class 가운데글자가져오기 {

  public static void main(String[] args) {
    System.out.println(solution("abcde"));
  }

  private static String solution(String s) {
    String answer = "";

    if (s.length() % 2 == 0) { // 짝수
      answer = s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
    } else { // 홀수
      answer = String.valueOf(s.charAt(s.length() / 2));
    }

    return answer;
  }
}
