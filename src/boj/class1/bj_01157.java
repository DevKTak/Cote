package boj.class1;

import java.util.Scanner;

public class bj_01157 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine().toUpperCase();
        int cnt[] = new int[26]; // A ~ Z
        int maxCnt = 0;
        char result = '?';

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 65]++;


            if (maxCnt < cnt[s.charAt(i) - 65]) {
                maxCnt = cnt[s.charAt(i) - 65];
                result = s.charAt(i);
            } else if (maxCnt == cnt[s.charAt(i) - 65]) {
                result = '?';
            }
        }

        System.out.println(result);
    }
}
