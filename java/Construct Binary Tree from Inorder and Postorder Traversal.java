106. Construct Binary Tree from Inorder and Postorder Traversal

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // 参考Construct Binary Tree from Preorder and Inorder Traversal的思路，两题思路都一样。
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0)
            return null;
        int inEnd=inorder.length-1;
        int postEnd=postorder.length-1;
        Map<Integer,Integer> pos=new HashMap<Integer,Integer>();
        for(int i=0;i<=inEnd;i++){
            pos.put(inorder[i],i);
        }
        return buildHelp(inorder,postorder,0,inEnd,0,postEnd,pos);
    }

    private TreeNode buildHelp(int[] inorder,int[] postorder,int inStart,int inEnd,int postStart,int postEnd,Map<Integer,Integer> pos){
        if(inStart>inEnd)
            return null;
        int rootValue=postorder[postEnd];
        int rootIndex=pos.get(rootValue);
        TreeNode root=new TreeNode(rootValue);
        root.left=buildHelp(inorder,postorder,inStart,rootIndex-1,postStart,postStart+rootIndex-inStart-1,pos);
        root.right=buildHelp(inorder,postorder,rootIndex+1,inEnd,postStart+rootIndex-inStart,postEnd-1,pos);
        return root;
    }
}
