class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) { return 0; }
        int max_area = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
            }
            max_area = Math.max(max_area, largestRectangleArea(height));
        }
        return max_area;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max_area = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                max_area = Math.max(max_area, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            max_area = Math.max(max_area, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return max_area;
    }
}