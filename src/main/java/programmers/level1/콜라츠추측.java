package programmers.level1;

public class 콜라츠추측 {

  public static void main(String[] args) {
    int n = 626331;
    System.out.println(solution(n));
  }

  private static int solution(int num) {
    long longNum = num;
    int cnt = 0;

    while (cnt <= 500 && longNum != 1) {
      longNum = longNum % 2 == 0 ? longNum / 2 : longNum * 3 + 1;
      cnt++;
    }

    return cnt > 500 || longNum != 1 ? -1 : cnt;
  }
}
