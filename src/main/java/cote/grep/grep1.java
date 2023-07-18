package cote.grep;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class grep1 {

  public static void main(String[] args) {
    String[] infos ={"kim password", "lee abc"};
    String[] actions = {
       "ADD 30",
       "LOGIN kim abc",
       "LOGIN lee password",
       "LOGIN kim password",
       "LOGIN kim password",
       "LOGIN lee abc",
       "ADD 30",
       "ORDER",
       "ORDER",
       "ADD 40",
       "ADD 50"
    };
    System.out.println(Arrays.toString(solution(infos, actions)));
  }

  private static boolean[] solution(String[] infos, String[] actions) {
    Map<String, String> infosMap = new HashMap<>();

    for (int i = 0; i < infos.length; i++) {
      String[] infoArr = infos[i].split(" ");
      infosMap.put(infoArr[0], infoArr[1]);
    }
    infosMap.put("kim", "password");
    infosMap.put("lee", "abc");

    boolean loginFlag = false; // 로그인 여부
    boolean orderFlag = false; // 장바구니 담은 음식 여부
    boolean[] answer = new boolean[actions.length];

    for (int i = 0; i < actions.length; i++) {
      String[] actionArr = actions[i].split(" ");

      if (loginFlag) { // 로그인이 되어 있는 경우
        if (actionArr[0].equals("LOGIN")) { // Action 이 LOGIN 일 경우
          answer[i] = false;
        } else if (actionArr[0].equals("ADD")) { // Action 이 ADD 일 경우
          answer[i] = true;
          orderFlag = true;
        } else { // Action 이 ORDER 일 경우
          if (orderFlag) { // 장바구니에 음식이 담겨져 있을 경우
            answer[i] = true;
            orderFlag = false;
          } else { // 장바구니에 음식이 없을 경우
            answer[i] = false;
          }
        }
      } else { // 로그인이 되어있지 않은 경우
        if (actionArr[0].equals("LOGIN")) { // Action 이 LOGIN 일 경우
          String userId = infosMap.get(actionArr[1]);

          if (userId != null && userId.equals(actionArr[2])) { // 아이디와 패스워드가 일치할 경우
            loginFlag = true;
            answer[i] = true;
          }
        } else { // 아이디와 패스워드가 일치하지 않을 경우
          answer[i] = false;
        }
      }
    }

    return answer;
  }
}
