package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리_트리_level {
	public static void main(String[] args) {
		int[][] maps = {{1, 0, 1, 1, 1},
			{1, 0, 1, 0, 1},
			{1, 0, 1, 1, 1},
			{1, 1, 1, 0, 1},
			{0, 0, 0, 0, 1}};
		System.out.println(solution(maps));
	}

	private static int solution(int[][] maps) {
		// int n = maps.length; // 행
		// int m = maps[0].length; // 열
		// int[] dr = {-1, 0, 1, 0};
		// int[] dc = {0, 1, 0, -1};
		// Queue<int[]> queue = new LinkedList<>();
		// queue.offer(new int[] {0, 0});
		// maps[0][0] = 0;
		// int level = 1; // 시작이 1이기 때문
		//
		// while (!queue.isEmpty()) {
		// 	int len = queue.size();
		//
		// 	for (int i = 0; i < len; i++) {
		// 		int[] p = queue.poll();
		//
		// 		for (int j = 0; j < 4; j++) {
		// 			int nr = p[0] + dr[j];
		// 			int nc = p[1] + dc[j];
		//
		// 			if (nr == n - 1 && nc == m - 1) {
		//
		// 			}
		// 		}
		// 	}
		// }
		// return 0;
		int n = maps.length;
		int m = maps[0].length;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		Queue<int[]> Q = new LinkedList<>();
		Q.offer(new int[] {0, 0});
		int L = 1;
		while (!Q.isEmpty()) {
			int len = Q.size();

			for (int i = 0; i < len; i++) {
				int[] p = Q.poll();
				for (int k = 0; k < 4; k++) {
					int nx = p[0] + dx[k];
					int ny = p[1] + dy[k];
					if (nx == n - 1 && ny == m - 1)
						return L + 1;
					if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1) {
						maps[nx][ny] = 0;
						Q.offer(new int[] {nx, ny});
					}
				}
			}
			L++;
		}
		return -1;
	}
}
