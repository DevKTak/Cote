package class2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class bj_04153 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        int arr[] = new int[3];
        int sum = -1;

        while (sum != 0) {
            for (int i = 0; i < arr.length; i++) {
                sum = 0;
                arr[i] = scanner.nextInt();
                sum += arr[i];
            }

            if (sum != 0) {
                Arrays.sort(arr);
                System.out.println(Math.pow(arr[0], 2) + Math.pow(arr[1], 2) == Math.pow(arr[2], 2) ? "right" : "wrong");
            }
        }
    }
}
