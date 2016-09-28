题目描述
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。


//java ,时间复杂度O(nlogk)
import java.util.TreeSet;
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result=new ArrayList<Integer>(k);
        if(input==null||input.length<k||k<=0)
            return result;
        TreeSet<Integer> least=new TreeSet<Integer>();
        int big=0;
        for(int i=0;i<input.length;i++){
            if(i<k)
                least.add(input[i]);
            else{
                big=least.last();
                if(input[i]<big){
                    least.remove(big);
                    least.add(input[i]);
                }
            }
        }
        for(Integer data:least)
            result.add(data);
        return result;
    }
}
