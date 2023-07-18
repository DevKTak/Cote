package boj.class1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mySolution(new int[] {2, 3, 5, 7},8)));
        System.out.println(Arrays.toString(mySolution(new int[] {2, 1, 5, 7},13)));
    }

    private static int[] mySolution(int[] numbers, int target) {
        // generate Hash Map
        Map<Integer, Integer> numberMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            numberMap.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int numberToFind = target - numbers[i] - numbers[j];

                if (numberMap.containsKey(numberToFind)) {
                    return new int[] {i, j, numberMap.get(numberToFind)};
                }
            }
        }
        return null; // 요구 사항에 따라 다름
    }
}
