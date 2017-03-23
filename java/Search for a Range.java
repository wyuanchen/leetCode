34. Search for a Range  QuestionEditorial Solution  My Submissions
Total Accepted: 94681
Total Submissions: 316478
Difficulty: Medium
Given a sorted array of integers, find the starting and ending position of a given target value.
//Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].
For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].



//时间复杂度O(log n),利用二分查找的思想
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result={-1,-1};
        if(nums.length<1)
            return result;
        searchHelp(nums,0,nums.length-1,target,result,true,true);
        return result;
    }

    private void searchHelp(int[] nums,int left,int right,int target,int[] result,boolean searchLeft,boolean searchRight){
        if(left>right)
            return;
        int mid=(left+right)/2;
        if(nums[mid]<target){
            searchHelp(nums,mid+1,right,target,result,true,true);
        }else if(nums[mid]>target){
            searchHelp(nums,left,mid-1,target,result,true,true);
        }else{
            if(mid<result[0]||result[0]==-1)
                result[0]=mid;
            if(mid>result[1])
                result[1]=mid;
            searchHelp(nums,left,mid-1,target,result,true,false);
            searchHelp(nums,mid+1,right,target,result,false,true);
        }
    }
}
