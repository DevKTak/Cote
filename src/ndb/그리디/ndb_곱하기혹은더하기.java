package ndb.그리디;

public class ndb_곱하기혹은더하기 {

    public static void main(String[] args) {
//        String s = "02984"; // 576
//        String s = "567"; // 210
        String s = "156017"; // 259

        long result = s.charAt(0) - '0';

        for (int i = 1; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (num <= 1 || result <= 1) {
                result += num;
            } else {
                result *= num;
            }
        }
        System.out.println(result);
    }
}
