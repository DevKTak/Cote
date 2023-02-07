package ndb.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ndb_숫자카드게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int min;
        int max = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            min = 10001;

            for (int j = 0; j < m; j++) {
                min = Math.min(min, Integer.parseInt(st.nextToken()));
            }
            max = Math.max(max, min);
        }
        System.out.println(max);

//        Arrays.stream(arr).flatMapToInt(Arrays::stream).forEach(System.out::println);


    }
}
