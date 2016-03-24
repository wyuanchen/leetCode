84. Largest Rectangle in Histogram
/*Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
The largest rectangle is shown in the shaded area, which has area = 10 unit.
For example,
Given heights = [2,1,5,6,2,3],
return 10.
*/
public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int maxArea=0;
        int currentArea=0;
        int j=0;
        int width=0;
        int length=heights.length;
        for(int i=0;i<length;i++){
            if(stack.empty()||heights[stack.peek()]<heights[i]){
                stack.push(i);
            }else{
                j=stack.pop();
                width=stack.empty()?i:i-stack.peek()-1;
                currentArea=heights[j]*width;
                maxArea=Math.max(maxArea,currentArea);
                i--;
            }
        }
        
        while(!stack.empty()){
            j=stack.pop();
            width=stack.empty()?length:length-stack.peek()-1;
            currentArea=heights[j]*width;
            maxArea=Math.max(currentArea,maxArea);
        }
        return maxArea;
    }
}


public int largestRectangleArea(int[] h) {
  int n = h.length, i = 0, max = 0;

  Stack<Integer> s = new Stack<>();

  while (i < n) {
    // as long as the current bar is shorter than the last one in the stack
    // we keep popping out the stack and calculate the area based on
    // the popped bar
    while (!s.isEmpty() && h[i] < h[s.peek()]) {
      // tricky part is how to handle the index of the left bound
      max = Math.max(max, h[s.pop()] * (i - (s.isEmpty() ? 0 : s.peek() + 1)));
    }
    // put current bar's index to the stack
    s.push(i++);
  }

  // finally pop out any bar left in the stack and calculate the area based on it
  while (!s.isEmpty()) {
    max = Math.max(max, h[s.pop()] * (n - (s.isEmpty() ? 0 : s.peek() + 1)));
  }

  return max;
}