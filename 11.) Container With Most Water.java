class Solution {
    public int maxArea(int[] height) {
        int max_area = Integer.MIN_VALUE;
        int min_area;
        int l = 0;
        int r = height.length - 1;
        while(l < r) {
            min_area = Math.min(height[l], height[r]);
            max_area = Math.max(max_area, min_area * (r - l));
            if(height[l] < height[r]) {
                l++;
            }
            else {
                r--;
            }
        }
        return max_area;
    }
}
/* Time Complexity: O(n)
* Space Complexity: O(1)
*/
