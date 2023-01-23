/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 */

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0;
        int c2 = 0;
        int v1 = 1000000009;
        int v2 = 1000000009;
        int n = nums.length;

        List<Integer> ans = new ArrayList<Integer>();
        for(int val: nums){
            if (v1 == val){
                c1++;
            }
            else if (v2 == val){
                c2++;
            }
            else if (c2 == 0){
                v2 = val;
                c2 = 1;
            }
            else if (c1 == 0){
                v1 = val;
                c1 = 1;
            }
            else{
                c1--;
                c2--;
            }
        }



        c1 = 0;
        c2 = 0;
        for (int val: nums){
            if (v1 == val){
                c1++;
            }
            if (v2==val){
                c2++;
            }
        }
        
        if (c1>n/3){
            ans.add(v1);
        }
        if (c2>n/3){
            ans.add(v2);
        }

        return ans;
    }
}
// @lc code=end

