package boj.level1;

import java.util.Scanner;

public class boj_10430 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        System.out.println((A + B) % C);
        System.out.println(((A % C) + (B % C)) % C);
        System.out.println((A * B) % C);
        System.out.println(((A % C) * (B % C)) % C);
    }
}
