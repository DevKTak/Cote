package programmers.kdc2.greedy;

public class 기지국설치 {

  public static void main(String[] args) {
//    System.out.println(solution(11, new int[]{4, 11}, 1));
    System.out.println(solution(16, new int[]{9}, 2));
  }

  private static int solution(int n, int[] stations, int w) {
    int answer = 0;
    int position = 1;
    int index = 0;

    while (position <= n) {
      if (index < stations.length && stations[index] - w <= position) {
        position = stations[index] + w + 1;
        index++;
      } else {
        answer++;
        position += 2 * w + 1;
      }
    }

    return answer;
  }
}
