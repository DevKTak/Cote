import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    
    static class Vertex implements Comparable<Vertex> {

		private int index;
		private int time;

		public Vertex(int index, int time) {
			this.index = index;
			this.time = time;
		}

		public int getIndex() {
			return index;
		}

		public int getTime() {
			return time;
		}

		@Override
		public int compareTo(Vertex vertex) {
			return this.time - vertex.time;
		}
	}
    
    public int solution(int N, int[][] road, int K) {
        final int INF = (int)1e9;
		int[] minTime = new int[N + 1];
		List<List<Vertex>> adList = new ArrayList<>();

		Arrays.fill(minTime, INF);

		for (int i = 0; i <= N; i++) {
			adList.add(new ArrayList<>());
		}

		for (int[] arr : road) {
			adList.get(arr[0]).add(new Vertex(arr[1], arr[2]));
			adList.get(arr[1]).add(new Vertex(arr[0], arr[2]));
		}
		dijkstra(minTime, adList);

		int cnt = 0;
		for (int time : minTime) {
			if (time <= K) {
				cnt++;
			}
		}
		return cnt;
    }
    
    private static void dijkstra(int[] minTime, List<List<Vertex>> adList) {
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(1, 0));
		minTime[1] = 0;

		while (!pq.isEmpty()) {
			Vertex poll = pq.poll();
			int index = poll.getIndex();
			int time = poll.getTime();

			if (minTime[index] < time) { // 이미 처리된 노드
				continue;
			}

			for (Vertex vertex : adList.get(index)) {
				int sumTime = minTime[index] + vertex.getTime();
				int adIndex = vertex.getIndex();
				
				if (minTime[adIndex] > sumTime) {
					minTime[adIndex] = sumTime;
					pq.offer(new Vertex(adIndex, sumTime));
				}
			}
		}
	}
}