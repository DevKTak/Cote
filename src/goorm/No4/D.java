package goorm.No4;

import java.lang.*;
import java.util.*;


public class D {
    public static final Scanner scanner = new Scanner(System.in);


    public static long getGlobalPeriod(int n, long[] sizes)
    {
        long globalPeriod = sizes[0];

        for (int i = 0; i < sizes.length - 1; i++) {
            globalPeriod = MathUtil.getLCM(globalPeriod, sizes[i + 1]);
        }

        return globalPeriod;
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt(); // 수열의 수
        long[] sizes = new long[n];  // 각 수열의 주기

        for(int i = 0 ; i < n ; i++)
        {
            sizes[i] = scanner.nextLong();
        }

        // 전체의 공통 주기만큼 이후에 다시 최초로 만나게 되므로
        long answer = 1 + getGlobalPeriod(n, sizes);

        // 정답을 출력한다
        System.out.println(answer);
    }

}


class MathUtil
{
    public static long getLCM(long curLCM, long nextVal)
    {
        long GCD = 0;
        long product = curLCM * nextVal;

        while (curLCM % nextVal != 0) {
            long temp = curLCM % nextVal;
            curLCM = nextVal;
            nextVal = temp;
        }
        GCD = nextVal;

        return product / GCD;
    }



}