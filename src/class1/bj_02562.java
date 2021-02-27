package class1;

import java.util.Scanner;

public class bj_02562 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int arr[] = new int[9];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        int index = 0;
        int max = arr[0];

        for (int i = 0 + 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                index = i;
            }
        }

        System.out.println(max);
        System.out.println(index + 1);
    }
}
