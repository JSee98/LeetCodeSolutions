import java.util.ArrayList;

/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i<n; i++){
            arr.add(i+1);
        }
        StringBuilder ans = new StringBuilder();

        int step = n;
        while(step>0){
            int currStepSize = getFact(step-1); // what number of permutations can we have by setting some number at i
            int stepsTaken = (k-1)/currStepSize; // which number will be set at i depending on taking steps of size currStepSize
            ans.append(arr.get(stepsTaken)); 
            arr.remove(stepsTaken); // remove current value from choice

            k-=stepsTaken*currStepSize; // update the k value as per the steps taken
            step--; // move to next position in answer
        }

        return ans.toString();
    }

    
    /*
     * returns factorial of the input
     */
    private static int getFact(int n){
        if (n==0){
            return 1;
        }
        return n*getFact(n-1);
    }
}
// @lc code=end

