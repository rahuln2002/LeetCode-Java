class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> list=new ArrayList<String>();
        int n = nums.length;
        int start, end;
        for(int i=0;i<n;i++) {
            start = nums[i];
            while(i+1 < n && nums[i+1] == nums[i]+1) {
                i++;
            }
            end = nums[i];
            if(start == end) {
                list.add(start + "");
            }
            else {
                list.add(start + "->" + end);
            }
        }
        return list;
    }
}
/* Time Complexity: O(N)
* Space Complexity: O(1)
*/
