package class2;

import java.util.Scanner;

public class bj_01085 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        int xSub = w - x < x - 0 ? w - x : x - 0;
        int ySub = h - y < y - 0 ? h - y : y - 0;

        System.out.println(xSub < ySub ? xSub : ySub);

    }
}
