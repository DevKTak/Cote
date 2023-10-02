package fastcampus.실강.DFS;

import java.util.ArrayList;
import java.util.List;

public class 피로도 {

	public static void main(String[] args) {
		피로도 T = new 피로도();
		System.out.println(T.solution(80, new int[][] {{80, 20}, {50, 40}, {30, 10}}));
	}

	int maxSum = 0;
	List<Integer> list = new ArrayList<>();

	public int solution(int k, int[][] dungeons) {

		int curStatus;

		for (int i = 0; i < dungeons.length; i++) {
			boolean[] ch = new boolean[dungeons.length];
			curStatus = k;
			ch[i] = true;
			maxSum = 0;

			if (curStatus >= dungeons[i][0]) {
				curStatus -= dungeons[i][1];
				maxSum++;
			}
			dfs(curStatus, dungeons, ch);
			list.add(maxSum);
		}
		return maxSum;
	}

	private void dfs(int curStatus, int[][] dungeons, boolean[] ch) {
		for (int i = 0; i < dungeons.length; i++) {
			if (!ch[i]) {
				ch[i] = true;

				if (curStatus >= dungeons[i][0]) {
					curStatus -= dungeons[i][1];
					maxSum++;
				}
				dfs(curStatus, dungeons, ch);
			}
		}
	}
}
