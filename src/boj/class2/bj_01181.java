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
                    /**
                     * 1. t1이 s에 포함되어있는 문자열일 경우
                     *    s 길이 - t1 길이 리턴
                     * 2. 포함되어 있지 않아서 비교가 불가능할 경우
                     *    s의 맨 앞 문자와 t1의 맨 앞 문자를 아스키값 기준으로 비교 (맨앞이 같다면 다음)
                     *    예) 맨 앞 문자가 각각 a = 97 / c = 99 이라면 97 - 99 = -2 리턴
                     *    예) a = 97 / A = 65 이라면 97 - 65 = 32 리턴
                     *    대소문자 무시하려면 compareToIgnorecase() 사용
                     */
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

