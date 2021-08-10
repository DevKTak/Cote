package programmers.level2;

public class 타겟넘버 {

    static int dfsCnt = 0;
    static int bfsCnt = 0;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        타겟넘버 tn = new 타겟넘버();

        tn.dfs(0, numbers, target, 0);
        tn.dfs(0, numbers, target, 0);

        System.out.println("dfsCnt = " + dfsCnt);
        System.out.println("bfsCnt = " + bfsCnt);
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

    public void bfs() {

    }
}
