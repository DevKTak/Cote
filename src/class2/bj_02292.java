package class2;

import java.util.Scanner;

public class bj_02292 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        int distance = 1;
        int frontNumber = 2;

        if (N == 1) {
        } else {
            while (frontNumber <= N) {
                frontNumber = frontNumber + (distance * 6); // 2, 8, 20, 38, 62
                distance++;
            }
        }

        System.out.println(distance);
    }
}
