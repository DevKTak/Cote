import java.util.*;

class Solution
{
    public int solution(String s)
    {
     	Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();

		for (char c : chars) {
			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty() ? 1 : 0;
    }
}