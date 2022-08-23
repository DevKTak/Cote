package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet_13_Roman_to_integer {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
//        System.out.println(romanToInt("III"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);

//        charMap.put("IV", 4);
//        charMap.put("IX", 9);
//        charMap.put("XL", 40);
//        charMap.put("XC", 90);
//        charMap.put("CD", 400);
//        charMap.put("CM", 900);

        char[] charArray = s.toCharArray();
        int sum = 0;

        for (int i = 0; i < charArray.length - 1; i++) {
            int curChar = charMap.get(charArray[i]);
            int nextChar = charMap.get(charArray[i + 1]);

            if (curChar < nextChar) {
                sum -= curChar;
            } else {
                sum += curChar;
            }
        }

        return sum + charMap.get(charArray[s.length() - 1]);
    }
}
