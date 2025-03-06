class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        int n = grid.length;
        int size = n * n;

        int[] count = new int[size + 1];
        int[] to_return = new int[2];
        int index = 1;
        
        for (int i = 0; i < n; i++){

            for (int j = 0; j < n; j++){

                count[grid[i][j]]++; 
            }
        }

        for (int i = 1; i < size + 1; i++){

            if (count[i] == 2){
                to_return[0] = i;
            }
            else if (count[i] == 0){
                to_return[1] = i;


            }
        }

        return to_return;

         
    }
}