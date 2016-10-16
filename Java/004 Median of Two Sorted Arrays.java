public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i, m, n;
        int len = (nums1.length + nums2.length) / 2 + 1;
        int[] nums = new int[len];
        m = n = 0;
        
        for(i = 0; i < len; i++){
            if (m >= nums1.length){
                nums[i] = nums2[n];
                n++;
            }
            else if (n >= nums2.length){
                nums[i] = nums1[m];
                m++;
            }
            else if (nums1[m] >= nums2[n]){
                nums[i] = nums2[n];
                n++;
                
            }
            else{
                nums[i] = nums1[m];
                m++;
            }
        }
        
        double median;
        if ((nums1.length + nums2.length) % 2 == 1) median = nums[len - 1];
        else median = (double)(nums[len - 1] + nums[len - 2]) / 2;
        return median;
    }
}