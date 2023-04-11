class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int col = mat[0].length;
        if(row == 0 || (r * c != row * col)) {
            return mat;
        }

        int[][] reshaped=new int[r][c];
        int k = 0;

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                reshaped[k/c][k%c] = mat[i][j];
                k++;
            }
        }
        return reshaped;
    }
}
/* Time Complexity: O(rc)
* Space Complexity: O(rc)
*/
