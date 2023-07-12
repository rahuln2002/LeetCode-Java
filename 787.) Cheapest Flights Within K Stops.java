class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[k + 2][n];
        final int INF = 1_000_000;
        
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        
        for (int i = 0; i <= k + 1; i++) {
            dp[i][src] = 0;
        }
        
        for (int i = 1; i <= k + 1; i++) {
            for (int[] flight : flights) {
                int source = flight[0];
                int destination = flight[1];
                int price = flight[2];
                
                if (dp[i - 1][source] != INF) {
                    dp[i][destination] = Math.min(dp[i][destination], dp[i - 1][source] + price);
                }
            }
        }
        
        int minCost = INF;
        for (int i = 1; i <= k + 1; i++) {
            minCost = Math.min(minCost, dp[i][dst]);
        }
        
        return (minCost == INF) ? -1 : minCost;
    }
}
/* Time Complexity: O(k * E)
* Space Complexity: O(k * n)
*/
