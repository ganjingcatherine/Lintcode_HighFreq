public class Solution {
    /*
     * @param matrix: a lists of integers
     * @return: 
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return ;
        }
        
        // CW: flip up and down, then mirror along diagonal
        // CCW: flip left and right, then mirror along diagonal
        
        // constants
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Step 1: flip up and down
        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m - 1 - i][j];
                matrix[m - 1 - i][j] = temp;
            }
        }
        
        // Step 2: mirror along diagonal
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}