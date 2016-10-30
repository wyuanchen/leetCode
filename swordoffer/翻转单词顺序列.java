// 题目描述
// 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？

//Java
//先翻转所有字符，再逐个单词翻转
//时间复制度O(n),空间复杂度O(1)
public class Solution {
    public String ReverseSentence(String str) {
        if(str==null)
            return null;
        char[] chars=str.toCharArray();
        swap(chars,0,chars.length-1);
        int begin=0,end=0;
        while(begin<chars.length){
            while(begin<chars.length&&chars[begin]==' ')
                begin++;
            end=begin+1;
            while(end<chars.length&&chars[end]!=' ')
                end++;
			swap(chars,begin,end-1);
            end++;
            begin=end;
        }
        return new String(chars);
    }
    private void swap(char[] chars,int left,int right){
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



//C++
//先翻转所有字符，再逐个单词翻转
class Solution {
public:
    string ReverseSentence(string str) {
        reverse(str,0,str.length()-1);
        int length=str.length();
        int begin=0,end=0;
        while(begin<length){
            if(str[begin]==' '){
                begin++;
                end=begin;
            }else if(end==length||str[end]==' '){
                reverse(str,begin,end-1);
                end++;
                begin=end;
            }else{
                end++;
            }
        }
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
