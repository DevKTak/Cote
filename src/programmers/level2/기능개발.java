package programmers.level2;

import java.util.*;

public class 기능개발 {

  public static void main(String[] args) {
    int[] progresses = {93, 30, 55};
    int[] speeds = {1, 30, 5};
    System.out.println(Arrays.toString(solution(progresses, speeds)));
  }

  private static int[] solution(int[] progresses, int[] speeds) {
    Queue<Integer> queue = new LinkedList<>();

    /** 남은 작업 일로 큐 채우기 **/
    for (int i = 0; i < progresses.length; i++) {
      int remainingWork = 100 - progresses[i]; // 남은 작업 양
      int quotient = remainingWork / speeds[i]; // 몫
      boolean isRemainder = remainingWork % speeds[i] > 0; // 나머지가 있는지 여부
      queue.add(isRemainder ? quotient + 1 : quotient);
    }
    List<Integer> list = new ArrayList<>();
    int cnt = 0;
    int preMaxPoll = queue.peek();

    while (!queue.isEmpty()) {
      int curPoll = queue.peek();
      System.out.println("queue = " + queue);

      if (preMaxPoll >= curPoll) { // 앞에 있는 기능이 배포될 때 까지 배포 불가
        cnt++;
        preMaxPoll = preMaxPoll > curPoll ? preMaxPoll : curPoll;
        queue.poll();
      } else {
        list.add(cnt);
        cnt = 1;
        preMaxPoll = queue.poll();
      }
    }
    list.add(cnt);
    int[] answer = new int[list.size()];

    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }
    String[] s = {"0_-"};
    Arrays.sort(s);
    System.out.println(Arrays.toString(s));
    return answer;
  }
}
