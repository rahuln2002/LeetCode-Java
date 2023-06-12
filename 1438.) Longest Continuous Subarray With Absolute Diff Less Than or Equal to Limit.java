class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int maxLength = 0;

        Deque<Integer> maxQueue = new LinkedList<>();
        Deque<Integer> minQueue = new LinkedList<>();

        int left = 0;
        int right = 0;

        while (right < n) {
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < nums[right]) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(nums[right]);

            while (!minQueue.isEmpty() && minQueue.peekLast() > nums[right]) {
                minQueue.pollLast();
            }
            minQueue.offerLast(nums[right]);

            while (!maxQueue.isEmpty() && !minQueue.isEmpty() && maxQueue.peekFirst() - minQueue.peekFirst() > limit) {
                if (nums[left] == maxQueue.peekFirst()) {
                    maxQueue.pollFirst();
                }
                if (nums[left] == minQueue.peekFirst()) {
                    minQueue.pollFirst();
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);

            right++;
        }

        return maxLength;
    }
}
/* Time Complexity: O(n)
* Space Complexity: O(k)
*/
