package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leet_1_TowSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{-1,-2,-3,-4,-5, -8}, -8)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int requiredNum = target - nums[i];

            if (indexMap.containsKey(requiredNum)) {
                return new int[]{i, indexMap.get(requiredNum)};
            }
            indexMap.put(nums[i], i);
        }

        return null;
    }
}
