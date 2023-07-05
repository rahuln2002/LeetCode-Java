class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        
        while (k > 0) {
            int steps = calculateSteps(n, curr, curr + 1);
            
            if (steps <= k) {
                curr++;
                k -= steps;
            } else {
                curr *= 10;
                k--;
            }
        }
        
        return curr;
    }
    private int calculateSteps(int n, long curr, long next) {
        int steps = 0;
        
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        
        return steps;
    }
}
/* Time Complexity: O(log n)
* Space Complexity: O(1)
*/
