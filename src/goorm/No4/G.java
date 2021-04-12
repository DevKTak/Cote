package goorm.No4;

import java.util.Scanner;

public class G {

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt(); // 배열 크기
        int M = scanner.nextInt(); // 명령어의 수
        int[] arr = new int[N];
        int pointer = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < M; i++) {
            int operator = scanner.nextInt();
            int k = 0;

            if (operator != 3) {
               k  = scanner.nextInt();
            }

            if (operator == 0) {
                System.out.println(arr[(pointer + k) % N]);
            } else if (operator == 1) {
                pointer = (pointer + k) % N;
            } else if (operator == 2) {
                pointer = (pointer - k + N) % N;
            } else if (operator == 3) {
                pointer = 0;
            }
        }
    }
}
