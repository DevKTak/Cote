package boj.level6;

/** 셀프 넘버 */
public class boj_04673 {

    public static void main(String[] args) {
        int num = 0;
        boolean[] flag = new boolean[10001];

        for (int i = 1; i <= 10001; i++) {
             num = d(i);

             if (num < 10001) {
                 flag[num] = true; // sum 으로 리턴되어 온 값은 생성자가 없는 숫자가 아니다 (셀프넘버가 아님)
             }
        }

        for (int i = 1; i < flag.length; i++) {
            if (!flag[i]) System.out.println(i);
        }
    }

    public static int d(int i) {
        int sum = i;

        while (i != 0) {
            sum += i % 10; // 1의 자리
            i = i / 10; // 1의 자리 더했으니깐 날리기
        }

        return sum;
    }
}
