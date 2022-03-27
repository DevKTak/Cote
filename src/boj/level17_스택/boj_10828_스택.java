package boj.level17_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_10828_스택 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "top":
                    System.out.println(stack.isEmpty() ? -1 : stack.peek());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                case "pop":
                    System.out.println(stack.isEmpty() ? -1 : stack.pop());
                    break;
            }
        }
    }
}
