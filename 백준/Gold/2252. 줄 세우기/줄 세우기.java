

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 줄 세우기
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<List<Integer>> adList = new ArrayList<>();
		for (int i = 0; i <= N; i++) { // 0번은 사용하지 않음
			adList.add(new ArrayList<>());
		}


		int[] indegree = new int[N + 1]; // 진입 차수
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adList.get(start).add(end); // start: 앞에 학생, end: 뒤에 학생
			indegree[end]++; // 뒤에 학생의 진입 차수 증가
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < indegree.length; i++) {
			if (indegree[i] == 0) { // 간접 차수가 0인 vertex 는 큐에 넣기
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int curVertex = queue.poll();
			bw.write(curVertex + " ");
			List<Integer> ends = adList.get(curVertex); // ends: 뒤에 학생들

			for (int i = 0; i < ends.size(); i++) {
				int end = ends.get(i);
				indegree[end]--; // curVertex 보다 뒤에 서야하는 학생들 진입차수 감소

				if (indegree[end] == 0) { // 진입 차수가 0이 된 vertex(뒤에 서야했던 학생)
					queue.offer(end); // 큐에 넣기
				}
			}
		}
		bw.flush();
		bw.close();
	}
}
