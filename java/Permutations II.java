/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
带重复的全排列问题
*/

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


//此方法其实与Perm算法类似，回忆一下perm算法是讲list[k:m]中的每一个元素分别与list[k]中的元素交换。 
//而有重复元素时应该考虑区别了，设k ≤ i ≤ m,此时要替换 list[ k ] 为 list [ i ]，则 k ≤ j ≤ i,list[j]已经替换过了。若list[ i ]==list[ j ]，则此时的替换在之前已经做过，此时再做相当于重复了，则不应替换！  
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
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
    			//判断是否重复
    		    if(isRepeat(nums,from,i))
    		        continue;
    			swap(nums,from,i);
    			permute(nums,from+1,end,result);
    			swap(nums,from,i);
    		}
    	}
    }

    private boolean isRepeat(int[] nums,int from,int k){
    	for(int i=from;i<k;i++){
    		if(nums[i]==nums[k])
    			return true;
    	}
    	return false;
    }



    private void swap(int[] nums,int a,int b){
    	if(a!=b){
    		nums[a]=nums[a]^nums[b];
    		nums[b]=nums[a]^nums[b];
    		nums[a]=nums[a]^nums[b];
    	}
    }
}