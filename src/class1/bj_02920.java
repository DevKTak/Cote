package class1;

import java.util.Arrays;
import java.util.Scanner;

public class bj_02920 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int arr[] = new int[8];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        String msg ="";

        for (int temp : arr) {
            msg += temp;
        }

        if (msg.equals("12345678")) {
            System.out.println("ascending");
        } else if(msg.equals("87654321")) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
