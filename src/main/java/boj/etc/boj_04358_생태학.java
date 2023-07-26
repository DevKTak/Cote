package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 생태학
 */
public class boj_04358_생태학 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> tree = new HashMap<>();
        int cnt = 0;
        String line;

        while ((line = br.readLine()) != null) {
            tree.put(line, tree.getOrDefault(line, 0) + 1);
            cnt++;
        }

        List<String> keyList = new ArrayList<>(tree.keySet());
        Collections.sort(keyList);
        StringBuilder sb = new StringBuilder();

        for (String key : keyList) {
            sb.append(key)
                    .append(" ")
                    .append(String.format("%.4f", ((double) tree.get(key) / cnt) * 100))
                    .append("\n");
        }
        System.out.println(sb);
    }
}
