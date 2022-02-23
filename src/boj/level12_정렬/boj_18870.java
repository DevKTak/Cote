package boj.level12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 좌표 압축 (순위(Rank))
 */
public class boj_18870 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] originArr = new int[N]; // 원본 배열
    for (int i = 0; i < N; i++) {
      originArr[i] = Integer.parseInt(st.nextToken());
    }

    int[] arrClone = originArr.clone(); // 정렬 할 배열
    Arrays.sort(arrClone);

    Map<Integer, Integer> map = new HashMap<>();
    int rank = -1;
    for (int v : arrClone) {
      map.put(v, map.containsKey(v) ? rank : ++rank);
    }

    StringBuilder sb = new StringBuilder();
    for (int v : originArr) {
      sb.append(map.get(v)).append(" ");
    }
    System.out.println(sb);
  }
}
