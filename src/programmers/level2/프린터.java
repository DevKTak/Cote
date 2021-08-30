package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {

  public static void main(String[] args) {
    int[] priorities = {2, 1, 9, 1, 9, 1};
    int location = 1;
    프린터 printer = new 프린터();
    System.out.println(printer.solution(priorities, location)); // 4
  }

  class Priority {
    int priority;
    int location;

    public Priority(int priority, int location) {
      this.priority = priority;
      this.location = location;
    }
  }

  private int solution(int[] priorities, int location) {
    Queue<Priority> queue = new LinkedList<>();

    for (int i = 0; i < priorities.length; i++) {
      queue.add(new Priority(priorities[i], i));
    }
    int index = 0;

    while (!queue.isEmpty()) {
      Priority frontPriority = queue.poll();
      boolean greaterThan = false;

      for (Priority curPriority : queue) {
        if (frontPriority.priority < curPriority.priority) {
          greaterThan = true;
          break;
        }
      }

      if (greaterThan) {
        queue.add(frontPriority);
      } else {
        index++;

        if (frontPriority.location == location) {
          break;
        }
      }
    }

    return index;
  }
}



















