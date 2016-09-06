题目描述
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

//分治法和位运算，注意边界条件
//C++
class Solution {
public:
    double Power(double base, int exponent) {
    	if(equal(base,0.0)&&exponent<=0)
            return 0.0;
        if(exponent<0){
            return 1/powerWithUnsigned(base,-exponent);
        }else{
            return powerWithUnsigned(base,exponent);
        }
    }

    double powerWithUnsigned(double base,int exponent){
        if(exponent==0)
            return 1.0;
        if(exponent==1)
            return base;
        double result=powerWithUnsigned(base,exponent>>1);
        result*=result;
        if(exponent&1==1)
            result*=base;
        return result;
    }

    bool equal(double a,double b){
        if(a-b<0.0000001&&a-b>-0.0000001)
            return true;
        return false;
    }
};
