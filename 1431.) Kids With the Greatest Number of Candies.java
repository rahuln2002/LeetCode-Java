class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> result = new ArrayList<Boolean>();
        int n = candies.length;
        int max = candies[0];
        for(int i=1; i<n; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        for(int i=0; i<n; i++) {
            if ((candies[i] + extraCandies) >= max) {
                result.add(true);
            }
            else {
                result.add(false);
            }
        }
        return result;
    }
}
/* Time Complexity: O(N)
* Space Complexity: O(N)
*/
