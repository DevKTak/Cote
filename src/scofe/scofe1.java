package scofe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class scofe1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int minBack = Integer.MAX_VALUE;
        int maxFront = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            String[] splitArr = arr[i].split(" ~ ");
            int tempFront = Integer.valueOf(splitArr[0].replace(":", ""));
            int tempBack = Integer.valueOf(splitArr[1].replace(":", ""));

            if (maxFront < tempFront) {
                maxFront = tempFront;
            }

            if (minBack > tempBack) {
                minBack = tempBack;
            }
        }

        if (maxFront > minBack) {
            System.out.println("-1");
        } else {
            String formatFront = String.format("%04d", maxFront);
            String formatBack = String.format("%04d", minBack);
            String resultFront = formatFront.substring(0, 2) + ":" + formatFront.substring(2, 4);
            String resultBack = formatBack.substring(0, 2) + ":" + formatBack.substring(2, 4);

            System.out.println(resultFront + " ~ " + resultBack);
        }
    }
}
