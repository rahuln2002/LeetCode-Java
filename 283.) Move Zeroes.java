class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int zeroes = 0;
        for(int i=0;i<n;i++) {
            if(nums[i] == 0) {
                zeroes++;
            }
            else if(zeroes>0) {
                int temp=nums[i];
                nums[i] = nums[i-zeroes];
                nums[i-zeroes] = temp;
            }
        }
    }
}
/* Time Complexity: O(n)
* Space Complexity: O(1)
*/
