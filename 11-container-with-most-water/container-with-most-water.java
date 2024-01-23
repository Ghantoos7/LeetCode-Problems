class Solution {
    public int maxArea(int[] height) {
        
        int i = 0;
        int j = height.length - 1;
        int output = 0;

        while (i != j){

            if (height[i] <= height[j]){
                if ((j - i) * height[i] > output){
                    output = (j - i) * height[i];
                }
                i++;
            }
            else{

                if ((j - i) * height[j] > output){
                    output = (j - i) * height[j];

            }
            j--;

        }
    } 
     return output;
      } 
}