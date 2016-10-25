//题目描述
// 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。

//java
//在数组两边同时逼近，时间复杂度O(n)
import java.util.ArrayList;
public class Solution {
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result=new ArrayList<Integer>(2);
        if(array==null)
            return result;
        int head=0;
        int tail=array.length-1;
        while(head<tail){
            if(array[head]+array[tail]<sum)
                head++;
            else if(array[head]+array[tail]>sum)
                tail--;
            else
                break;
        }
        if(head>=tail)
            return result;
        result.add(array[head]);
        result.add(array[tail]);
        return result;
    }
}


//c++
class Solution {
public:
    vector<int> FindNumbersWithSum(vector<int> array,int sum) {
        int head=0;
        int tail=array.size()-1;
        while(head<tail){
            if(array[head]+array[tail]<sum)
                head++;
            else if(array[head]+array[tail]>sum)
                tail--;
            else
                break;
        }
        vector<int> result;
        if(head>=tail)
            return result;
        result.push_back(array[head]);
        result.push_back(array[tail]);
        return result;
    }
};
