71. Simplify Path
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Subscribe to see which companies asked this question

Show Tags


public class Solution {
    
    public String simplifyPath(String path) {
        StringBuilder result=new StringBuilder();
        Stack<String> stack=new Stack<String>();
        for(int i=0,j=0;i<path.length();){
            if(path.charAt(i)=='/'){
                for(j=i+1;j<path.length()&&path.charAt(j)!='/';j++);
                String temp=path.substring(i+1,j);
                if(temp.equals("..")){
                    if(!stack.empty()){
                        stack.pop();
                    }
                }else if(!temp.equals(".")&&!temp.equals("")){
                    stack.push(temp);
                }
            i=j;
            }
        }
        for(String s:stack){
            result.append("/"+s);
        }
        return result.length()>0?result.toString():"/";        
    }
}