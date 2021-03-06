题目描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。


//c++ 利用二分法
class Solution {
public:
    int minNumberInRotateArray(vector<int> rotateArray) {
        if(rotateArray.size()==0)
          return 0;
        int r=rotateArray.size()-1;
        int l=0;
        int mid=0;
        while(l<r){
            if(rotateArray[r]>rotateArray[l])
                return rotateArray[l];
            if(r-l==1)
                break;
            mid=(r+l)/2;
            if(rotateArray[mid]==rotateArray[l]&&rotateArray[mid]==rotateArray[r]){
                int min=l;
                for(int i=l+1;i<=r;i++){
                    if(rotateArray[i]<rotateArray[min])
                        min=i;
                }
                return rotateArray[min];
            }
            else if(rotateArray[mid]>=rotateArray[l]){
                l=mid;
            }else{
                r=mid;
            }
        }
        return rotateArray[r];

    }
};
