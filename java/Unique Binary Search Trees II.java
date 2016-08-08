95. Unique Binary Search Trees II

    Total Accepted: 61283
    Total Submissions: 207460
    Difficulty: Medium

Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3





   /**
    * Definition for a binary tree node.
    * public class TreeNode {
    *     int val;
    *     TreeNode left;
    *     TreeNode right;
    *     TreeNode(int x) { val = x; }
    * }
    */
    //参照之前Unique Binary Search Trees的递归思路
   public class Solution {
       public List<TreeNode> generateTrees(int n) {
           if(n==0){
               List<TreeNode> list=new LinkedList<TreeNode>();
               return list;
           }
           return generateHelp(1,n);
       }

       private List<TreeNode> generateHelp(int start,int end){
           List<TreeNode> list=new LinkedList<TreeNode>();
           if(start>end){
               list.add(null);
               return list;
           }
           for(int i=start;i<=end;i++){
               List<TreeNode> leftList=generateHelp(start,i-1);
               List<TreeNode> rightList=generateHelp(i+1,end);
               for(TreeNode left:leftList){
                   for(TreeNode right:rightList){
                       TreeNode root =new TreeNode(i);
                       root.left=left;
                       root.right=right;
                       list.add(root);
                   }
               }
           }

           return list;
       }
   }
