package boj.class2;

import java.util.Scanner;

public class bj_02775 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int arr[][] = new int[15][15];

        // 1층과 1열 기본값 셋팅
        for (int i = 1; i < arr.length; i++) {
            arr[0][i] = i;
            arr[i][1] = 1;
        }

        // 1층과 1열을 제외한 값 셋팅
        for (int i = 1; i < arr.length; i++) {
            for (int j = 2; j < arr.length; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            System.out.println(arr[scanner.nextInt()][scanner.nextInt()]);
        }
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
