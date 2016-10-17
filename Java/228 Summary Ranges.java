public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new LinkedList<String>();
        if (nums == null || nums.length == 0) return list;
        if (nums.length == 1){
            addRange(list, nums[0], nums[0]);
            return list;
        }
        int low = nums[0];
        int high = nums[0];
        for (int i = 0; i < nums.length - 1; i++){
            if ((long)nums[i + 1] - (long)nums[i] > 1){
                addRange(list, low, high);
                low = nums[i + 1];
                high = nums[i + 1];
            }
            else{
                high = nums[i + 1];
            }
        }
        addRange(list, low, high);
        return list;
    }
    
    private void addRange(List<String> list, int low, int high){
        if (high > low)
            list.add(low + "->" + high);
        if (high == low)
            list.add(low + "");
    }
}