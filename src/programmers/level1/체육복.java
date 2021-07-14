package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class 체육복 {

  public static void main(String[] args) {
    System.out.println(solution());
  }

  private static int solution() {
    int n = 5;
    int[] lost = {2,3};
    int[] reserve = {3};

    Arrays.sort(lost);
    Arrays.sort(reserve);

    List<String> lostList = new ArrayList<>();
    List<String> reserveList = new ArrayList<>();

    for (int lostStu : lost) {
      lostList.add(String.valueOf(lostStu));
    }

    for (int reserveStu : reserve) {
      reserveList.add(String.valueOf(reserveStu));
    }
    Iterator iter = reserveList.iterator();

    while (iter.hasNext()) {
      String temp = (String) iter.next();

      if (lostList.contains(temp)) {
        iter.remove();
        lostList.remove(temp);
        reserveList.remove(temp);
      }
    }

    for (String reserveStu : reserveList) {
      for (String lostStu : lostList) {
        if (reserveStu.equals(lostStu)) {
          lostList.remove(lostStu);
          break;
        } else if (Integer.parseInt(reserveStu) - 1 == Integer.parseInt(lostStu)
           || Integer.parseInt(reserveStu) + 1 == Integer.parseInt(lostStu)) {
          lostList.remove(lostStu);
          break;
        }
      }
    }

    return n - lostList.size();
  }
}
