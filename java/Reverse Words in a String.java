/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
*/


//其实想法很简单，就是分两步：第一步就是把整个字符串倒过来，第二步就是再翻回来之后再把每个单词反转一次就好了。
//不过这题目还有一个坑就是最后返回的字符串头尾不能有空格，并且两个单词之间最多只能有一个空格，所以最后再调用一个cleanSpace()来处理掉这些空格
public class Solution {
    public String reverseWords(String s) {
        if(s==null)
            return null;
        char[] cs=s.trim().toCharArray();
        int len=cs.length;
        reverse(cs,0,len-1);
        int start=0;
        for(int i=1;i<len-1;i++){
        	if(cs[i]==' '){
        		reverse(cs,start,i-1);
        		start=i+1;
        	}
        }
        reverse(cs,start,len-1);
        return cleanSpace(cs);
 		       
    }

    public void reverse(char[] cs,int left,int right){
    	char temp;
    	while(left<right){
    		temp=cs[left];
    		cs[left]=cs[right];
    		cs[right]=temp;
    		left++;
    		right--;
    	}
    }

    public String cleanSpace(char[] cs){
    	int len=cs.length;
    	StringBuilder s=new StringBuilder();
    	for(int i=0;i<len;i++){
    		if(cs[i]!=' ')
    			s.append(cs[i]);
    		else if(cs[i]==' '&&i>0&&i<len&&cs[i-1]!=' ')
    			s.append(cs[i]);
    	}

    	return s.toString();
    }
}