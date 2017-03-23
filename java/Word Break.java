139. Word Break  QuestionEditorial Solution  My Submissions
Total Accepted: 98625
Total Submissions: 372909
Difficulty: Medium
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".



Dynamic Programming
设状态为f(i)，表示{s[0,i-1]}是否可以分词，则状态转移方程为
f(i)=any_of(f(i+1-dict.length)&&s[i+1-dict.length,i]∈dict)
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int length=s.length();
        int dictLength=wordDict.size();
        String[] words=new String[dictLength];
        words=wordDict.toArray(words);
        boolean[] f=new boolean[length+1];
        f[0]=true;
        for(int i=0;i<length;i++){
            for(String word:wordDict){
                if(i+1-word.length()>=0&&f[i+1-word.length()]&&s.substring(i+1-word.length(),i+1).equals(word)){
                    f[i+1]=true;
                    break;
                }
            }
        }
        return f[length];
    }
}
