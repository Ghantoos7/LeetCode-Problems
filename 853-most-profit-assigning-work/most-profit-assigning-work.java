class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int max_profit = 0;

        for (int i = 0; i < worker.length ; i++){

            int max_profit_per_worker = 0 ;

            for (int j = 0 ; j < profit.length ; j++){
                

                if (worker[i] >= difficulty[j]){

                max_profit_per_worker = Math.max(max_profit_per_worker, profit[j]);
                
                }



            }
       

            max_profit += max_profit_per_worker;

        }    return max_profit;
    }


}