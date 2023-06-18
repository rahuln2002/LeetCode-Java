class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minHeap.offer(matrix[i][j]);
            }
        }

        int result = 0;
        for (int i = 0; i < k; i++) {
            result = minHeap.poll();
        }

        return result;
    }
}
/* Time Complexity: O(n^2 log n)
* Space Complexity: O(n ^ 2)
*/
