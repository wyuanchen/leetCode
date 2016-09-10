题目描述
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构)

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
//递归，分治法
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null||root2==null)
            return false;
        return isSame(root1,root2)||HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }
    private boolean isSame(TreeNode r1,TreeNode r2){
        if(r2==null)
            return true;
        if(r1==null)
            return false;
        if(r1.val!=r2.val)
            return false;
        return isSame(r1.left,r2.left)&&isSame(r1.right,r2.right);
    }
}
