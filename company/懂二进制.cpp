题目描述
世界上有10种人，一种懂二进制，一种不懂。那么你知道两个int32整数m和n的二进制表达，有多少个位(bit)不同么？
输入例子:
1999 2299

输出例子:
7


class Solution {
public:
    /**
     * 获得两个整形二进制表达位数不同的数量
     *
     * @param m 整数m
     * @param n 整数n
     * @return 整型
     */
    int countBitDiff(int m, int n) {
		    int a=m^n;
        int sum=0;
        //这个方法可以统计a的二进制表示中有多少个1
        while(a!=0){
            sum++;
            a=a&(a-1);
        }
        return sum;
    }
};
