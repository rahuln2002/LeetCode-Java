/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        while(low <= n) {
            int mid = low + (n - low) / 2;
            if(isBadVersion(mid)) {
                n = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}
/* Time Complexity: O(N)
* Space Complexity: O(1)
*/
