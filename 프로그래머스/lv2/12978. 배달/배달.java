import java.util.*;

class Solution {

    class Node implements Comparable<Node> {

		int vertex;
		int time;

		public Node(int vertex, int time) {
			this.vertex = vertex;
			this.time = time;
		}

		public int getVertex() {
			return vertex;
		}

		public int getTime() {
			return time;
		}

		@Override
		public int compareTo(Node node) {
			return this.time - node.getTime();
		}
	}
    
    public int solution(int N, int[][] road, int K) {
  	// 정점까지의 최단거리 갱신할 배열 초기화
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		// 인접리스트 만들기
		List<List<Node>> adList = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			adList.add(new ArrayList<>());
		}
		for (int[] info : road) {
			adList.get(info[0]).add(new Node(info[1], info[2]));
			adList.get(info[1]).add(new Node(info[0], info[2]));
		}
		dijkstra(dist, adList);

		int cnt = 0;
		
		for (int time : dist) {
			if (time <= K) {
				cnt++;
			}
		}
		return cnt;
    }
    
    private void dijkstra(int[] dist, List<List<Node>> adList) {
		// 배열이 갱신될 때마다 넣어 놓을 우선순위 큐 만들기 (최단거리기준 오름차순)
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0)); // 정점 1 까지의 거리는 0 부터 시작
		dist[1] = 0; // 정점 1까지의 최단거리 배열 갱신

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int curVertex = curNode.getVertex();
			int curTime = curNode.getTime();

			// 최단거리 테이블에 갱신되어 있는 값이 큐에 있던 Node의 거리보다 적으면 탐색할 필요 X
			if (curTime > dist[curVertex]) {
				continue;
			}

			// 탐색
			for (Node node : adList.get(curVertex)) {

				// 최단거리 테이블에 있는 node.vertex 정점까지의 값이
				// (현재 정점까지의 거리(curTime) + 탐색하려는 인접 노드까지의 거리(node.time)) 보다 크면 갱신
				if (dist[node.vertex] > curTime + node.time) {
					dist[node.vertex] = curTime + node.time; // 갱신
					pq.offer(new Node(node.vertex, dist[node.vertex])); // 갱신된 노드 값 큐에도 추가
				}
			}
		}
	}
}