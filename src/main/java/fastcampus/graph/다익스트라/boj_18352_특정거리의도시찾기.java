package fastcampus.graph.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_18352_특정거리의도시찾기 {

	static class Vertex implements Comparable<Vertex> {

		private final int index;
		private final int distance;

		public Vertex(int index, int distance) {
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
		public int compareTo(Vertex o) {
			return this.distance - o.distance;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 도시의 개수
		int M = Integer.parseInt(st.nextToken()); // 도로의 개수
		int X = Integer.parseInt(st.nextToken()); // 거리 정보
		int K = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

		int[] minDistance = new int[N + 1];
		Arrays.fill(minDistance, (int)1e9);

		List<List<Vertex>> adList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adList.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			adList.get(start).add(new Vertex(end, 1));
		}

		dijkstra(adList, minDistance, K);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			if (minDistance[i] == X) {
				sb.append(i).append(System.lineSeparator());
			}
		}
		System.out.println(sb.length() == 0 ? -1 : sb);
	}

	private static void dijkstra(List<List<Vertex>> adList, int[] minDistance, int startVertex) {
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.add(new Vertex(startVertex, 0));
		minDistance[startVertex] = 0;

		while (!pq.isEmpty()) {
			Vertex poll = pq.poll();
			int index = poll.getIndex();
			int distance = poll.getDistance();

			if (minDistance[index] < distance) {
				continue;
			}

			for (Vertex vertex : adList.get(index)) {
				int sumDistance = minDistance[index] + vertex.getDistance();

				if (sumDistance < minDistance[vertex.getIndex()]) {
					minDistance[vertex.getIndex()] = sumDistance;
					pq.offer(new Vertex(vertex.getIndex(), sumDistance));
				}
			}
		}
	}
}
