/*
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
*/  



import java.util.*;


/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

//BFS，使用队列
public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    	if (pRoot == null){
            return result;
        }
        TreeNode flag = new TreeNode(0);
        TreeNode cur;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> line = new ArrayList<>();
        queue.add(pRoot);
        queue.add(flag);
        while (!queue.isEmpty()){
            cur = queue.poll();
            if (cur != flag){
                line.add(cur.val);
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }else{
                result.add(line);
                if (!queue.isEmpty()){
                    line = new ArrayList<>();
                    queue.offer(flag);
                }
            }
        }
        return result;
    }
    
}