

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 요세푸스 문제
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int k = Integer.parseInt(st.nextToken()); // K 번째 사람 제거

        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        int cur = 0;
        while (!list.isEmpty()) {
            cur = (cur + k - 1) % list.size();
            sb.append(list.remove(cur));

            if (list.size() != 0){
                sb.append(", ");
            }
        }
        System.out.println("<" + sb + ">");

    }
}
