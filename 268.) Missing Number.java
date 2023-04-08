class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0;
        while(n>low) {
            int mid = low + (n-low) / 2;
            if(nums[mid] > mid) {
                n = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return n;
    }
}
/* Time Complexity: O(N)
* Space Complexity: O(1)
*/
