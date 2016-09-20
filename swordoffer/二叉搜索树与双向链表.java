题目描述
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。


//java 空间复杂度O(1)
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public TreeNode Convert(TreeNode root) {
        return convertHelp(root,true);
    }

    //把以root为根的二叉搜索树变成双向链表，direction为true则返回链表的头部，反之返回链表的尾部
    private TreeNode convertHelp(TreeNode root,boolean direction){
        if(root==null)
            return null;
        TreeNode left=convertHelp(root.left,false);
        TreeNode right=convertHelp(root.right,true);
        root.left=left;
        root.right=right;
        if(left!=null)
            left.right=root;
        if(right!=null)
            right.left=root;
        if(direction){
            while(root.left!=null)
                root=root.left;
            return root;
        }else{
            while(root.right!=null)
                root=root.right;
            return root;
        }

    }
}
