package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 배달 {

  static class Node implements Comparable<Node> {

    private int index;
    private int time;

    public Node(int index, int time) {
      this.index = index;
      this.time = time;
    }

    public int getIndex() {
      return this.index;
    }

    public int getTime() {
      return time;
    }

    @Override
    public int compareTo(Node node) {
      if (this.time > node.time) {
        return 1;
      }
      return -1;
    }

    @Override
    public String toString() {
      return "Node{" +
         "index=" + index +
         ", time=" + time +
         '}';
    }
  }

  public static final int INF = (int) 1e9;
  public static List<List<Node>> graph = new ArrayList<>();
  public static int[] d = new int[51];

  public static void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(start, 0));
    d[start] = 0;

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      int nowIndex = node.getIndex(); // 현재 마을
      int nowTime = node.getTime(); // 현재 마을까지 걸린 최단 시간

      // 현재 우선순위 큐에서 꺼낸 시간 값이 테이블에 기록 된 시간 값보다 크면 무시 (이미 처리 된 노드)
      if (nowTime > d[nowIndex]) continue;

      // 인접한 다른 마을들을 확인
      for (int i = 0; i < graph.get(nowIndex).size(); i++) {
        int sumTime = d[nowIndex] + graph.get(nowIndex).get(i).getTime(); // 현재 마을까지 걸린 시간 + 현재 마을부터 인접 마을까지 걸리는 시간
        int adjacentNode = graph.get(nowIndex).get(i).getIndex();

        // 현재 마을을 거쳐서 다른 마을까지 이동한 시간이
        // 인접 마을번호 현재 테이블에 최단시간 테이블에 기록 된 시간값 보다 적은 경우
        if (sumTime < d[adjacentNode]) {
          d[adjacentNode] = sumTime;
          pq.offer(new Node(adjacentNode, sumTime));
        }
      }
    }
  }

  public static void main(String[] args) {
    int N = 5;
    int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
    int K = 3;

    // 리스트 초기화 (1번부터 시작하고 0번을 안 사용 할것이기 때문에 <= 번 처리)
    for (int i = 0; i <= N; i++) { // 노드 개수
      graph.add(new ArrayList<>());
    }

    // 인접 리스트 만들기
    for (int i = 0; i < road.length; i++) { // 간선 개수
      graph.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
      graph.get(road[i][1]).add(new Node(road[i][0], road[i][2]));
    }

    // 인접 리스트 찍어보기
    for (int i = 0; i < graph.size(); i++) {
      System.out.println(i + "번 노드 = " + graph.get(i).toString());
    }

    // 최단 시간 테이블을 모두 무한으로 초기화
    Arrays.fill(d, INF);

    dijkstra(1); // 1번 마을부터 시작
    int result = 0;

    for (int resultTime : d) {
      System.out.println(resultTime);
      if (resultTime <= K) {
        result++;
      }
    }
    System.out.println(result);
  }
}
