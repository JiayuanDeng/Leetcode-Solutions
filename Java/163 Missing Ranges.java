public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new LinkedList<String>();
        if (nums == null) return list;
        if (nums.length == 0){
            addRange(list, (long)lower, (long)upper);
            return list;
        }
        addRange(list, (long)lower, (long)nums[0] - 1);
        for (int i = 1; i < nums.length; i++){
            addRange(list, (long)nums[i - 1] + 1, (long)nums[i] - 1);
        }
        addRange(list, (long)nums[nums.length - 1] + 1, (long)upper);
        return list;
    }
    
    public void addRange(List<String> list, long l, long u){
        if (u - l > 0){
            list.add(l + "->" + u);
        }
        else if (u - l == 0){
            list.add(l + "");
        }
    }
}