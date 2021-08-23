package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {

  public static void main(String[] args) {
    int[] priorities = {2, 1, 9, 1, 9, 1};
    int location = 1;
    System.out.println(solution(priorities, location)); // 4
  }

  private static int solution(int[] priorities, int location) {
    Queue<Integer> queue = new LinkedList<>();

    for (int v : priorities) {
      queue.add(v);
    }

    while (true) {
      int front = queue.peek();
      boolean isGreaterThan = false;

      for (int v : queue) {
        if (front < v) {
          queue.add(queue.poll());
          isGreaterThan = true;
          location--;

//          if (location < 0) {
//            location += priorities.length;
//          }
          break;
        }
      }

      if (!isGreaterThan) {
        break;
      }
    }

    return location < 0 ? priorities.length - 2 : location;
  }
}



















