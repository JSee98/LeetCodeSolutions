import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<List<String>>();
        genPerm(s, new ArrayList<>(), 0);
        return ans;
        
    }

    private void genPerm(String s, ArrayList<String> temp, int i){
        if (i==s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int stop = i; stop<s.length(); stop++){
            if (checkPali(s, i, stop)){
                temp.add(s.substring(i, stop+1));
                genPerm(s, temp, stop+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean checkPali(String s, int i, int j){
        while(i<=j && s.charAt(i)==s.charAt(j)){
            i++;
            j--;
        }
        return i>=j;
    }
}
// @lc code=end

