//将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0

//Java
public class Solution {
    public int StrToInt(String str) {
        if(str==null||"".equals(str.trim()))
            return 0;
        int sign=1;
        char[] cs=str.trim().toCharArray();
        int result=0;
        if(cs[0]=='-'||cs[0]=='+')
            sign=-1;
        else if(cs[0]>='0'&&cs[0]<='9')
            result=result*10+(cs[0]-'0');
        else if(cs[0]!='+')
            return 0;
        for(int i=1;i<cs.length;i++){
            if(cs[i]<'0'||cs[i]>'9')
                return 0;
            result=result*10+(cs[i]-'0');
        }
        result*=sign;
        return result;
    }
}
