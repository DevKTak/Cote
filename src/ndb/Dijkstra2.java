package ndb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 다익스트라 알고리즘 시간복잡도 O(ElogV)
 * E: 간선의 개수
 * V: 노드의 개수
 */
class Node2 implements Comparable<Node2> {

  private int index;
  private int distance;

  public Node2(int index, int distance) {
    this.index = index;
    this.distance = distance;
  }

  public int getIndex() {
    return this.index;
  }

  public int getDistance() {
    return this.distance;
  }

  // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
  @Override
  public int compareTo(Node2 other) {
    if (this.distance < other.distance) {
      return -1;
    }
    return 1;
  }

  @Override
  public String toString() {
    return "Node2{" +
       "index=" + index +
       ", distance=" + distance +
       '}';
  }
}

/**
 * 성능이 개선 된 다익스트라 알고리즘 (Heap 활용)
 *
 * - 방문처리가 되었는지 여부를 확인하는 테이블이 필요하지 않다.
 * - 매번 현재 상황에서 가장 최단거리가 짧은 노드를 고르기 위한 함수가 필요하지 않다.
 */
public class Dijkstra2 {

  public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정

  // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
  // 노드의 개수는 최대 100,000개라고 가정
  public static int n, m, start;

  // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
  public static ArrayList<ArrayList<Node2>> graph = new ArrayList<ArrayList<Node2>>();

  // 최단 거리 테이블 만들기
  public static int[] d = new int[100001];

  public static void dijkstra(int start) {
    PriorityQueue<Node2> pq = new PriorityQueue<>();

    // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
    pq.offer(new Node2(start, 0));
    d[start] = 0;

    while(!pq.isEmpty()) { // 큐가 비어있지 않다면
      // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
      Node2 node = pq.poll();
      int now = node.getIndex(); // 현재 노드
      int dist = node.getDistance(); // 현재 노드까지의 비용

      // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
      // === (현재 우선순위 큐에서 꺼낸 거리값이 테이블에 기록 된 거리값보다 크다면 무시
      // 갱신 할 필요 X
      if (d[now] < dist) continue;

      // 현재 노드와 연결된 다른 인접한 노드들을 확인
      for (int i = 0; i < graph.get(now).size(); i++) {
        int cost = d[now] + graph.get(now).get(i).getDistance(); // 현재 노드까지의 거리 + 현재노드에서 인접 노드까지의 거리
        int adjacentNode = graph.get(now).get(i).getIndex();

        // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가
        // 인접노드번호 현재 최단거리 테이블에 기록 된 거리값 보다 더 짧은 경우
        if (cost < d[adjacentNode]) { // 갱신 여부 판단
          d[adjacentNode] = cost; // 더 최단 거리로 갱신
          pq.offer(new Node2(adjacentNode, cost)); // 우선순위큐에도 삽입
        }
      }
    }
  }

  public static void main(String[] args) {
    // 6 11 1 1 2 2 1 4 1 1 3 5 4 3 3 4 5 1 2 3 3 2 4 2 3 2 3 3 6 5 5 3 1 5 6 2
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt(); // 6
    m = sc.nextInt(); // 11
    start = sc.nextInt(); // 1

    // 그래프 초기화
    /** i <= n 잊지말것! 0번 노드는 없기때문
     * bj_01260 에서 인접 리스트 만들때는 ArrayList 배열이라 [n + 1] 해주는 방식 사용
     * 여기서는 이중 ArrayList 방식 사용!
     */
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Node2>());
    }

    // 모든 간선 정보를 입력받기 (인접 리스트 만들기)
    // 1 2 2 1 4 1 1 3 5 4 3 5 4 5 1 2 3 3 2 4 2 3 2 3 3 6 5 5 3 1 5 6 2
    for (int i = 0; i < m; i++) {  // 간선 수 만큼
      int a = sc.nextInt(); // 1 1 1 4 4 2 2 3 3 5 5
      int b = sc.nextInt(); // 2 4 3 3 5 3 4 2 6 3 6
      int c = sc.nextInt(); // 2 1 5 3 1 3 2 3 5 1 2
      // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
      graph.get(a).add(new Node2(b, c));
    }

    // 인접 리스트 찍어보기
    for (int i = 0; i < graph.size(); i++) {
      System.out.println(i + "번 노드 = " + graph.get(i).toString());
    }

    // 최단 거리 테이블을 모두 무한으로 초기화
    Arrays.fill(d, INF);

    for (int i = 0; i < 10; i++) { // 최단 거리 테이블 배열 10개만 찍어보기
      System.out.print(d[i] + " ");
    }
    System.out.println();

    // 다익스트라 알고리즘을 수행
    dijkstra(start);

    // 모든 노드로 가기 위한 최단 거리를 출력
    for (int i = 1; i <= n; i++) {
      // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
      if (d[i] == INF) {
        System.out.println("INFINITY");
      }
      // 도달할 수 있는 경우 거리를 출력
      else {
        System.out.println(d[i]);
      }
    }
//             d[1] d[2] d[3] d[4] d[5] d[6]
    // 최단거리: 0    2    3    1    2    4
  }
}
