题目描述
定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。


//要用多一个栈来存放最小值  push(),pop(),top(),min()的时间复杂度均为O(1)
import java.util.Stack;
public class Solution {
    private Stack<Integer> s=new Stack<Integer>();
    private Stack<Integer> mins=new Stack<Integer>();
    public void push(int node) {
        s.push(node);
        if(mins.empty())
            mins.push(node);
        else{
            int min=mins.peek();
            min=min<node?min:node;
            mins.push(min);
        }
    }

    public void pop() {
        s.pop();
        mins.pop();
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return mins.peek();
    }
}
