import java.util.Arrays;

class Solution {
    public int[] findErrorNums(int[] nums) {
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
