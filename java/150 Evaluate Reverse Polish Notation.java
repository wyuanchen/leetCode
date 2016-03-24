150. Evaluate Reverse Polish Notation
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6



  
public class Solution {
    public int evalRPN(String[] tokens) {
        int result=0;
        int left=0;
        int right=0;
        int flag=0;
        Stack<Integer> stack=new Stack<Integer>();
        for(String s:tokens){
            flag=isOperator(s);
            if(flag==0){
                stack.push(Integer.valueOf(s));
            }else{
                right=stack.pop();
                left=stack.pop();
                switch(flag){
                    case 1:
                        result=left+right;
                        break;
                    case 2:
                        result=left-right;
                        break;
                    case 3:
                        result=left/right;
                        break;
                    case 4:
                        result=left*right;
                        break;
                }
                stack.push(result);
            }    
        
        }
        if(!stack.empty()){
            result=Integer.valueOf(stack.pop());
        }
        return result;
        
    }
    private int isOperator(String s){
        if(s.length()==1){
            switch(s.charAt(0)){
                case '+':
                    return 1;
                    
                case '-':
                    return 2;
                case '/':
                    return 3;
                case '*':
                    return 4;
                default:
                    return 0;
            }
        }else
            return 0;
    }
}