91. Decode Ways  QuestionEditorial Solution  My Submissions
Total Accepted: 79777
Total Submissions: 441431
Difficulty: Medium
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.


时间复杂度O(N),空间复杂度O(1)
设f(i)为从0到第i个这一段的解码的方式总数量,
分为三种情况:
1.s[i]只能自己单独解码，则 f(i)=f(i-1);
2.s[i]只能和s[i-1]结合起来才能解码,则f(i)=f(i-2);
3.s[i]既可以自己单独解码，也可以和s[i-1]结合起来解码,则f(i)=f(i-1)+f(i-2);
因为s[i]最多只能和前一个结合起来，所以上面三种情况已经全部考虑到所有解的情况了
public class Solution {
    public int numDecodings(String s) {
        int length=s.length();
        if(length<1||s.charAt(0)=='0')
            return 0;
        int len1=1,len2=1,temp;
        char c1,c2;
        c1=s.charAt(0);
        for(int i=1;i<length;i++){
            c2=s.charAt(i);
            if(c1=='0'||c1>'2'){
                if(c2=='0')
                    return 0;
                len1=len2;
            }else{
                if(c2=='0'){
                    temp=len2;
                    len2=len1;
                    len1=len2;
                }else if(c1=='1'){
                    temp=len2;
                    len2+=len1;
                    len1=temp;
                }else{
                    if(c2>'6'){
                        len1=len2;
                    }else{
                        temp=len2;
                        len2+=len1;
                        len1=temp;
                    }
                }
            }
            c1=c2;
        }
        return len2;
    }
}
