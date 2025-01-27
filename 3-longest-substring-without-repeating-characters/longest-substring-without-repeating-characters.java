class Solution {
    public int lengthOfLongestSubstring(String s) {

    if (s.length() == 0){
        return 0;
    }

    int left = 0;
    int right = 0;

    int count = 0;
    int max = 0;

    HashSet<Character> charSet = new HashSet<>();

    while (right < s.length()){
        if (!charSet.contains(s.charAt(right))){
            count++;
            max = Math.max(max,count);
            charSet.add(s.charAt(right));
            right++;
        }
        else{
            left++;
            right = left;
            count = 0;
            charSet.clear();
        }
    
    }

            return max;

    }
    
}