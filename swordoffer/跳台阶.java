
题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

//f(n)=f(n-1)+f(n-2)
public class Solution {
    public int JumpFloor(int target) {
		int f1=1,f2=1,fn=1;
        for(int i=2;i<=target;i++){
            fn=f2+f1;
            f1=f2;
            f2=fn;
        }
        return f2;
    }
}
