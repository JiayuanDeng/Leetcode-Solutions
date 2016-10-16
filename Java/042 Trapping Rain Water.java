public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;
        int summitPos = 0;
        
        // Find the first summit
        for (int i = 0; i < height.length; i++){
            if (height[summitPos] < height[i]){
                summitPos = i;
            }
        }
        
        // Iterate from 0 to summitPos - 1
        int maxHeight = 0;
        int volume = 0;
        for (int i = 0; i < summitPos; i++){
            if (height[i] > maxHeight){
                maxHeight = height[i];
            }
            else{
                volume += maxHeight - height[i];
            }
        }
        
        // Iterate from length - 1 to summitPos + 1
        maxHeight = 0;
        for (int i = height.length - 1; i > summitPos; i--){
            if (height[i] > maxHeight){
                maxHeight = height[i];
            }
            else{
                volume += maxHeight - height[i];
            }
        }
        
        return volume;
    }
}