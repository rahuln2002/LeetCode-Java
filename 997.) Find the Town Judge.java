class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1];

        for (int[] relation : trust) {
            int personA = relation[0];
            int personB = relation[1];
            trustCount[personA]--;
            trustCount[personB]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
/* Time Complexity: O(T)
* Space Complexity: O(N)
*/
