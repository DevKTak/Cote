package boj.level2;

import java.util.Scanner;

public class bj_14681 {

    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        int result = 0;

        if (x > 0 && y > 0) {
            result = 1;
        } else if (x < 0 && y > 0) {
            result = 2;
        } else if (x < 0 && y < 0) {
            result = 3;
        } else {
            result = 4;
        }

        System.out.println(result);
    }
}
