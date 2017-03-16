/*
编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。但是要保证汉字不被截半个，如"我ABC"4，应该截为"我AB"，输入"我ABC汉DEF"6，应该输出为"我ABC"而不是"我ABC+汉的半个"。 
*/


import java.util.*;
 
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str;
        int len;
        while (sc.hasNext()){
            str = sc.next();
            len = sc.nextInt();
            str = cut(str, len);
            System.out.println(str);
        }
    }
     
    public static String cut(String str, int len){
        if (str == null || len <= 0){
            return str;
        }
        char[] cs = str.toCharArray();
        int end = 0, count = 0;
        while (end < cs.length && count < len){
            if (cs[end] < 256){
                count++;
            }else{
                count += 2;
            }
            end++;
        }
        if (count == len){
            return new String(cs, 0, end);
        }else{
            return new String(cs, 0, end - 1);
        }
    }
}