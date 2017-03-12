/*
链接：https://www.nowcoder.com/questionTerminal/d3d8e23870584782b3dd48f26cb39c8f
来源：牛客网

按照指定规则对输入的字符串进行处理。 
  详细描述： 
  将输入的两个字符串合并。 
  对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标意思是字符在字符串中的位置。 

  对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，
  则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。
  如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’； 
  如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。

  举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，分别对“dca”和“efb”进行排序，排序后为“abcedf”，转换后为“5D37BF”

输入描述:
输入两个字符串


输出描述:
输出转化后的结果

输入例子:
dec fab

输出例子:
5D37BF
*/   


import java.util.*;

public class Main{
    
    public static void main(String[] args){
        String str1, str2, result;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            str1 = sc.next();
            str2 = sc.next();
            result = processString(str1, str2);
            System.out.println(result);
        }
    }
    
    public static String processString(String str1, String str2){
        if (str1 == null || str2 == null){
            return null;
        }
        char[] s = (str1 + str2).toCharArray();
        sort(s);
        reverse(s);
        return new String(s);
    }
    
    
    private static void sort(char[] s){
    	for(int i = 0; i < 2; i++){
            for (int k = i + 2; k < s.length; k += 2){
                char cur = s[k];
                int p = k - 2;
				for (; p >= 0 && s[p] > cur; p -= 2){
                    s[p + 2] = s[p];
                }                
                s[p + 2] = cur;
            }
        }    
    }
    
    private static void reverse(char[] s){
        for (int i = 0; i < s.length; i++){
            if ((s[i] >= '0' && s[i] <= '9') || (s[i] >= 'a' && s[i] <= 'f') || (s[i] >= 'A' && s[i] <= 'F')){
                s[i] = reverse(s[i]);
            }
        }
    }
    
    private static char reverse(char c){
        if (c >= '0' && c <='9'){
            c = (char) (c - '0');
        }else if (c >= 'a' && c <= 'f'){
            c = (char) (c - 'a' + 10);
        }else{
            c = (char) (c - 'A' + 10);
        }
        char r = 0;
        for (int i = 0; i < 4; i++){
            if ( (c & (1 << i)) > 0){
                r |= 1 << (3 - i);
            }
        }
        if (r >= 10){
            r = (char) ('A' + r - 10);
        }else{
            r = (char) ('0' + r);
        }
        return r;
    }
}

