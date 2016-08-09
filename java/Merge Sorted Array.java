88. Merge Sorted Array

    Total Accepted: 112974
    Total Submissions: 369303
    Difficulty: Easy

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.


//O(1)空间复杂度,从nums1右边排起，每次选出最大的放在nums1数组右边
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k=m+n-1;
        int l=m-1;
        int r=n-1;
        while(l>=0&&r>=0){
            if(nums1[l]>nums2[r])
                nums1[k--]=nums1[l--];
            else
                nums1[k--]=nums2[r--];
        }
        while(r>=0){
            nums1[k--]=nums2[r--];
        }
    }
}
