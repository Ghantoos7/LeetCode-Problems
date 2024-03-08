class Solution {
    public boolean isPalindrome(int x) {
        
        String s = ""+x;

        int left = 0;
        int right =  s.length() - 1;

        if (s.length() == 1 || s.length() == 0){
            return true;
        }

        while (left < right && s.charAt(left) == s.charAt(right) ){

            left++;
            right--;
        }

        return s.charAt(left) == s.charAt(right);


    }
}