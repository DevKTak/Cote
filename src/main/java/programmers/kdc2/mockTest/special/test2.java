package programmers.kdc2.mockTest.special;

import java.util.PriorityQueue;

public class test2 {

  static class Node implements Comparable<Node> {

    private int time;
    private String name;
    private boolean priority;

    public Node(int time, String name, boolean priority) {
      this.time = time;
      this.name = name;
      this.priority = priority;
    }

    @Override
    public int compareTo(Node node) {
//      return this.time.compareTo(node.time);
      return this.time <= node.time ? -1 : 1;
    }

    @Override
    public String toString() {
      return "Node{" +
         "time=" + time +
         ", name='" + name + '\'' +
         ", priority=" + priority +
         '}';
    }
  }

  public static void main(String[] args) {
    System.out.println(solution(new String[][]{{"09:09", "lee"}, {"09:11", "lee"}}, new String[][]{{"09:00", "kim"}, {"08:59", "bae"}, {"07:20", "lee"}}));
  }

  private static String[] solution(String[][] booked, String[][] unbooked) {
    PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

    for (int i = 0; i < unbooked.length; i++) {
      priorityQueue.add(new Node(stringToInt(unbooked[i][0]), unbooked[i][1], false));
    }
    for (int i = 0; i < booked.length; i++) {
      priorityQueue.add(new Node(stringToInt(booked[i][0]), booked[i][1], true));
    }


    for (Node node : priorityQueue) {
      System.out.println(node);
    }

    return new String[]{};
  }

  private static int stringToInt(String s) {
    String[] split = s.split(":");
    int x = Integer.parseInt(split[0]) < 10 ? Integer.parseInt(split[0].substring(1)) : Integer.parseInt(split[0]);
    return x * 60 + Integer.parseInt(split[1]);
  }
}
