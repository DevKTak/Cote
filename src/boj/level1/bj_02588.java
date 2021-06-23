package boj.level1;

import java.util.Scanner;

public class bj_02588 {

    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int A = sc.nextInt();
        String B = sc.next();

        System.out.println(A * Integer.parseInt(B.substring(2, 3)));
        System.out.println(A * Integer.parseInt(B.substring(1, 2)));
        System.out.println(A * Integer.parseInt(B.substring(0, 1)));
        System.out.println(A * Integer.parseInt(B));
    }
}
