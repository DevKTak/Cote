package programmers.kit.stackandqueue;

import java.util.Arrays;
import java.util.LinkedList;

public class 같은숫자는싫어 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {1, 1, 3, 3, 0, 1, 1})));
	}

	private static int[] solution(int[] arr) {
		LinkedList<Integer> queue = new LinkedList<>();

		for (int i : arr) {
			if (queue.isEmpty() || queue.peekLast() != i) {
				queue.offer(i);
			}
		}
		int[] result = new int[queue.size()];

		for (int i = 0; i < result.length; i++) {
			result[i] = queue.poll();
		}
		return result;
	}
}
