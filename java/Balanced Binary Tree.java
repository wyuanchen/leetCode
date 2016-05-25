110. Balanced Binary Tree
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Tag------Tree Depth-first Search
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
         return balanceHeight(root)>=0;
    }

    //返回一棵树的高度，如果该树是平衡的，则返回真正高度，否则返回-1
    int balanceHeight(TreeNode root){
        if(root==null)
            return 0;
        int left=balanceHeight(root.left);
        int right=balanceHeight(root.right);
        if(left<0||right<0||Math.abs(left-right)>1)
            return -1;
        return Math.max(left,right)+1;
    }
}