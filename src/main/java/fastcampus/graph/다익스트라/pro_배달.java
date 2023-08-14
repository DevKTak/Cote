package fastcampus.graph.다익스트라;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 배달
 */
public class pro_배달 {

	static class Vertex implements Comparable<Vertex> {

		private final int index;
		private final int time;

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
			return this.time - vertex.time; // 배달 시간이 짧은 순으로 오른차순 정렬
		}
	}

	public static void main(String[] args) {
		System.out.println(
			solution(5, new int[][] {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
	}

	public static int solution(int N, int[][] road, int K) {
		final int INF = (int)1e9; // 무한대
		int[] minTime = new int[N + 1];
		List<List<Vertex>> adList = new ArrayList<>();

		Arrays.fill(minTime, INF); // 최단시간을 넣을 배열값 무한 값으로 초기화

		for (int i = 0; i <= N; i++) {
			adList.add(new ArrayList<>()); // 인접 리스트 초기화
		}

		// 양방향 인접 리스트 만들기
		for (int[] arr : road) {
			adList.get(arr[0]).add(new Vertex(arr[1], arr[2])); // arr[0] 마을에서 arr[1] 마을까지 arr[2]의 배달 시간이 걸린다
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
		pq.offer(new Vertex(1, 0)); // 1번 마을에서 시작이고 1번 마을까지 배달 시간은 0 셋팅
		minTime[1] = 0;

		while (!pq.isEmpty()) {
			Vertex poll = pq.poll();
			int index = poll.getIndex();

			// 최단시간 테이블에 갱신되어 있는 값이 우선순위큐에 들어있어 있던 시간보다 작다면 이미 처리된 마을!!
			if (minTime[index] < poll.getTime()) {
				continue;
			}

			// 인접 마을들을 검사
			for (Vertex vertex : adList.get(index)) {
				int sumTime = minTime[index] + vertex.getTime();
				int adIndex = vertex.getIndex();

				// 인접 마을까지의 최단시간 테이블에 있던 값이 현재 마을을 거쳐 인접마을 까지 걸리는 시간보다 클 경우
				if (minTime[adIndex] > sumTime) {
					minTime[adIndex] = sumTime; // 최단시간 테이블 갱신
					pq.offer(new Vertex(adIndex, sumTime)); // 우선순위 큐에 넣기
				}
			}
		}
	}
}
