class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }

        int[] result = new int[n - k + 1];
        int resultIndex = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove elements that are out of the current window range
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current element to the deque
            deque.offerLast(i);

            // Store the maximum element in the result array
            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
/* Time Complexity: O(n)
* Space Complexity: O(k)
*/
