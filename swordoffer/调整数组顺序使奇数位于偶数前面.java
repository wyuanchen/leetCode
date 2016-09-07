题目描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。


//java
//时间复杂度O(n),空间复制度O(n)
public class Solution {
    public void reOrderArray(int [] array) {
        int length=array.length;
        int[] temp=new int[length];
        for(int i=0,k=i;i<length;i++)
            if(array[i]%2!=0)
            	temp[k++]=array[i];
        for(int i=length-1,k=i;i>=0;i--)
            if(array[i]%2==0)
            	temp[k--]=array[i];
        for(int i=0;i<length;i++)
            array[i]=temp[i];
    }
}
