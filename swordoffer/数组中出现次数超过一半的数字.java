题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

//java
//先排序，转化为在一个有序数组上的问题，时间复杂度为O(nlogn+n)=O(nlogn),空间复杂度O(1)
import java.util.Arrays;
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null)
            return 0;
        int length=array.length;
        Arrays.sort(array);
        int time=1;
        for(int i=1;i<length;i++){
            if(array[i]!=array[i-1]){
                if(time>length/2)
                    return array[i-1];
                time=1;
            }else
                time++;
        }
        if(time>length/2)
            return array[length-1];
        return 0;
    }
}
