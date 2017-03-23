120. Triangle  QuestionEditorial Solution  My Submissions
Total Accepted: 78188
Total Submissions: 250304
Difficulty: Medium
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

//动态规划
//设状态为$f(i, j)$，表示从从位置$(i,j)$出发，路径的最小和，则状态转移方程为
//f(i,j)=min{f(i,j+1),f(i+1,j+1)}+(i,j)
//然后只用了一个一维的数组来存储结果
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height=triangle.size();
        int[] result=new int[height];
        for(int i=0;i<height;i++){
            result[i]=triangle.get(height-1).get(i);
        }
        for(int curLayer=height-2;curLayer>=0;curLayer--){
            for(int i=0;i<curLayer+1;i++){
                int curVal=triangle.get(curLayer).get(i);
                int left=result[i];
                int right=result[i+1];
                curVal=curVal+(left<right?left:right);
                result[i]=curVal;
            }
        }
        return result[0];
    }
