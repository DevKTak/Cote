package boj.class1;

import java.util.Scanner;

public class bj_01546 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        int arr[] = new int[N];
        double sum = 0.0d;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            sum += ((double) arr[i] / max) * 100;
        }

        System.out.println(sum / N);
    }
}
