class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
/* Time Complexity: O(1)
* Space Complexity: O(1)
*/
