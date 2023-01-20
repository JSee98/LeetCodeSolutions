import java.util.*;;
/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (numRows >= 1){
            ans.add(new ArrayList<Integer>(Arrays.asList(1)));
        }
        if (numRows > 1){
            ans.add(new ArrayList<Integer>(Arrays.asList(1,1)));
        }

        for (int i=2; i<numRows; i++){
            List<Integer> prev = ans.get(ans.size()-1);
            ArrayList<Integer> toAdd = new ArrayList<Integer>();
            toAdd.add(1);
            for (int j=1; j<prev.size(); j++){
                toAdd.add(prev.get(j)+prev.get(j-1));
            }
            toAdd.add(1);
            ans.add(toAdd);
        }

        return ans;
    }
}
// @lc code=end

