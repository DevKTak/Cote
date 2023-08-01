package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_10773 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Stack<Integer> stack = new Stack<>();
		int k = Integer.parseInt(br.readLine());

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			if (n != 0) {
				stack.push(n);
			} else {
				stack.pop();
			}
		}
		System.out.println(stack.stream().mapToInt(v -> v).sum());
	}
}
