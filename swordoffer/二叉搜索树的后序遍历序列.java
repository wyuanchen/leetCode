题目描述
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同

//分治法
//思路：给定一个序列，则最后一个数应该为根，则从序列的开始位置到最后第二个数的情况有3种：
//（1） 全部小于根
//（2） 全部大于根
//（3） 前面某一段小于根，然后剩下的全大于根
//满足这3种之一的就是符合搜索二叉树
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length<=0)
            return false;
        return bstHelp(sequence,0,sequence.length-1);
    }

    private boolean bstHelp(int[] sequence,int start,int end){
        if(start>=end)
            return true;
        int root=sequence[end];
        int i=start;
        while(i<end-1){
            if(sequence[i]>root){
                break;
            }
            i++;
        }
        for(int j=i;j<end-1;j++){
            if(sequence[j]<=root)
                return false;
        }
		return bstHelp(sequence,start,i-1)&&bstHelp(sequence,i,end-1);
    }
}
