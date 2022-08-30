package codility.Lesson7_Stacks_and_Queues;

import java.util.Stack;

public class Fish {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,3,2,1,5}, new int[]{0,1,0,0,0})); // 2
    }

    public static int solution(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        int upCnt = 0;

        for (int i = 0; i < A.length; i++) {
            if (B[i] == 0) { // 0: 상류(up)
                while (!stack.isEmpty() && stack.peek() < A[i]) { // 하류 가던애가 상류 가던애 보다 작으면
                    stack.pop(); // 하류 가던애 제거
                }

                if (stack.isEmpty()) {
                    upCnt++;
                }
            } else { // 1: 하류(down)
                stack.add(A[i]);
            }
        }

        return stack.size() + upCnt;
    }
}
