class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (k > 0 && !minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            int num1 = pair[0];
            int num2 = pair[1];
            int index2 = pair[2];

            result.add(Arrays.asList(num1, num2));

            if (index2 + 1 < nums2.length) {
                minHeap.offer(new int[]{num1, nums2[index2 + 1], index2 + 1});
            }

            k--;
        }

        return result;
    }
}
/* Time Complexity: O(k log k)
* Space Complexity: O(k)
*/
