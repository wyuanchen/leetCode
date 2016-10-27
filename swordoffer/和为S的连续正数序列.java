// 题目描述
// 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

//java 时间复杂度O(n)
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        int left=1,right=2;
        int temp=0;
        while(left<right&&right<sum/2+1){
            temp=(left+right)*(right-left+1)/2;
            if(temp<sum)
                right++;
            else if(temp>sum)
                left++;
            else{
                ArrayList<Integer> subSeq=new ArrayList<Integer>(right-left+1);
                for(int i=left;i<=right;i++)
                    subSeq.add(i);
                result.add(subSeq);
                left++;
            }
        }
        return result;
    }
}


//c++
class Solution {
public:
    vector<vector<int> > FindContinuousSequence(int sum) {
        vector<vector<int>> result;
        int left=1,right=2;
        int temp=0;
        while(left<right&&right<sum/2+1){
            temp=(left+right)*(right-left+1)/2;
            if(temp<sum)
                right++;
            else if(temp>sum)
                left++;
            else{
                vector<int> subSeq;
                for(int i=left;i<=right;i++)
                    subSeq.push_back(i);
                result.push_back(subSeq);
                left++;
            }
        }
        return result;
    }
};
