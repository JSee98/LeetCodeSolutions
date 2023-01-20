import java.util.*;

/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution {
    int n;
    int m;
    public int[][] updateMatrix(int[][] mat) {
        n = mat.length;
        m = mat[0].length;
        int[][] ans = new int[n][m];

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (mat[i][j]==0){
                    ans[i][j] = 0;
                }
                else{
                    // its 1 then answer is min of up and left +1
                    int up=Integer.MAX_VALUE-1;
                    int left = Integer.MAX_VALUE-1;

                    if (i-1>=0){
                        up = ans[i-1][j];
                    }
                    if (j-1>=0){
                        left = ans[i][j-1];
                    }
                    int min = Math.min(up, left);
                    if (min == Integer.MAX_VALUE){
                        ans[i][j] = Integer.MAX_VALUE;    
                    }
                    else{
                        ans[i][j] = min+1;
                    }
                    
                }
            }    
        }

        for (int i=n-1; i>=0; i--){
            for (int j=m-1; j>=0; j--){
                if (mat[i][j]==0){
                    ans[i][j] = 0;
                }
                else{
                    // its 1 then answer is min of down, right + 1 or current ans
                    int down=Integer.MAX_VALUE-1;
                    int right = Integer.MAX_VALUE-1;

                    if (i+1<n){
                        down = ans[i+1][j];
                    }
                    if (j+1<m){
                        right = ans[i][j+1];
                    }
                    int min = Math.min(down, right);
                    if (min != Integer.MAX_VALUE){
                        ans[i][j] = Math.min(ans[i][j], min+1);   
                    }
                }
            }    
        }


        return ans;
    }
}
// @lc code=end

