//在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。

//Java,时间复杂度O(n),空间复杂度O(1)
//我们注意到数组中的数字都在0到n-1中。如果这个数组中没有重复的数字，那么当数组排序之后数字i将出现在下标为i的位置。由于数组中有重复的数字，有些位置可能存在多个数字，同时有些位置可能没有数字。
//现在让我们重排这个数组，依然从头到尾一次扫描这个数组中的每个数字。当扫描到下标为i的数字时，首先比较这个数字（用m表示）是不是等于i。如果是，接着扫描下一个数字。如果不是，再拿它和第m个数字进行比较。
//　　如果它和第m个数字相等，就找到了一个重复的数字（该数字在下标为i和m的位置都出现了）。如果它和第m个数字不相等，就把第i个数字和第m个数字交换，把m放到属于它的位置。接下来再重读这个比较、交换的过程，直到我们发现一个重复的数字
public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int v;
    	for(int i=0;i<length;){
            v=numbers[i];
            if(i!=v){
                if(numbers[v]==v){
                    duplication[0]=v;
                    return true;
                }
                numbers[i]=numbers[v];
                numbers[v]=v;
                continue;
            }
            i++;
        }
        return false;
    }
}

//C++
class Solution {
public:
    // Parameters:
    //        numbers:     an array of integers
    //        length:      the length of array numbers
    //        duplication: (Output) the duplicated number in the array number
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    bool duplicate(int numbers[], int length, int* duplication) {
        int v;
        for(int i=0;i<length;){
            v=numbers[i];
            if(v!=i){
                if(numbers[v]==v){
                    *duplication=v;
                    return true;
                }
                numbers[i]=numbers[v];
                numbers[v]=v;
            }
            i++;
        }
        return false;
    }
};
