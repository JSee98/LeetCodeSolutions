/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        
        boolean Row0 = false;
        boolean Col0 = false;

        int n = matrix.length;
        int m = matrix[0].length;

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (matrix[i][j]==0){
                    
                    if (i==0){
                        Row0 = true;
                    }
                    if (j==0){
                        Col0 = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i=1; i<n; i++){
            if (matrix[i][0]==0){
                for (int j = 0; j<m; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j=1; j<m; j++){
            if (matrix[0][j]==0){
                for (int i = 0; i<n; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        if (Row0){
            for (int j=0; j<m; j++){
                matrix[0][j] = 0;
            }
        }
        if (Col0){
            for (int i=0; i<n; i++){
                matrix[i][0] = 0;
            }
        }


    }
}
// @lc code=end

