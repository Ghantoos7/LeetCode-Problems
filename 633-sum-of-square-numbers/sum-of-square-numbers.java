class Solution {
    public boolean judgeSquareSum(int c) {
       
    long left = 0, right = (long)Math.sqrt(c);

    while (left <= right){
        
        long sum_squared = left * left + right * right;
        if (sum_squared == c){
            return true;
        }
        else if (sum_squared < c){
            left++;
        }
        else{
            right--;
        }
    }

    return false;

    }
}