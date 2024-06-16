import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
      	Stack<Integer> stack = new Stack<>();
		int count = 0;

		for (int value : ingredient) {
			stack.push(value);

			if (stack.size() >= 4) {
				if (stack.get(stack.size() - 1) == 1 && stack.get(stack.size() - 2) == 3
					&& stack.get(stack.size() - 3) == 2 && stack.get(stack.size() - 4) == 1) {
					count++;

					for (int i = 0; i < 4; i++) {
						stack.pop();
					}
				}
			}
		}
		return count;
    }
}