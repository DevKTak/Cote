package programmers.level1;

public class 신규아이디추천 {

  public static void main(String[] args) {
    String new_id = "...!@BaT#*..y.abcdefghijklm";
    System.out.println(solution(new_id)); // bat.y.abcdefghi
  }

  private static String solution(String new_id) {
    System.out.println("new_id: " + new_id);

    new_id = new_id.toLowerCase();
    System.out.println("1단계: " + new_id);

    new_id = new_id.replaceAll("[^\\_\\-\\.a-z0-9]", "");
    System.out.println("2단계: " + new_id);

    new_id = new_id.replaceAll("\\.{2,}", ".");
    System.out.println("3단계: " + new_id);

    new_id = new_id.replaceAll("^\\.|\\.$", "");
    System.out.println("4단계: " + new_id);

    if (new_id.equals("")) new_id = "a";
    System.out.println("5단계: " + new_id);

    if (new_id.length() >= 16) {
      new_id = new_id.substring(0, 15).replaceAll("\\.$", "");
    }
    System.out.println("6단계: " + new_id);

    if (new_id.length() <= 2) {
      if (new_id.length() == 1) {
        new_id = new_id + new_id + new_id;
      } else {
        new_id += new_id.charAt(1);
      }
    }
    System.out.println("7단계: " + new_id);

    return new_id;
  }
}
