package ndb.그리디;

public class ndb_거스름돈 {

    public static void main(String[] args) {
        int n = 1260;
        int count = 0;
        int[] coinType = {500, 100, 50, 10};

        for (int coin : coinType) {
            count += n / coin;
            n %= coin;
        }
        System.out.println(count);
    }
}
