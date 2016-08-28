
//题目描述
//在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

//时间复杂度(nlog(n)),利用二分查找
public class Solution {
    public boolean Find(int [][] array,int target) {
        int left=0,right=array.length-1,mid=0;
        for(int i=0;i<array.length;i++){
            left=0;
            right=array[i].length-1;
            while(left<=right){
                mid=(left+right)/2;
                if(array[i][mid]<target)
                    left=mid+1;
                else if(array[i][mid]>target)
                    right=mid-1;
                else
                    return true;
            }
        }
        return false;

    }
}
