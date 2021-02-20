package class1;

import java.util.Scanner;

public class bj_02438 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();

        for (int i = 1; i <= N; i++) {
            for (int j = N - i; j < N; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

