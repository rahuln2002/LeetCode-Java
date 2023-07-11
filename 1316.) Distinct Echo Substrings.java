class Solution {
    public int distinctEchoSubstrings(String text) {
        HashSet<String> set = new HashSet<>();
        int n = text.length();
        char[] arr = text.toCharArray();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j += 2) {
                int len = (j - i + 1) / 2;
                if (isEqual(arr, i, j, len)) {
                    set.add(text.substring(i, j + 1));
                }
            }
        }

        return set.size();
    }

    private boolean isEqual(char[] arr, int i, int j, int len) {
        for (int k = 0; k < len; k++) {
            if (arr[i + k] != arr[i + len + k]) {
                return false;
            }
        }
        return true;
    }
}
/* Time Complexity: O(n ^ 2 * len)
* Space Complexity: O(n ^ 2)
*/
