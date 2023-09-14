class Solution {
    public int solution(int n) {
    	int nextNum = n;
		int nextOneCnt;
		int curOneCnt = Integer.bitCount(n);

		while (true) {
			nextNum++;
			nextOneCnt = Integer.bitCount(nextNum);

			if (curOneCnt == nextOneCnt) {
				break;
			}
		}
		return nextNum;
    }
}