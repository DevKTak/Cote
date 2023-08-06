package fastcampus.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 바이러스
 */
public class boj_02606_바이러스 {

	private static Set<Integer> visited = new HashSet<>();
	private static List<List<Integer>> adList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			adList.add(new ArrayList<>());
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			adList.get(start).add(end);
			adList.get(end).add(start);
		}
		System.out.println(bfs(1));
	}

	private static int bfs(int startVertex) {
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<>();
		visited.add(startVertex);
		queue.offer(startVertex);

		while (!queue.isEmpty()) {

			Integer poll = queue.poll();
			for (int curVertex : adList.get(poll)) {
				if (!visited.contains(curVertex)) {
					cnt++;
					visited.add(curVertex);
					queue.offer(curVertex);
				}
			}
		}
		return cnt;
	}
}
