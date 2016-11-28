//给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。

//C++
//时间复杂度O(n)
class Solution {
public:
    vector<int> multiply(const vector<int>& A) {
        int length=A.size();
    	if(length<2)
            return A;
        vector<int> result(length);
        result[0]=1;
        //先从前往后遍历
        for(int i=1;i<length;i++){
            //result[i]=A[0]*A[1]*...*A[i-1]
            result[i]=result[i-1]*A[i-1];
        }
        //从后往前遍历
        int temp=1;
        for(int i=length-2;i>=0;i--){
            temp*=A[i+1];
            result[i]*=temp;
        }
        return result;
    }
};
