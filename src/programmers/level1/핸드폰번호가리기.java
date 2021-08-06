package programmers.level1;

public class 핸드폰번호가리기 {

  public static void main(String[] args) {
    String phone_number ="01033334444";
    System.out.println(solution(phone_number));
  }

  private static String solution(String phone_number) {
    return phone_number.replaceAll("\\d(?=\\d{4})", "*");
  }
}
