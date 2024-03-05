class Solution {
    public int minimumLength(String s) {

        int size = s.length();


        int left = 0;
        int right = size - 1;


        while (left < right && s.charAt(left) == s.charAt(right)){

            while (s.charAt(left+1) == s.charAt(left) && left + 1  != right){
                left++;
            }

            while (s.charAt(right-1) == s.charAt(right) && right - 1 != left){
                right--;
            }

            left++;
            s = s.substring(left,right);

            left = 0;
            right = s.length() - 1;


        }

        return s.length();
        
    }
}