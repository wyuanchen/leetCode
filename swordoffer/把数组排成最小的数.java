// 题目描述
// 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。



//java
//本质是一个数组的排序问题，关键是定义好排序的标准
//涉及到大数问题，所以用字符串来处理
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        List<String> result=new ArrayList<String>(numbers.length);
        for(int num:numbers){
            result.add(String.valueOf(num));
        }
        //关键自定义排序用的比较器
        Comparator comparator=new Comparator(){
            public int compare(Object o1,Object o2){
                String a=(String)o1;
                String b=(String)o2;
                //按字典序比较大小
                return (a+b).compareTo(b+a);
            }
        };
        Collections.sort(result,comparator);
        StringBuilder max=new StringBuilder();
        for(String str:result){
            max.append(str);
        }
        return max.toString();
    }
}
