package programmers.level2;

import java.util.PriorityQueue;

public class 더맵게 {

    public static void main(String[] args) {
        int[] scoville = {0, 2};
        int K = 0;
        System.out.println(solution(scoville, K));
    }

    private static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
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

        return pq.peek() > K ? cnt : -1;
    }
}
