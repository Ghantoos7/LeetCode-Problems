class Solution {
    public int getCommon(int[] nums1, int[] nums2) {

        int left = 0 ,right = 0;

        int left_size = nums1.length;
        int right_size = nums2.length;

        if (nums1[left_size -1] < nums2[0] || nums2[right_size-1] < nums1[0]) return -1;    
        while (left < left_size && right < right_size){
            
            if (nums1[left] == nums2[right]) return nums1[left];
            else if (nums1[left] < nums2[right]) left++; 
            else right++;  
        }return -1;
    }
}