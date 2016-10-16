import java.util.Hashtable;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();
        Integer j;
        for (int i = 0; i < nums.length; i++){
            if (hashtable.get(nums[i]) == null){
                hashtable.put(nums[i], i);
            }
            j = hashtable.get(target - nums[i]);
            if (j != null && j < i){
                return new int[]{j, i};
            }
        }
        return null;
    }
}