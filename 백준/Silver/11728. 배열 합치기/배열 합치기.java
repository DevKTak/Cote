import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> listA = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < a; i++) {
            listA.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> listB = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < b; i++) {
            listB.add(Integer.parseInt(st.nextToken()));
        }
        listA.addAll(listB);
        Collections.sort(listA);

        StringBuilder sb = new StringBuilder();
        for (int v : listA) {
            sb.append(v + " ");
        }
        System.out.println(sb);
//        Stream.concat(listA.stream(), listB.stream()).sorted().forEach(v -> System.out.print(v + " "));
    }
}
