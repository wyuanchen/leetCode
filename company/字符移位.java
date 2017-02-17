/*
小Q最近遇到了一个难题：把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
你能帮帮小Q吗？   

输入描述:

输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
  
输出描述:

对于每组数据，输出移位后的字符串。

输入例子:
AkleBiCeilD

输出例子:
kleieilABCD
*/

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str;
        while (in.hasNext()){
            str = in.nextLine();
            System.out.println(move(str));
        }
    }
    
    public static String move(String str){
        int a, b;
        char temp;
        char[] s = str.toCharArray();
        for (a = b = s.length - 1; a >= 0; a--){
            if (s[a] >= 'A' && s[a] <= 'Z'){
                temp = s[a];
                for (int i = a; i < b; i++){
                  	s[i] = s[i + 1];
                }
                s[b] = temp;
                b--;
            }
        }
        return new String(s);
    }
}


