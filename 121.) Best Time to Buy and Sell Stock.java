class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(prices==null||n<=1) {
            return 0;
        }

        int min=prices[0];
        int result=0;

        for(int i=1; i<n; i++) {
            result = Math.max(result, prices[i]-min);
            min = Math.min(min, prices[i]);
        }

        return result;
    }
}
/* Time Complexity: O(N)
* Space Complexity: O(1)
*/
