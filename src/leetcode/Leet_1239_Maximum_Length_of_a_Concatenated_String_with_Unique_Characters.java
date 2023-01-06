package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet_1239_Maximum_Length_of_a_Concatenated_String_with_Unique_Characters {

    public static void main(String[] args) {
//        System.out.println(maxLength(Arrays.asList("un", "iq", "ue")));
//        System.out.println(maxLength(Arrays.asList("cha", "r", "act", "ers")));
//        System.out.println(maxLength(Arrays.asList("sateasteastseateaste222wtw")));

        List<String> list = new ArrayList<>();
        list.add("un");
        list.add("iq");
        list.add("ue");
        System.out.println(maxLength(list));
    }

    private static int maxLength(List<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i);
            char[] chars = s.toCharArray();

            boolean flag = false;

            for (int j = 0; j < chars.length - 1; j++) {
                for (int k = j + 1; k < chars.length; k++) {
                    if (chars[j] == chars[k]) {
                        flag = true;
                    }
                }
            }

            if (flag) {
                arr.remove(i);
                i--;
            }
        }

        if (arr.size() == 0) {
            return 0;
        }

        int maxLength = arr.get(0).length();

        for (int i = 0; i < arr.size() - 1; i++) {
            String s1 = arr.get(i);
            String s2 = arr.get(i + 1);

            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();

            boolean flag = false;

            for (char char1 : chars1) {
                for (char char2 : chars2) {
                    if (char1 == char2) {
                        flag = true;
                    }
                }
            }

            if (!flag) {
                maxLength = Math.max(maxLength, (s1 + s2).length());
            }
        }

        return maxLength;
    }
}
