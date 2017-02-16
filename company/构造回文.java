/*
给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？输出需要删除的字符个数。+

输入描述:输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
输出描述:对于每组数据，输出一个整数，代表最少需要删除的字符个数。
输入例子:
abcdagoogle
输出例子:
22
*/


//对于这题来说，插入字符和删除字符使其成为回文串，答案是一样的.首先求s的反串rs，然后对s和rs求最长公共子序列，要删除的字符个数就是 LCS.
import java.util.*;

public class Main{
    
    public static void main(String[] args){
		Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            System.out.println(process(str));
        }
    }
    
    public static int process(String str){
        return str.length() - lcs(str,reverse(str));
    }
    
    public static String reverse(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
    
    public static int lcs(String str1, String str2){
        int len1 = str1.length(), len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++){
            dp[i][0] = 0;
        }
        for (int i = 0; i < len2; i++){
            dp[0][i] = 0;
        }
        for (int i = 1; i <= len1; i++){
            for (int j = 1; j <= len2; j++){
                if (str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }
    
}