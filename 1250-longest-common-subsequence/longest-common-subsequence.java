class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int text1_size = text1.length();
        int text2_size = text2.length();

        int [][] dp = new int[text1_size+1][text2_size+1];

        for(int i = 1; i < text1_size+1; i++){
            for(int j = 1; j < text2_size+1; j++){
                
                if (text1.charAt(i-1) == (text2.charAt(j-1))){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }

        }
        return dp[text1_size][text2_size];
    }

}