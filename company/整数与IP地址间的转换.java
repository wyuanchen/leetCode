/*
原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
一个长整数。
举例：一个ip地址为10.0.3.193
每段数字             相对应的二进制数
10                   00001010
0                    00000000
3                    00000011
193                  11000001
组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。

的每段可以看成是一个0-255的整数，需要对IP地址进行校验
*/

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str, r1, r2;
        while (sc.hasNext()){
            str = sc.next();
            r1 = convert(str);
            str = sc.next();
            r2 = convert(str);
            System.out.println(r1);
            System.out.println(r2);
        }
    }


    public static String convert(String str){
        if (str == null || (str = str.trim()).equals("")){
            return null;
        }
        if (str.contains(".")){
            str = ip2int(str);
        }else{
            str = int2ip(str);
        }
        return str;
    }

    private static String ip2int(String str){
        String[] ip = str.split("\\.");
        if (ip.length != 4){
            return str;
        }
        long result = 0;
        for (int i = 0; i < 4; i++){
            result = (result << 8) | Integer.valueOf(ip[i]);
        }
        return result + "";
    }

    private static String int2ip(String str){
        long ip = Long.valueOf(str);
        StringBuilder sb = new StringBuilder();
        long temp;
        for (int i = 3; i >= 0; i--){
            temp = (ip >>> i * 8) & 0xFF;
            sb.append(temp + ".");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
