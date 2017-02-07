/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
 		List<List<Integer>> result=new LinkedList<>();
 		permute(nums,0,nums.length-1,result);
 		return result;
    }

    public void permute(int[] nums, int from, int end, List<List<Integer>> result){
    	if(from==end){
    		int len=nums.length;
    		List<Integer> l=new ArrayList<>(len);
    		for(int i=0;i<len;i++)
    			l.add(nums[i]);
    		result.add(l);
    	}
    	else{
    		for(int i=from;i<=end;i++){
    			swap(nums,from,i);
    			permute(nums,from+1,end,result);
    			swap(nums,from,i);
    		}
    	}
    }

    private void swap(int[] nums,int a,int b){
    	if(a!=b){
    		nums[a]=nums[a]^nums[b];
    		nums[b]=nums[a]^nums[b];
    		nums[a]=nums[a]^nums[b];
    	}
    }
}