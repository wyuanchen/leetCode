/*
Levenshtein 距离，又称编辑距离，指的是两个字符串之间，由一个转换成另一个所需的最少编辑操作次数。许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。编辑距离的算法是首先由俄国科学家Levenshtein提出的，故又叫Levenshtein Distance。
Ex：
字符串A:abcdefg
字符串B: abcdef
通过增加或是删掉字符”g”的方式达到目的。这两种方案都需要一次操作。把这个操作所需要的次数定义为两个字符串的距离。
要求：
给定任意两个字符串，写出一个算法计算它们的编辑距离。
*/

import java.util.*;
 
public class Main{
 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1, str2;
        while (sc.hasNext()){
            str1 = sc.nextLine();
            str2 = sc.nextLine();
            int count = calStringDistance(str1, str2);
            System.out.println(count + "");
        }
    }
 
    public static int calStringDistance (String str1, String str2)
    {
       if (str1 == null || str2 == null){
            return -1;
       }
       int len1 = str1.length();
       int len2 = str2.length();
       int[][] dp = new int[len1 + 1][len2 + 1];
       for(int i = 0; i <= len1; i++){
            dp[i][0] = i;
       }
       for (int i = 0; i <= len2; i++){
            dp[0][i] = i;
       }
       int a, b, c;
       for (int i = 1; i <= len1; i++){
            for (int j = 1; j <= len2; j++){
                a = dp[i - 1][j] + 1;
                b = dp[i][j - 1] + 1;
                c = dp[i - 1][j - 1];
                if (str1.charAt(i - 1) != str2.charAt(j - 1)){
                    c++;
                }
                dp[i][j] = Math.min(a, Math.min(b, c));
            }
       }
       return dp[len1][len2];
    }
}