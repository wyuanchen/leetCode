//给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。


import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(num==null||size<=0)
            return result;
        for(int startIndex=0,maxIndex=-1;startIndex+size<=num.length;startIndex++){
            maxIndex=maxHelp(num,startIndex,maxIndex,size);
            result.add(num[maxIndex]);
        }
        return result;
    }

    private int maxHelp(int[] num,int startIndex,int maxIndex,int size){
		if(maxIndex>=startIndex){
            maxIndex=num[maxIndex]>num[startIndex+size-1]?maxIndex:startIndex+size-1;
        }else{
			maxIndex=startIndex;
            for(int i=1;i<size;i++){
                if(num[maxIndex]<=num[startIndex+i])
                    maxIndex=startIndex+i;
            }
        }
        return maxIndex;
    }
}
