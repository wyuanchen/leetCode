连续子数组的最大和

//动态规划,时间复杂度O(n),空间复杂度O(1)
//定义f(i)为以第i个元素为尾部的子数组的最大和，
//f(i)=max(f(i-1)+array[i],array[i])
//其中f(0)=array[0]
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null||array.length==0)
            return 0;
        int sum=0;
        int max=sum=array[0];
        for(int i=1;i<array.length;i++){
            sum=(sum+array[i])>array[i]?(sum+array[i]):array[i];
            if(max<sum)
              max=sum;
        }
        return max;
    }
}
