class Solution {
    public int maxArea(int[] height) {

        int min = 0;
        int maxArea = 0;
        int front = 0;
        int rear = height.length - 1;
        
        while(front < rear){
            int h = 0;
            int area = 0;
            if(height[front] < height[rear]){
                h = height[front];
                area = h * (rear - front);
                front++;
            }
            else{
                h = height[rear];
                area = h * (rear - front);
                rear--;
            }
            
            if(maxArea < area){
                maxArea = area;
            }
        }
        
        return maxArea;
    }
}
