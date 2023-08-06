package fastcampus.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class pro_게임맵최단거리 {

	private static class Pair {

		private int x;
		private int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		int[][] maps = {{1, 0, 1, 1, 1},
			{1, 0, 1, 0, 1},
			{1, 0, 1, 1, 1},
			{1, 1, 1, 0, 1},
			{0, 0, 0, 0, 1}};
		System.out.println(solution(maps));
	}

	public static int solution(int[][] maps) {
		int[][] checkedAndCnt = new int[maps.length][maps[0].length];

		// 상, 하, 좌, 우
		int[] dx = {-1, 1, 0, 0}; // 행
		int[] dy = {0, 0, -1, 1}; // 열

		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(0, 0));
		checkedAndCnt[0][0] = 1;

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = pair.x + dx[i];
				int ny = pair.y + dy[i];

				if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length) { // 맵 범위 안에 해당되면
					if (maps[nx][ny] == 1 && checkedAndCnt[nx][ny] == 0) { // 벽이 없는 자리이면서 방문했던곳이 아니면
						checkedAndCnt[nx][ny] = checkedAndCnt[pair.x][pair.y] + 1;
						queue.offer(new Pair(nx, ny));
					}
				}
			}
		}
		int result = checkedAndCnt[maps.length - 1][maps[0].length - 1];

		return result == 0 ? -1 : result;
	}
}
