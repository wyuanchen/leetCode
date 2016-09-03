题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。


class Solution {
public:
    int jumpFloorII(int number) {
        int *f=new int[number+1];
        f[0]=1;
        for(int i=1;i<=number;i++){
            f[i]=0;
            for(int j=1;j<=i;j++)
                f[i]+=f[i-j];
        }
        int result=f[number];
        delete []f;
        f=NULL;
        return result;
    }
};
