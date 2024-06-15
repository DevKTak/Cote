import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
 	    PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < scoville.length; i++) {
			pq.offer(scoville[i]);
		}
		int cnt = 0;

		while (pq.size() > 1 && pq.peek() < K) {
			int firstMin = pq.poll();
			int secondMin = pq.poll();

			pq.offer(firstMin + (secondMin * 2));
			cnt++;
		}

			return pq.peek() >= K ? cnt : -1;
    }
}