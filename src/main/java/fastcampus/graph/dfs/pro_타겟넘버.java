package fastcampus.graph.dfs;

public class pro_타겟넘버 {

	private static int cnt = 0;

	public static void main(String[] args) {
		System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
	}

	private static int solution(int[] numbers, int target) {
		recursion(numbers, 0, 0, target);

		return cnt;
	}

	private static void recursion(int[] numbers, int index, int sum, int target) {
		if (index == numbers.length) {
			if (sum == target) {
				cnt++;
			}
			return;
		}
		recursion(numbers, index + 1, sum + numbers[index], target);
		recursion(numbers, index + 1, sum - numbers[index], target);

	}
}
