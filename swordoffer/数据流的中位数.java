/*
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
*/   

//用两个堆来实现
import java.util.*;
public class Solution {

    private Queue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>(){
        public int compare(Integer a, Integer b){
            return b - a;
        }
    });
    
    private Queue<Integer> minHeap = new PriorityQueue<>();
    
    private int count = 0;
    
    public void Insert(Integer num) {
        count++; 
    	if (count % 2 != 0){
			minHeap.offer(num);
            num = minHeap.poll();
            maxHeap.offer(num);
        }else{
            maxHeap.offer(num);
            num = maxHeap.poll();
            minHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if (count == 0){
            return 0.0;
        }
		if (count % 2 != 0){
            Integer mid = maxHeap.peek();
            return (double)mid;
        }else{
            Integer a = maxHeap.peek();
            Integer b = minHeap.peek();
            return new Double(a + b) / 2.0;
        }        
    }


}