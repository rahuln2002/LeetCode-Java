class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = m + n;
        int[] a=new int[k];
        int i=0;
        int j=0;
        int f=0;
        while(i < m) {
            a[f++] = nums1[i++];
        }
        while(j < n) {
            a[f++] = nums2[j++];
        }
        Arrays.sort(a);
        if(k % 2 == 0) {
            return ((double)(a[(k/2)-1] + a[((k/2))]) / 2);
        }
        else {
            return (a[k/2]);
        }
    }
}
/* Time Complexity: O(n+m)
* Space Complexity: O(n+m)
*/
