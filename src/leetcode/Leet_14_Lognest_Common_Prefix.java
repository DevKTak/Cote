package leetcode;

public class Leet_14_Lognest_Common_Prefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String standard = strs[0];

        for (int i = 1; i < strs.length; i++) {
                while (strs[i].indexOf(standard) != 0) {
                standard = standard.substring(0, standard.length() - 1);
            }
        }

        return standard;
    }
}
