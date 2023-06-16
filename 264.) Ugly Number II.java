class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;

        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;

        for (int i = 1; i < n; i++) {
            int min = Math.min(factor2, Math.min(factor3, factor5));
            uglyNumbers[i] = min;

            if (min == factor2) {
                index2++;
                factor2 = 2 * uglyNumbers[index2];
            }
            if (min == factor3) {
                index3++;
                factor3 = 3 * uglyNumbers[index3];
            }
            if (min == factor5) {
                index5++;
                factor5 = 5 * uglyNumbers[index5];
            }
        }

        return uglyNumbers[n - 1];
    }
}
/* Time Complexity: O(n)
* Space Complexity: O(n)
*/
