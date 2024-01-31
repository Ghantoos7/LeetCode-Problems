class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] answer = new int[size]; 

        answer[size-1] = 0; 

        for (int i = size - 2; i >= 0; i--){
            if (temperatures[i] >= temperatures[i+1]){

                int j = i + 1;

                while (temperatures[i] >= temperatures[j]){


                    if (answer[j] == 0) { 
                        break;
                    }
                    
                    j += answer[j]; 
                }

                if (temperatures[i] < temperatures[j]) {
                    answer[i] = j - i; 
                }
             

            }
             else {
                answer[i] = 1; 
            }
        }
        return answer;
    }
}
