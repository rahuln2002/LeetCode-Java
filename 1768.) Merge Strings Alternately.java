class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int min = 0;
        if (m < n) {
            min = m;
        }
        else {
            min = n;
        }
        String s = "";
        for (int i = 0; i < min; i++) {
            s = s + word1.charAt(i);
            s = s + word2.charAt(i);
        }
        s = s + word1.substring(min) + word2.substring(min);
        return s;
    }
}
/* Time Complexity: O(n)
* Space Complexity: O(1)
*/
