/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int ind = n+m-1;
        if (n==0){
            return;
        }
        while(i>=0 && j>=0){
            if (nums1[i]>nums2[j]){
                nums1[ind] = nums1[i];
                i--;
            }
            else{
                nums1[ind] = nums2[j];
                j--;
            }
            ind--;
        }

        while(i>=0){
            nums1[ind] = nums1[i];  
            i--;
            ind--;
        }


        while(j>=0){
            nums1[ind] = nums2[j];
            j--;  
            ind--;
        }
    }
}
// @lc code=end

