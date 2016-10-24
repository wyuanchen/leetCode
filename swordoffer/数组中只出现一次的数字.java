// 题目描述
// 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字


//java，时间复杂度O(1),利用异或操作,两个相同的数字异或后为0
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int exclusiveORResult=0;
        for(int a:array)
            exclusiveORResult^=a;
        int mask=findMask(exclusiveORResult);
        num1[0]=num2[0]=0;
        for(int a:array){
            if((a&mask)>0)
                num1[0]^=a;
            else
                num2[0]^=a;
        }
    }

    private int findMask(int a){
        int mask=1;
        for(int i=0;i<32;i++){
            if((a&mask)>0)
                return mask;
            mask=mask<<1;
        }
        return mask;
    }
}


//C++
class Solution {
public:
    void FindNumsAppearOnce(vector<int> data,int* num1,int *num2) {
        int exclusiveOrResult=0;
        for(int i=0;i<data.size();i++)
            exclusiveOrResult^=data[i];
        unsigned int mask=findMask(exclusiveOrResult);
        *num1=*num2=0;
        for(int i=0;i<data.size();i++){
            if((data[i]&mask)>0)
                *num1^=data[i];
            else
                *num2^=data[i];
        }
    }

    unsigned int findMask(int a){
        unsigned int mask=1;
        for(int i=0;i<8*sizeof(int);i++){
            if((a&mask)>0)
                return mask;
            mask=mask<<1;
        }
        return mask;
    }
};
