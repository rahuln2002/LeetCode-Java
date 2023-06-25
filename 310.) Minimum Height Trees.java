class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }
        
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                leaves.offer(i);
            }
        }
        
        while (n > 2) {
            int leavesCount = leaves.size();
            n -= leavesCount;
            
            for (int i = 0; i < leavesCount; i++) {
                int leaf = leaves.poll();
                List<Integer> neighbors = graph.get(leaf);
                
                for (int neighbor : neighbors) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 1) {
                        leaves.offer(neighbor);
                    }
                }
            }
        }
        
        List<Integer> minHeightTrees = new ArrayList<>();
        while (!leaves.isEmpty()) {
            minHeightTrees.add(leaves.poll());
        }
        
        return minHeightTrees;
    }
}
/* Time Complexity: O(n)
* Space Complexity: O(n)
*/
