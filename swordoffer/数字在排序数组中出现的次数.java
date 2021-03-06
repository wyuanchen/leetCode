// 题目描述
// 统计一个数字在排序数组中出现的次数。


//java
//普通的遍历需要O(1);
//考虑到该数组是已经排好序的，所有应该想到二分搜索，分别对整个数组进行两次二分搜索，第一次用于找到位于最右边的k的下标，第二次用于找到位于最左边的k的下标，
//则最后k出现的总次数=两个下标的相减再加1
//所以时间复杂度为 2O(logN)=O(logN)
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if(array==null)
            return 0;
        int rIndex=getNumHelp(array,k,true);
        //如果等于-1表示该数组中并不存在元素k
        if(rIndex==-1)
            return 0;
        int lIndex=getNumHelp(array,k,false);
        return rIndex-lIndex+1;

    }

    //用于搜索k在数组出现的第一个下标或者最后一个下标,其中direction为true则搜索最后一个下标，反之搜索第一个下标,
    //如果k没有在数组中出现则返回-1
    private int getNumHelp(int[] array,int k,boolean direction){
        int index=-1;
        int left=0;
        int right=array.length-1;
        int mid=0;
        while(left<=right){
            mid=(left+right)/2;
            if(array[mid]>k){
                right=mid-1;
            }else if(array[mid]<k){
                left=mid+1;
            }else{
                index=mid;
                if(direction)
                    left=mid+1;
                else
                    right=mid-1;
            }
        }
        return index;
    }
}


//C++,利用二分查找,时间复杂度O(logN)
class Solution {
public:
    int GetNumberOfK(vector<int> data ,int k) {
        int rIndex=getNumHelp(data,k,true);
        if(rIndex==-1)
            return 0;
        int lIndex=getNumHelp(data,k,false);
        return rIndex-lIndex+1;
    }

    //用于搜索k在数组出现的第一个下标或者最后一个下标,其中direction为true则搜索最后一个下标，反之搜索第一个下标,
    //如果k没有在数组中出现则返回-1
    int getNumHelp(vector<int> data,int k,bool direction){
        int left=0;
        int right=data.size()-1;
        int mid=0;
        int index=-1;
        while(left<=right){
            mid=(left+right)/2;
            if(data[mid]<k)
                left=mid+1;
            else if(data[mid]>k)
                right=mid-1;
            else{
                index=mid;
                if(direction)
                    left=mid+1;
                else
                    right=mid-1;
            }
        }
        return index;
    }

};
