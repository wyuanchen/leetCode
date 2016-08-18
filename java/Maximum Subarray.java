53. Maximum Subarray  QuestionEditorial Solution  My Submissions
Total Accepted: 127777
Total Submissions: 341534
Difficulty: Medium
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.



设状态为{f[j]}，表示以{S[j]}结尾的最大连续子序列和，则状态转移方程如下：
f[j]target==max{f[j−1]+S[j],S[j]}, 其中 1≤j≤nmax{f[j]}, 其中 1≤j≤n
解释如下：
 情况一，S[j]不独立，与前面的某些数组成一个连续子序列，则最大连续子序列和为$f[j-1]+S[j]$。
 情况二，S[j]独立划分成为一段，即连续子序列仅包含一个数S[j]，则最大连续子序列和为$S[j]$。

public class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE,f=0;
        for(int i=0;i<nums.length;i++){
            f=Math.max(f+nums[i],nums[i]);
            max=Math.max(max,f);
        }
        return max;
    }
}
