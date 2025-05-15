class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        
        List<String> to_return = new ArrayList<>();


        to_return.add(words[0]);
        int current_state = groups[0];


        for (int i = 1; i < words.length ; i++){

            if (groups[i] != current_state) {
                to_return.add(words[i]);
                current_state = groups[i];
            }
        }
       
        return to_return;
    }
}