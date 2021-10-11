package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_01260_test {

  static List<List<Integer>> adList = new ArrayList<>(); // 인접 리스트(Adjacency-list)
  static boolean[] checkArr; // 방문 여부

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 정점의 개수
    int M = Integer.parseInt(st.nextToken()); // 간선의 개수
    int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호
    System.out.println(N + " / " + M + " / " + V);

    /** 인접리스트 만들기 */
    for (int i = 0; i <= N; i++) { // adList.get(0)은 사용안함!
      adList.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      adList.get(a).add(b);
      adList.get(b).add(a);
    }
    System.out.println("before = " + adList);

    for (int i = 1; i <= N; i++) {
      Collections.sort(adList.get(i));
    }
    System.out.println("after = " + adList);

    checkArr = new boolean[N + 1];
    dfs(V);
    System.out.println();

    checkArr = new boolean[N + 1];
    bfs(V);
    System.out.println();
  }

  private static void dfs(int V) {
    if (checkArr[V]) {
      return;
    } else {
      checkArr[V] = true;
    }
    System.out.print(V + " ");

    for (int elm : adList.get(V)) {
      if (!checkArr[elm]) {
        dfs(elm);
      }
    }
  }

  private static void bfs(int V) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(V);
    checkArr[V] = true;

    while (!queue.isEmpty()) {
      Integer remove = queue.remove();
      System.out.print(remove + " ");

      for (int elm : adList.get(remove)) {
        if (!checkArr[elm]) {
          checkArr[elm] = true;
          queue.add(elm);
        }
      }
    }
  }
}
