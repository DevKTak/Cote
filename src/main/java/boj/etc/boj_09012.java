package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_09012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Stack<Character> stack;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            stack = new Stack<>();
            st = new StringTokenizer(br.readLine());

            char[] arr = st.nextToken().toCharArray();

            System.out.println(solve(arr, stack));
        }
    }

    private static String solve(char[] arr, Stack<Character> stack) {
        for (char c : arr) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) { // pop 할 원소가 없을 경우
                    return "NO";
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            return "YES";
        } else { // 여는괄호가 남은 경우
            return "NO";
        }
    }
}
