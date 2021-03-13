package class2;

import java.util.Arrays;
import java.util.Scanner;

public class bj_01018 {

    static final Scanner scanner = new Scanner(System.in);
    public static boolean[][] arr;
    public static int minCnt = 64;

    public static void main(String[] args) {
        int N = scanner.nextInt(); // 세로
        int M = scanner.nextInt(); // 가로
        arr = new boolean[N][M];

        scanner.nextLine();

        /** 입력 **/
        for (int i = 0; i < N; i++) {
            String str = scanner.nextLine();

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true;
                } // 'B' 일 때는 기본값 false
            }
        }

        int height = N - 7; // 세로 경우의 수
        int with = M - 7; // 가로 경우의 수

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < with; j++) {
                getMinCnt(i, j);
            }
        }

        System.out.println(minCnt);
    }

    /**
     * 8 X 8 영역을 돌며 다시 칠해야하는 정사각형 갯수 체크
     *
     * @param i: 세로 for 문
     * @param j: 가로 for 문
     */
    private static void getMinCnt(int i, int j) {
        int count = 0;
        boolean current = arr[i][j]; // 최초 좌측위 꼭지점 비교를 위한 초기값

        for (int k = i; k < i + 8; k++) {
            for (int l = j; l < j + 8; l++) {
                current = !current;

                if (current == arr[k][l]) {
                    count++;
                }
            }
            current = !current; // 다음 줄로 넘어갈 때 반대 색으로 변경
        }
        count = Math.min(count, 64 - count); // 시작을 B로 할 수도 있고 W로 할 수도 있기 때문에
                                             // 반대케이스는 전체갯수인 64에서 count를 빼준다
        minCnt = Math.min(minCnt, count); // 다른 체스판과 최솟값을 비교한다
    }
}
