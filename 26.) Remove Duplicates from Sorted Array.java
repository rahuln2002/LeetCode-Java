class Solution {
    public int removeDuplicates(int[] nums) {
        int[] r=new int[nums.length];
        int j=0;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i]!=nums[i+1]) {
                r[j++]=nums[i];
            }
        }
        r[j++] = nums[nums.length - 1];
 
        for (int i = 0; i < j; i++) {
            nums[i] = r[i];
        }
        return j;
    }
}
