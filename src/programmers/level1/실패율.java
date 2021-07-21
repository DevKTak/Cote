package programmers.level1;

import java.util.*;

public class 실패율 {

  public static void main(String[] args) {
    int N = 5;
    int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
    System.out.println(Arrays.toString(solution(N, stages))); // [3,4,2,1,5]
  }

  private static int[] solution(int N, int[] stages) {
    Map<Integer, Double> map = new HashMap<>();
    int cnt = 0, totalCnt = 0;
    double failPercent = 0.0d;

    for (int i = 1; i <= N; i++) {
      cnt = 0;
      totalCnt = 0;

      for (int j = 0; j < stages.length; j++) {
        if (i == stages[j]) {
          cnt++;
        }
        if (i <= stages[j]) {
          totalCnt++;
        }
      }

      if (cnt != 0) {
        failPercent = (double) cnt / (double) totalCnt;
      } else { // cnt == 0
        failPercent = 0;
      }
      System.out.println("cnt : " + cnt + " / totalCnt : " + totalCnt);

      map.put(i, failPercent);
    }

    System.out.println("\n------------- HashMap 내림차순 정렬 -------------\n");
    List<Integer> keySetList=  new ArrayList<>(map.keySet());
    Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
    int[] result = new int[N];

    for (int i = 0; i < keySetList.size(); i++) {
      result[i] = keySetList.get(i);
      System.out.println("key : " + keySetList.get(i) + " / " + "value : " + map.get(keySetList.get(i)));
    }

    return result;
  }
}
