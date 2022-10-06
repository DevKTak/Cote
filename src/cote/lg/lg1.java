package cote.lg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class lg1 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{112, 1814, 121, 1481, 1184}));
    }

    private static int solution(int[] arr) {
        Set<String> set = new HashSet<>();
        String[] strArr = new String[arr.length];

        for(int i = 0; i < arr.length; i++) {
            strArr[i] = String.valueOf(arr[i]);
        }

        for (String str : strArr) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            set.add(new String(chars));
        }

        return set.size();
    }
}
