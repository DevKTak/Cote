package boj.class2;

import java.util.*;

public class bj_01181 {

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        HashSet<String> set = new HashSet<>();

        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            set.add(scanner.nextLine());
        }

        int i = 0;
        Iterator<String> iter = set.iterator();
        String[] arr = new String[set.size()];

        while (iter.hasNext()) {
            arr[i++] = iter.next();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                if (s.length() == t1.length()) { // 길이가 같을 경우
                    return s.compareTo(t1); // 사전순 정렬
                } else { // 그 외
                    return s.length() - t1.length(); // 양수: 위치바꿈, 0 or 음수: 바뀌지않음
                }
            }
        });

        for (String s : arr) {
            System.out.println(s);
        }

    }
}

