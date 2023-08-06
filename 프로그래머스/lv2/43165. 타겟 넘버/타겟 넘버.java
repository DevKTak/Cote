class Solution {
    
    static int dfsCnt = 0;
    static int bfsCnt = 0;
    
    public int solution(int[] numbers, int target) {
        Solution tn = new Solution();

        tn.dfs(0, numbers, target, 0);

        return dfsCnt;
    }
    
     public void dfs(int index, int[] numbers, int target, int sum) {
        if (index == numbers.length) {

            if (target == sum) {
                dfsCnt++;
            }

            return;
        }

        dfs(index + 1, numbers, target, sum + numbers[index]);
        dfs(index + 1, numbers, target, sum - numbers[index]);
    }
}