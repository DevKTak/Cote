package cote.tmap;

public class tmap4 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 4, 8}));
        System.out.println(solution(new int[]{5, 27, 9, 0, 31}));
        System.out.println(solution(new int[]{0, 0, 0, 0, 0}));
    }

    private static int solution(int[] numbers) {
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            String binary = Integer.toBinaryString(numbers[i]);

            if (binary.equals("0")) {
                continue;
            }
            StringBuilder sb = new StringBuilder(binary);
            char onePick = sb.reverse().toString().charAt(i);
            sum += (onePick - '0') * (int) Math.pow(10, i);
        }

        return Integer.parseInt(String.valueOf(sum), 2);
    }
}
