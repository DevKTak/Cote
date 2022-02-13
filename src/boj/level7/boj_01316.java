package boj.level7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 그룹 단어 체커 */
public class boj_01316 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 0; i < N; i++) {
            count += isGroupWord(sc.next());
        }
        System.out.println(count);
    }

    private static int isGroupWord(String str) {
        List<Character> list = new ArrayList<>();
        list.add(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            char character = str.charAt(i);
            char beforeCharacter = str.charAt(i - 1);

            if (list.contains(character) && character != beforeCharacter) { // 리스트에 포함되어있으면서 바로 전 문자와는 다르다면 그룹단어가 아님
                return 0;
            }
            list.add(character);
        }

        return 1;
    }
}
