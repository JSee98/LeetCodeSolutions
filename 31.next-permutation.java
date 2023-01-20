import java.util.Arrays;

/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int dip = -1;
        for (int i=nums.length-1; i>=1; i--){
            if (nums[i]>nums[i-1]){
                dip = i-1;
                break;
            }
        }
        if (dip==-1){
            Arrays.sort(nums);
            return;
        }
        for (int i = nums.length-1; i>=dip; i--){
            if (nums[i]>nums[dip]){
                int temp = nums[dip];
                nums[dip] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        if (dip+1<=nums.length){
            Arrays.sort(nums, dip+1, nums.length);
        }
        
    }
}
// @lc code=end

