package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Router
public class boj_15828_Router {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int bufferSize = Integer.parseInt(br.readLine()); // 버퍼의 크기
		Queue<Integer> router = new LinkedList<>();

		while (true) {
			st = new StringTokenizer(br.readLine());
			int packet = Integer.parseInt(st.nextToken());

			if (packet == -1)
				break;

			if (packet == 0) {
				router.poll();
			}

			if (bufferSize == router.size()) { // 버퍼가 꽉 차있을 경우
				continue;
			}

			if (packet > 0) {
				router.offer(packet);
			}
		}

		if (router.isEmpty()) {
			System.out.println("empty");
			return;
		}
		router.forEach(v -> System.out.print(v + " "));
	}
}
