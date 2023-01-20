/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        
        int ans = Integer.MIN_VALUE;
        int currSum = Integer.MIN_VALUE;

        for (int val: nums){
            if (currSum<0){
                currSum = val;
            }
            else{
                currSum+=val;
            }
            ans = Math.max(ans, currSum);
        }
        return ans;
    }
}
// @lc code=end

