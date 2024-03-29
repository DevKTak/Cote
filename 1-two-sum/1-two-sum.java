class Solution {
    public int[] twoSum(int[] nums, int target) {
          Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int requiredNum = target - nums[i];

            if (indexMap.containsKey(requiredNum)) {
                return new int[]{indexMap.get(requiredNum), i};
            }
            indexMap.put(nums[i], i);
        }

        return null;
    }
}
