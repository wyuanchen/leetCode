/*
Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
*/

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            int len = count(str);
            System.out.println(len);
        }
    }

    public static int count(String str){
        if (str == null){
            return 0;
        }
        char[] cs = preProcess(str);
        int len = cs.length;
        int[] dp = new int[len];
        int id = 1, mx = 0;
        for (int i = 1; i < len - 1; i++){
            dp[i] = mx > i ? Math.min(dp[2 * id - i], mx - i) : 1;
            while (cs[i + dp[i]] == cs[i - dp[i]]){
                dp[i]++;
            }
        }
        int maxLen = Integer.MIN_VALUE;
        for (int i = 1; i < len - 1; i++){
            if (maxLen < dp[i]){
                maxLen = dp[i];
            }
        }
        return maxLen - 1;
    }

    private static char[] preProcess(String str){
        int len = str.length();
        char[] cs = new char[len * 2 + 1 + 2];
        cs[0] = '^';
        cs[cs.length - 1] = '$';
        int i = 1, t = 0;
        while (t < len){
            cs[i++] = '#';
            cs[i++] = str.charAt(t++);
        }
        cs[i] = '#';
        return cs;
    }
}
