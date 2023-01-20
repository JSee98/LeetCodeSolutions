import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        ArrayList<int[]> stub = new ArrayList<int[]>();

        for (int[] arr: intervals){
            stub.add(arr);
        }

        int index = Collections.binarySearch(stub, newInterval, (a,b) -> {
            return a[0]-b[0];
        });

        if (index<0){
            index = (index*-1)-1;
        }
        stub.add(index, newInterval);

        ArrayList<int[]> merged= new ArrayList<int[]>();

        for (int[] arr: stub){
            if (merged.size()==0){
                merged.add(arr);
            }

            int[] prev = merged.get(merged.size()-1);
            
            if (arr[0]<=prev[1]){
                // needs merge
                prev[1] = Math.max(prev[1], arr[1]);
                merged.set(merged.size()-1, prev);
            }
            else{
                merged.add( arr);
            }
        }
        int[][] ans = new int[merged.size()][2];
        int ind = 0;
        for (int[] arr: merged){
            ans[ind] = arr;
            ind++;
        }
        return ans;
    }

    
}
// @lc code=end

