package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * DFS와 BFS
 */
public class bj_1260 {

  static ArrayList<Integer>[] adList; // 인접 리스트(Adjacency-list)
  static boolean[] checkArr; // 방문 여부

  /** dfs 로직 */
  private static void dfs(int V) {
    if (checkArr[V]) return; // 이미 방문한 경우
    checkArr[V] = true; // 방문 처리
    System.out.println(V + " ");

    for (int ad : adList[V]) { // V 정점의 인접 리스트 정점들 순차 방문
      if (!checkArr[ad]) { // 방문한 적이 없을 경우
        dfs(ad);
      }
    }
  }

  /** bfs 로직 */
  private static void bfs(int V) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(V);
    checkArr[V] = true;

    while (!queue.isEmpty()) {
      int queueRemoveVal = queue.remove();
      System.out.println(V + " ");

      for (int ad : adList[queueRemoveVal]) {
        if (!checkArr[ad]) {
          checkArr[ad] = true;
          queue.add(ad);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 정점의 개수
    int M = Integer.parseInt(st.nextToken()); // 간선의 개수
    int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호
    adList = (ArrayList<Integer>[]) new ArrayList[N + 1]; // (정점의 개수 + 1) 배열 크기 초기화

    /** List 초기화 */
    for (int i = 1; i <= N; i++) {
      adList[i] = new ArrayList<>();
    }

    /** 인접 리스트 만드는 작업 */
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      adList[start].add(end);
      adList[end].add(start);
    }
    System.out.println(Arrays.toString(adList)); // 인접 리스트 찍어보기

    /** 각 리스트에 저장된 값 오름차순 정렬 (작은 숫자 정점부터 방문하기 위해) */
    for (int i = 1; i <= N; i++) {
      Collections.sort(adList[i]);
    }

    checkArr = new boolean[N + 1]; // 0번 정점은 없기 때문에 N + 1 해준다
    dfs(V);
    System.out.println();
    checkArr = new boolean[N + 1];
    bfs(V);
    System.out.println();
  }
}
