class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hash=new HashSet<>();
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                char c = board[i][j];
                if (!hash.add(c + "@row" + i) || !hash.add(c + "@col" + j) || !hash.add(c + "@box" + i / 3 + j / 3)) {
                    return false;
                }
            }
        }
        return true;
    }
}
/* Time Complexity: O(1)
* Space Complexity: O(1)
*/
