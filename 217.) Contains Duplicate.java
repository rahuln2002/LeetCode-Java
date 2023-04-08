class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        if(nums==null || n==0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<n;i++) {
            if(!set.add(nums[i])) {
                return true;
            }
        }
    return false;
    }
}
/* Time Complexity: O(n)
* Space Complexity: O(n)
*/
