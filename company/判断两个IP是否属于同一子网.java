/*
子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
子网掩码与IP地址结构相同，是32位二进制数，其中网络号部分全为“1”和主机号部分全为“0”。利用子网掩码可以判断两台主机是否中同一子网中。若两台主机的IP地址分别与它们的子网掩码相“与”后的结果相同，则说明这两台主机在同一子网中。
示例：
I P 地址　 192.168.0.1
子网掩码　 255.255.255.0
转化为二进制进行运算：
I P 地址　11010000.10101000.00000000.00000001
子网掩码　11111111.11111111.11111111.00000000
AND运算
 　　　　11000000.10101000.00000000.00000000
转化为十进制后为：
 　　　　192.168.0.0
 
I P 地址　 192.168.0.254
子网掩码　 255.255.255.0

转化为二进制进行运算：
I P 地址　11010000.10101000.00000000.11111110
子网掩码　11111111.11111111.11111111.00000000
AND运算
　　　　　11000000.10101000.00000000.00000000
转化为十进制后为：
　　　　　192.168.0.0
通过以上对两台计算机IP地址与子网掩码的AND运算后，我们可以看到它运算结果是一样的。均为192.168.0.0，所以这二台计算机可视为是同一子网络。
/* 
* 功能: 判断两台计算机IP地址是同一子网络。 
* 输入参数：    String Mask: 子网掩码，格式：“255.255.255.0”； 
*               String ip1: 计算机1的IP地址，格式：“192.168.0.254”；
*               String ip2: 计算机2的IP地址，格式：“192.168.0.1”；
*               
* 返回值：      0：IP1与IP2属于同一子网络；     1：IP地址或子网掩码格式非法；    2：IP1与IP2不属于同一子网络
*/ 

*/



import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String mask, ip1, ip2;
        int result;
        while (sc.hasNext()){
            mask = sc.nextLine();
            ip1 = sc.nextLine();
            ip2 = sc.nextLine();
            result = valid(mask, ip1, ip2);
            System.out.println(result + ""); 
        }
    }

    public static int valid(String mask, String ip1, String ip2){
        if (mask == null || ip1 == null || ip2 == null){
            return 1;
        }
        String[] ms = mask.trim().split("\\.");
        String[] ip1s = ip1.trim().split("\\.");
        String[] ip2s = ip2.trim().split("\\.");
        // if (ms.length != 4 || ip1s.length != 4 || ip2s.length != 4){
            // return 1;
        // }
        int m, a, b;
        for (int i = 0; i < ms.length; i++){
            m = Integer.parseInt(ms[i]);
            a = Integer.parseInt(ip1s[i]);
            b = Integer.parseInt(ip2s[i]);
            if (m < 0 || m > 255 || a < 0 || a > 255 || b < 0 || b > 255){
                return 1;
            }
            if ((m & a) != (m & b)){
                return 2;
            }
        }
        return 0;
    }
}