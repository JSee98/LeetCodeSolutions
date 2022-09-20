/*
 * DP SOLUTION THAT WILL GET ACCEPTED ON LC
 */

class Solution {
  int total = 0;
  boolean[][] dp;
  public boolean canPartition(int[] nums) {
      
      for(int val: nums){
          total+=val;
      } 
      if (total%2==1){
          return false;
      }
      
      dp = new boolean[nums.length+1][(total/2)+1];
      dp[0][0] = true;
      
      for (int i = 1; i<nums.length+1; i++){
          int val = nums[i-1];
          dp[i][0] = true;
          for (int j=1; j<=total/2; j++){
              boolean prevState = j-val>=0?dp[i-1][j-val]:false;
              dp[i][j] = dp[i-1][j] || prevState;
          }
      }
      
      return dp[nums.length][total/2];    
  }
  
}

/*
 * BackTracking with Memoization that will give Memory Error
 */

class Solution2 {
  int total = 0;
  int[][] dp;
  public boolean canPartition(int[] nums) {
      for(int val: nums){
          total+=val;
      } 
      if (total%2==1){
          return false;
      }
      dp = new int[total+1][total+1];
      return partition(nums, 0,0, 0);    
  }
  
  public boolean partition(int[] nums, int s1, int s2, int ind){
      if (ind == nums.length){
          if (s1==s2 && s1==total/2){
              return true;
          }
          return false;
      }
      
      if(dp[s1][s2]!=0){
          return dp[s1][s2] == 1 ? true:false;
      }
      
      s1 += nums[ind];
      boolean a1 = partition(nums, s1, s2, ind+1);
      s1 -= nums[ind];
      
      s2 += nums[ind];
      boolean a2 = partition(nums, s1, s2, ind+1);
      
      dp[s1][s2] = a1||a2 == true ? 1: -1;
      return a1||a2;
  }
}

/*
 * BackTracking that will give TLE
 */

class Solution3 {
  int total = 0;
  public boolean canPartition(int[] nums) {
      for(int val: nums){
          total+=val;
      } 
      if (total%2==1){
          return false;
      }
      return partition(nums, 0,0, 0);    
  }
  
  public boolean partition(int[] nums, int s1, int s2, int ind){
      if (ind == nums.length){
          if (s1==s2 && s1==total/2){
              return true;
          }
          return false;
      }
      
      s1 += nums[ind];
      boolean a1 = partition(nums, s1, s2, ind+1);
      s1 -= nums[ind];
      
      s2 += nums[ind];
      boolean a2 = partition(nums, s1, s2, ind+1);
      
      return a1||a2;
  }
}