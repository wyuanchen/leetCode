105. Construct Binary Tree from Preorder and Inorder Traversal

    Total Accepted: 71188
    Total Submissions: 240633
    Difficulty: Medium

Given preorder and inorder traversal of a tree, construct the binary tree.



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//分治法,大概思路就是对于每一组preorder和inorder，都先提取出一个根，
//然后截取对应该根的左子树的preorder与inorder和右子树的preorder与inorder分别递归调用buildHelp来构造左子树和右子树,
//其中用Map按照inorder的值来存储对应的下标
public class Solution {
   public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)
            return null;
        int preEnd=preorder.length-1;
        int inEnd=inorder.length-1;
        Map<Integer,Integer> pos=new HashMap<Integer,Integer>();
        for(int i=0;i<=inEnd;i++){
            pos.put(inorder[i],i);
        }
        return buildHelp(preorder,inorder,0,preEnd,0,inEnd,pos);
     
    }
    
    public TreeNode buildHelp(int[] preorder,int[] inorder,int preStart,int preEnd,int inStart,int inEnd,Map<Integer,Integer> inorderPos){
        if(preEnd<preStart)
            return null;
        int rootValue=preorder[preStart];
        TreeNode root=new TreeNode(rootValue);
        int i=inorderPos.get(rootValue);
        root.left=buildHelp(preorder,inorder,preStart+1,preStart+i-inStart,inStart,i-1,inorderPos);
        root.right=buildHelp(preorder,inorder,preStart+i-inStart+1,preEnd,i+1,inEnd,inorderPos);
        return root;
    }
 
}