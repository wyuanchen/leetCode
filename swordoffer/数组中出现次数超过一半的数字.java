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


//java,时间复杂度O(n)
//如果数组中有一个数字出现次数超过一半，则意味着它出现的次数比其他所有数字出现的次数之和还要多
//所以我们在遍历数组的时候保存两个值，一个是数组的一个数字，另一个是次数，当我们遍历下一个数字的时候，如果下一个
//数字与之前保存的数字相同，则次数+1,反之-1,如果次数为0了，则保存下一个数字，并且把次数置为1，遍历完后则最后一次把次数置为1的数字就是我们要找的数字了
//在最坏情况下，假设119922999,则每次遍历到9的时候都会把次数-1，所以最坏情况下依然还是最后把次数置为1的那个数字是我们要找的数字
public class Solution{
    public int MoreThanHalfNum_Solution(int[] array){
        if(array==null)
            return 0;
        int result=array[0];
        int time=1;
        for(int i=1;i<array.length;i++){
            if(time==0){
                result=array[i];
                time=1;
            }
            if(array[i]==result){
                time++;
            }else{
                time--;
            }
        }
        if(!checkMoreThanHalf(array,result))
            return 0;
        return result;
    }

    private boolean checkMoreThanHalf(int[] a,int result){
        int time=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==result)
                time++;
        }
        return time>a.length/2;
    }
}
