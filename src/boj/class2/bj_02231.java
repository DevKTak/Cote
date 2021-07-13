package boj.class2;

import java.util.Scanner;

public class bj_02231 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        int length = String.valueOf(N).length();
        int sum = 0;
        int answer = 0;

        for (int i = N - (length * 9); i < N; i++) {
            sum = i;
            int tempI = i;

            while (tempI != 0) {
                sum += tempI % 10;
                tempI /= 10;

            }

            if (sum == N) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
