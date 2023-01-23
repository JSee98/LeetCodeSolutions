/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ans = nums[0];

        for (int val: nums){
            if (val==ans){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                ans = val;
                count=1;
            }
        }
        return ans;    
    }
}
// @lc code=end

