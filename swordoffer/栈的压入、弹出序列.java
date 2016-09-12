题目描述
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
      	Stack<Integer> stack=new Stack<Integer>();
        int j=0;
        for(int i=0;i<pushA.length;){
            if(stack.empty()||popA[j]!=stack.peek()){
                stack.push(pushA[i]);
            	i++;
            }
           	else{
                stack.pop();
                j++;
            }
        }
        int top;
        for(;j<popA.length;j++){
            top=stack.pop();
            if(top!=popA[j])
                return false;
        }
        if(stack.empty())
            return true;
        return false;
    }
}
