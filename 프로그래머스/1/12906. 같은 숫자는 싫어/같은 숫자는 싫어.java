import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
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