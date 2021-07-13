package boj.class1;

import java.util.Scanner;

public class bj_10951 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (scanner.hasNextInt()) {
            System.out.println(scanner.nextInt() + scanner.nextInt());
        }
    }
}
