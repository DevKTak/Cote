package fastcampus.실강.이진탐색;

// O(logN)
public class 이진탐색 {

	public int solution(int[] nums, int target) {
		int answer = -1;
		int left = 0, right = nums.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		이진탐색 T = new 이진탐색();
		System.out.println(T.solution(new int[] {2, 5, 7, 8, 10, 15, 20, 24, 25, 30}, 8));
		System.out.println(T.solution(new int[] {-3, 0, 2, 5, 8, 9, 12, 15}, 0));
	}
}
