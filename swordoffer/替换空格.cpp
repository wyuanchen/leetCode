
题目描述
请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。


c++ 时间复杂度 O(n)
//length为牛客系统规定字符串输出的最大长度，固定为一个常数
class Solution {
public:
	void replaceSpace(char *str,int length) {
		if(str==NULL&&length<=0)
            return;
        int originLength=0;
        int numOfBlock=0;
        for(int i=0;str[i]!='\0';i++){
            originLength++;
            if(str[i]==' ')
                numOfBlock++;
        }
        int newLength=originLength+numOfBlock*2;
        if(newLength>length)
            return;
        while(originLength>=0){
            if(str[originLength]!=' ')
                str[newLength--]=str[originLength];
            else{
                str[newLength--]='0';
                str[newLength--]='2';
                str[newLength--]='%';
            }
            originLength--;
        }
	}
};


//java，模仿c++解法，不如下面一种
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	int originLength=str.length()-1;
        int newLength=0,numOfBlock=0;
        for(int i=0;i<=originLength;i++){
            if(str.charAt(i)==' ')
                numOfBlock++;
        }
        newLength=originLength+2*numOfBlock;
        str.setLength(newLength+1);
        while(originLength>=0){
            if(str.charAt(originLength)!=' ')
                str.setCharAt(newLength--,str.charAt(originLength));
            else{
                str.setCharAt(newLength--,'0');
                str.setCharAt(newLength--,'2');
                str.setCharAt(newLength--,'%');
            }
            originLength--;
        }
        return str.toString();
    }
}

//java
public class Solution {
    public String replaceSpace(StringBuffer str) {
        if(str==null){
            return null;
        }
       StringBuilder newStr = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                newStr.append('%');
                newStr.append('2');
                newStr.append('0');
            }else{
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }
}
