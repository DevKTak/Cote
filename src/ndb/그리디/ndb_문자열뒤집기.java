package ndb.그리디;

import java.util.Scanner;

public class ndb_문자열뒤집기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int cnt0 = 0;
        int cnt1 = 0;

        // 첫 번째 원소에 대한 처리
        if (s.charAt(0) == '0') {
            cnt0++;
        } else {
            cnt1++;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            // 값이 0 -> 1 또는 1 -> 0 변경되는 경우
            if (s.charAt(i) != s.charAt(i + 1)) {
                if (s.charAt(i + 1) == '0') {
                    cnt0++;
                } else {
                    cnt1++;
                }
            }
        }
        System.out.println(Math.min(cnt0, cnt1));
    }
}
