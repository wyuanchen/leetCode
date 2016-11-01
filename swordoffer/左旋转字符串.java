// 题目描述
// 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！

//java
//思路与翻转单词顺序列一样,时间复杂度O(n)
public class Solution {
    public String LeftRotateString(String str,int n) {
        if(str==null||str.length()==0)
            return str;
        int length=str.length();
        n=n%length;
        char[] chars=str.toCharArray();
        reverse(chars,0,length-1);
        reverse(chars,0,length-1-n);
        reverse(chars,length-n,length-1);
        return new String(chars);
    }

    private void reverse(char[] chars,int left,int right){
        char temp;
        while(left<right){
            temp=chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
            left++;
            right--;
        }
    }
}


//c++
class Solution {
public:
    string LeftRotateString(string str, int n) {
        if(str.length()==0)
            return str;
        int length=str.length();
        n=n%length;
        reverse(str,0,length-1);
        reverse(str,0,length-1-n);
        reverse(str,length-n,length-1);
        return str;
    }
    void reverse(string& str,int left,int right){
        char temp;
        while(left<right){
            temp=str[left];
            str[left]=str[right];
            str[right]=temp;
            left++;
            right--;
        }
    }
};
