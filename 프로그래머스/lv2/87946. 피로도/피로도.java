class Solution {
   int maxCnt = 0;
	boolean[] visited;

	public int solution(int k, int[][] dungeons) {
		visited = new boolean[dungeons.length];

		dfs(0, k, dungeons);

		return maxCnt;
	}

	private void dfs(int L, int k, int[][] dungeons) {
		for (int i = 0; i < dungeons.length; i++) {
			if (!visited[i] && dungeons[i][0] <= k) { // visited[i]에 방문한적이 없고 피로도 조건이 맞으면
				visited[i] = true;

				dfs(L + 1, k - dungeons[i][1], dungeons);
				visited[i] = false;
			}
			maxCnt = Math.max(maxCnt, L);
		}
	}
}