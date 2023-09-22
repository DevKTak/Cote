package fastcampus.실강.이진탐색;

public class 랜선자르기 {

	public int solution(int[] nums, int n) {
		// sort는 시간복잡도가 O(NlogN) 이기때문에 right 인 최대값을 찾기 위해 아래와 같이 하는게 낫다.
		// Arrays.sort(nums);

		int left = 0;
		int right = 0;
		for (int x : nums)
			right = Math.max(right, x); // O(logN)

		int answer = 0;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (getCntSum(mid, nums) >= n) {
				answer = mid;
				left = mid + 1;
			} else {
				right = right - 1;
			}
		}
		return answer;
	}

	private int getCntSum(int mid, int[] nums) {
		int cnt = 0;

		for (int num : nums) {
			cnt += num / mid;
		}
		return cnt;
	}

	public static void main(String[] args) {
		랜선자르기 T = new 랜선자르기();
		System.out.println(T.solution(new int[] {802, 743, 457, 539}, 11));
		System.out.println(T.solution(new int[] {8593, 9617, 9313, 4513, 7505, 5457, 8257, 4689, 2657}, 100));
		System.out.println(T.solution(new int[] {93, 97, 93, 53, 75, 57, 85, 89, 67}, 30));
	}
}
