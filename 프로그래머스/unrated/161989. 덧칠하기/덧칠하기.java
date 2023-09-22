class Solution {
    public int solution(int n, int m, int[] section) {
      	int start = section[0];
		int end = start + m - 1;
		int cnt = 1;

		for (int part : section) {
			if (start <= part && part <= end) {
				continue;
			} else {
				cnt++;
				start = part;
				end = start + m - 1;
			}
		}
		return cnt;
    }
}