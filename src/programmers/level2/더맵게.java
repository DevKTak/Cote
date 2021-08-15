package programmers.level2;

import utilTak.PriorityQueueTak;

import java.util.PriorityQueue;

public class 더맵게 {

  public static void main(String[] args) {
    int[] scoville = {1, 2, 3, 9, 10, 12};
    int K = 7;
    System.out.println(solution(scoville, K));
  }

  private static int solution(int[] scoville, int K) {
       /* PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;

        for (int sco : scoville) {
            pq.add(sco);
        }

        for (int i = 0; i < scoville.length - 1; i++) {
            if (pq.peek() > K) {
                return cnt;
            } else {
                int firstMin = pq.poll();
                int secondMin = pq.poll();
                pq.add(firstMin + (secondMin * 2));
                cnt++;
            }
        }

        return pq.peek() > K ? cnt : -1;*/

    PriorityQueueTak pqt = new PriorityQueueTak();
    int cnt = 0;

    for (int sco : scoville) {
      pqt.addTak(sco);
    }

    for (int i = 0; i < scoville.length - 1; i++) {
      if (pqt.peekTak() > K) {
        return cnt;
      } else {
        int firstMin = pqt.pollTak();
        int secondMin = pqt.pollTak();
        pqt.addTak(firstMin + (secondMin * 2));
        cnt++;
      }
    }

    return pqt.peekTak() > K ? cnt : -1;
  }
}
