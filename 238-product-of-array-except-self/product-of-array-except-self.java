class Solution {
    public int[] productExceptSelf(int[] nums) {
        

        int size = nums.length;

        if (size == 0 || size == 1){
            return nums;
        }
        int[] pre = prefixProduct(nums);
        int[] suf = suffixProduct(nums);

        int[] ans = new int[size];

        for (int i = 0; i < size; i++){
            ans[i] = pre[i] * suf[i];
        }

        return ans;

    }


    public int[] prefixProduct(int[] nums){
        int size = nums.length;

        int ans[] = new int[size];
        ans[size-1] = 1;

        for (int i = size - 2 ; i >= 0; i--){
            ans[i] = nums[i+1] * ans[i+1];
        }

        return ans;
    }

       public int[] suffixProduct(int[] nums){
        int size = nums.length;

        int ans[] = new int[size];
        ans[0] = 1;

        for (int i = 1 ; i < size ; i++){
            ans[i] = nums[i-1] * ans[i-1];
        }

        return ans;
    }
}