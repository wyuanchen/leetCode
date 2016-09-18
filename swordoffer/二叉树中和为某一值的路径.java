题目描述
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

//后序遍历，用一个ArrayList来保存当前遍历的路径，每进入一个节点，则先将该节点加入当前路径中，如果该路径已经到达叶子节点并且符合要求，就使其添加到结果List中，
//每退出一个节点，则把该节点从当前路径删除
import java.util.ArrayList;
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
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> paths=new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return paths;
        ArrayList<Integer> curPath=new ArrayList<Integer>();
        findHelp(root,curPath,paths,0,target);
        return paths;
    }
    private void findHelp(TreeNode root,ArrayList<Integer> curPath,ArrayList<ArrayList<Integer>> paths,int curSum,int target){
        curPath.add(root.val);
        curSum+=root.val;
        if(root.left==null&&root.right==null){
            if(curSum==target){
                paths.add((ArrayList<Integer>)curPath.clone());
            }
            curPath.remove(curPath.size()-1);
            return;
        }
        if(root.left!=null)
            findHelp(root.left,curPath,paths,curSum,target);
        if(root.right!=null)
            findHelp(root.right,curPath,paths,curSum,target);
        curPath.remove(curPath.size()-1);
    }
}
