package boj.level17_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_10773_제로 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if (num != 0) {
                stack.push(num);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        int sum = 0;

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
