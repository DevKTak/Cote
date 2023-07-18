package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leet_645_Set_Mismatch {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 1})));
        System.out.println(Arrays.toString(findErrorNums(new int[]{2, 2}))); // [2, 1]

    }

    public static int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int dup = 0;
        int mis = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    dup = i;
                }
            } else {
                mis = i;
            }
        }

        return new int[]{dup, mis};
    }
}
