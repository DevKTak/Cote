import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 주몽
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        Map<Integer, Boolean> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            map.put(Integer.parseInt(st.nextToken()), true);
        }

        int cnt = 0;
        for (int key : map.keySet()) {
            if (map.getOrDefault(M - key, false)) {
                cnt++;
            }
        }
        System.out.println(cnt / 2);
    }
}
