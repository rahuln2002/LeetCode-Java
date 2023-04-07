class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int i = 0;
        while (i < len - 2) {
            if (nums[i] == nums[i+1]) {
                i += 2;
            }
            else {
                return nums[i];
            }
        }
        return nums[len - 1];
    }
}
/* Time Complexity: O(N logN)
* Space Complexity: O(1)
*/
