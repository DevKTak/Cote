package programmers.level3;

public class 단어변환 {

    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    private static boolean[] visited;
    private static int cnt = 0;

    private static int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);

        return cnt;
    }

    private static void dfs(String begin, String target, String[] words, int num) {
        if (visited[num]) return;

//        for (int i = 0; i < ; i++) {
//
//        }


    }
}
