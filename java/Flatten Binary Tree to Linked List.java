114. Flatten Binary Tree to Linked List 
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

 //思路：先分别把左子树和右子树转化为符合题目链表顺序要求的树，
 //然后把根的右子节点设置为左子树的根节点，把左子树的最后一个节点的右子节点设置为原来右子树的根节点
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
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        TreeNode leftEnd=flattenHelp(root.left);
        flattenHelp(root.right);
        if(leftEnd!=null){
            TreeNode temp=root.right;
            root.right=root.left;
            root.left=null;
            leftEnd.right=temp;
        }
    }
    private TreeNode flattenHelp(TreeNode root){
        if(root==null)
            return null;
        TreeNode leftEnd=flattenHelp(root.left);
        TreeNode rightEnd=flattenHelp(root.right);
        if(leftEnd!=null){
            TreeNode temp=root.right;
            root.right=root.left;
            root.left=null;
            leftEnd.right=temp;
        }
        if(leftEnd==null&&rightEnd==null){
            return root;
        }else if(rightEnd==null){
            return leftEnd;
        }else{
            return rightEnd;
        }
    }
}