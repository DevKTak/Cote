package boj.level12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 나이순 정렬 */
public class boj_10814 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    Member[] memberArr = new Member[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      memberArr[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
    }
    Arrays.sort(memberArr);

    for (Member member : memberArr) {
      System.out.println(member.age + " " + member.name);
    }
  }

  private static class Member implements Comparable<Member> {

    private int age;
    private String name;

    private Member(int age, String name) {
      this.age = age;
      this.name = name;
    }

    @Override
    public int compareTo(Member member) {
      if (this.age > member.age) {
        return 1;
      } else if (this.age == member.age) {
        return 0;
      } else {
        return -1;
      }
    }
  }
}
