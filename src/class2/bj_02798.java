package class2;

import java.util.Scanner;

public class bj_02798 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        int N = scanner.nextInt();
        int arr[] = new int[T];

        for (int i = 0; i < T; i++) {
            arr[i] = scanner.nextInt();
        }

        int maxSum = Integer.MIN_VALUE;
        int temp = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    temp = arr[i] + arr[j] + arr[k];

                    if (temp <= N && temp > maxSum) {
                        maxSum = temp;
                    }
                }
            }
        }

        System.out.println(maxSum);
    }
}
