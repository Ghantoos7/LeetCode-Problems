class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0],b[0]));
        int count = 1;
        int start = points[0][0];

        for (int[] point : points){
            
            if(Math.abs(point[0] - start) > w){
                count += 1;
                start=point[0];
            }
        }
        return count;



        
    }
}