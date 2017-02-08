/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

//字典序全排列
public class Solution {
    public void nextPermutation(int[] nums) {
    	int i;
    	//注意不能是nums[i]>nums[i+1]
		for(i=nums.length-2;i>=0 && nums[i]>=nums[i+1]; i--){}
		if(i>=0){
			int k;
			//注意不能是nums[k]<nums[i]
			for(k=nums.length-1;k>i&&nums[k]<=nums[i];k--){}
			swap(nums,i,k);
		}
		reverse(nums,i+1);
    }

    void reverse(int[] nums,int start){
    	for(int l=start,r=nums.length-1;l<r;l++,r--){
    		swap(nums,l,r);
    	}
    }


    void swap(int[] nums,int a,int b){
    	int temp=nums[a];
    	nums[a]=nums[b];
    	nums[b]=temp;
    }
}