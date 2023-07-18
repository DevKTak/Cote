package practice;

import java.util.*;

public class Dijkstra_test {

  static class Node implements Comparable<Node> {

    private int index;
    private int distance;

    public Node(int index, int distance) {
      this.index = index;
      this.distance = distance;
    }

    public int getIndex() {
      return index;
    }

    public int getDistance() {
      return distance;
    }

    @Override
    public int compareTo(Node node) {
      if (this.index < node.index) {
        return -1;
      }
      return 1;
    }
  }

  public static int n, m, start;
  public static int[] minDistance;

  public static List<List<Node>> adjList = new ArrayList<>(); // 인접 리스트(Adjacency-list)

  public static void main(String[] args) {
    // 6 11 1 1 2 2 1 4 1 1 3 5 4 3 3 4 5 1 2 3 3 2 4 2 3 2 3 3 6 5 5 3 1 5 6 2
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt(); // 6
    m = sc.nextInt(); // 11
    start = sc.nextInt(); // 1

    for (int i = 0; i <= n; i++) { // i <= n 주의!
      adjList.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      adjList.get(a).add(new Node(b, c));
    }
    minDistance = new int[n + 1];
    Arrays.fill(minDistance, Integer.MAX_VALUE);

    dijkstra();

    for (int i = 1; i <= n; i++) {
      if (minDistance[i] == Integer.MAX_VALUE) {
        System.out.println("무한");
      } else {
        System.out.println(minDistance[i]);
      }
    }
  }

  private static void dijkstra() {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(start, 0));
    minDistance[start] = 0;

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      int startIndex = node.getIndex();
      int distance = node.getDistance();

      if (minDistance[startIndex] < distance) continue;

      for (int i = 0; i < adjList.get(startIndex).size(); i++) {
        int sumDistance = minDistance[startIndex] + adjList.get(startIndex).get(i).getDistance();
        int endIndex = adjList.get(startIndex).get(i).getIndex();

        if (sumDistance < minDistance[endIndex]) {
          minDistance[endIndex] = sumDistance;
          pq.offer(new Node(endIndex, sumDistance));
        }
      }
    }
  }
}
























