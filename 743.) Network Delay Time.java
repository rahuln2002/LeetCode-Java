class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n + 1][n + 1];
        for (int[] row : graph) {
            Arrays.fill(row, -1);
        }
        for (int[] time : times) {
            int source = time[0];
            int target = time[1];
            int delay = time[2];
            graph[source][target] = delay;
        }
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int currentNode = node[0];
            int currentDistance = node[1];

            if (currentDistance > distance[currentNode]) {
                continue;
            }

            for (int i = 1; i <= n; i++) {
                if (graph[currentNode][i] != -1) {
                    int newDistance = currentDistance + graph[currentNode][i];
                    if (newDistance < distance[i]) {
                        distance[i] = newDistance;
                        pq.offer(new int[]{i, newDistance});
                    }
                }
            }
        }

        int maxDelay = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxDelay = Math.max(maxDelay, distance[i]);
        }

        return maxDelay;
    }
}
/* Time Complexity: O(n^2 log n)
* Space Complexity: O(n)
*/
