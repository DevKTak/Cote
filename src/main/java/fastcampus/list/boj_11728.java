package fastcampus.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_11728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> listA = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            listA.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> listB = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            listB.add(Integer.parseInt(st.nextToken()));
        }

        /** 3번 **/
        List<Integer> result = new ArrayList<>(n + m);
        int i = 0, j = 0; // 배열 A의 인덱스, 배열 B의 인덱스

        while (i < n && j < m) {
            int aValue = listA.get(i);
            int bValue = listB.get(j);

            if (aValue <= bValue) {
                result.add(aValue);
                i++;
            } else {
                result.add(bValue);
                j++;
            }
        }

        for (; i < n; i++) {
            result.add(listA.get(i));
        }

        for (; j < m; j++) {
            result.add(listB.get(j));
        }

        StringBuilder sb = new StringBuilder();
        for (int v : result) {
            sb.append(v + " ");
        }
        System.out.println(sb);

        /** 1번 **/
//        listA.addAll(listB);
//        Collections.sort(listA);
//
//        StringBuilder sb = new StringBuilder();
//        for (int v : listA) {
//            sb.append(v + " ");
//        }
//        System.out.println(sb);

        /** 2번 **/
//        Stream.concat(listA.stream(), listB.stream()).sorted().forEach(v -> System.out.print(v + " "));
    }
}
