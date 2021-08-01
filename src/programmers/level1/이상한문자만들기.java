package programmers.level1;

public class 이상한문자만들기 {

  public static void main(String[] args) {
    String s = "test apple     ";

    String[] strArr = s.split(" ", -1); // limit 가 음수면 zero length string 도 포함
    StringBuilder sb = new StringBuilder();

    for (String splitS : strArr) {
      for (int i = 0; i < splitS.length(); i++) {
        if (i % 2 == 0) {
          sb.append(Character.toUpperCase(splitS.charAt(i)));
        } else {
          sb.append(Character.toLowerCase(splitS.charAt(i)));
        }
      }
      sb.append(" ");
    }
    sb.deleteCharAt(sb.length() - 1);

    System.out.println(sb.toString());
  }
}
