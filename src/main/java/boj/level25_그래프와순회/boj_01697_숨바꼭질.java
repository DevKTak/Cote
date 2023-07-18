package boj.level25_그래프와순회;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 숨바꼭질
 */
public class boj_01697_숨바꼭질 {

    private static int K;
    private static int[] check = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        K = sc.nextInt();

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
    }

    private static void bfs(int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        // 시작을 0으로 초기화 하고싶었는데 입력데이터 0 2 넣어보면 예외케이스 발생
        check[N] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < 3; i++) {
                int sum = 0;

                switch (i) {
                    case 0:
                        sum = multiply(cur);
                        break;
                    case 1:
                        sum = add(cur);
                        break;
                    case 2:
                        sum = subtract(cur);
                        break;
                }

                if (sum == K) {
                    System.out.println(check[cur]);
                    return;
                }

                // check[sum] == 0 이전에 방문한 이력이 없는지 검사 안하면 메모리초과!
                if (0 <= sum && sum < check.length && check[sum] == 0) {
                    queue.offer(sum);
                    check[sum] = check[cur] + 1;
                }
            }
        }

    }

    private static int multiply(int cur) {
        return cur * 2;
    }

    private static int add(int cur) {
        return cur + 1;
    }

    private static int subtract(int cur) {
        return cur - 1;
    }
}
