class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] arr = new int[2];
        HashMap<Integer, Integer> table = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (table.containsKey(complement)) {
                arr[0] = table.get(complement);
                arr[1] = i;
                return arr;
            }
            table.put(nums[i], i);
        }

        return arr;
    }
}

