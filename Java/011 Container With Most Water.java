public class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, max = 0, volume;
        while(i < j){
            // This is the best volume that the lower line can have
            volume = (j - i) * (height[i] < height[j] ? height[i++] : height[j--]);
            max = max > volume ? max : volume;
        }
        return max;
    }
}