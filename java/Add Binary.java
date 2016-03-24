
67. Add Binary
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".



public class Solution {
    public String addBinary(String a, String b) {
         StringBuilder result=new StringBuilder();
         int i=a.length()-1;
         int j=b.length()-1;
         int sum=0;
         for(;i>=0||j>=0;i--,j--){
             sum+=(i>=0?a.charAt(i)-'0':0);
             sum+=(j>=0?b.charAt(j)-'0':0);
             result.append(sum%2);
             sum/=2;
         }
         if(sum>0)
            result.append(1);
        return result.reverse().toString();
        
    }
    
}