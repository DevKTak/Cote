package boj.class1;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj_01152 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(s, " ");

        System.out.println(st.countTokens());

//        while (st.hasMoreTokens()) {
//            System.out.println(st.nextToken());
//        }
    }
}
