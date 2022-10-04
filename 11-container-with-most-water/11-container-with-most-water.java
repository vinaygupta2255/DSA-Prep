class Solution {

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;

        while (start < end) {
            int w = end - start;
            int h = Integer.min(height[start], height[end]);
            int area = w * h;

            maxArea = Integer.max(area, maxArea);

            if (height[start] < height[end]) {
                start++;
            } else if (height[start] > height[end]) {
                end--;
            } else {
                start++;
                end--;
            }
        }
        return maxArea;
    }
}
