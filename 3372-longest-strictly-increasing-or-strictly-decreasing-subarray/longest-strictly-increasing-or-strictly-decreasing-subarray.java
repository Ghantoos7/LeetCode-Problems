class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        
        int n = nums.length;

        int[] dpincreas = new int[n];
        int[] dpdecreas = new int[n];

        Arrays.fill(dpincreas, 1);
        Arrays.fill(dpdecreas, 1);

        for (int i = 1; i < n; i++){
            if (nums[i] > nums[i-1]){
                dpincreas[i] = dpincreas[i] + dpincreas[i-1];
            }
            else if (nums[i] < nums[i-1]){
                dpdecreas[i] = dpdecreas[i] + dpdecreas[i-1];
            }
           
        }

        int maxd = Arrays.stream(dpdecreas).max().orElse(Integer.MIN_VALUE);
        int maxi = Arrays.stream(dpincreas).max().orElse(Integer.MIN_VALUE);

        return Math.max(maxd,maxi);


    }


}