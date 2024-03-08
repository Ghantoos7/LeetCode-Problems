class Solution {
    public int maxFrequencyElements(int[] nums) {
        
        HashMap <Integer,Integer> frequency = new HashMap<>();

        int max = 0;
        int count = 0;

        for (int num : nums){
            frequency.put(num,frequency.getOrDefault(num,0) + 1);

            max = frequency.get(num) > max ? frequency.get(num) : max;
        }

        for (int num : nums){

            if (frequency.get(num) == max){
                count++;
            }
        }
        
        return count;

        
    }
}