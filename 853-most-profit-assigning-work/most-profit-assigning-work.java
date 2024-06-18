class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(worker);
        
        int maxProfit = 0, maxProfitPerWorker = 0, j = 0;
        
        for (int i = 0; i < worker.length; i++) {
            while (j < n && worker[i] >= jobs[j][0]) {
                maxProfitPerWorker = Math.max(maxProfitPerWorker, jobs[j][1]);
                j++;
            }
            maxProfit += maxProfitPerWorker;
        }
        
        return maxProfit;
    }


}