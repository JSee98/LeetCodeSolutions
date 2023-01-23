public class Solution {

	// LINK TO QUESTION https://www.interviewbit.com/problems/repeat-and-missing-number-array/
    public int[] repeatedNumber(final int[] A) {
        
        int xAll = 0;
        int xArr = 0;
        for (int i = 0; i<A.length; i++){
            xArr ^= A[i];
            xAll ^= (i+1);
        }
        
        int xAB = xAll^xArr;
        
        int setBit = 31;
        for (int i=31; i>=0; i++){
            int bit = xAB&(1<<i);
            if (bit!=0){
                setBit = 1<<i;
                break;
            }
        }
        
        int xA = 0;
        int xB = 0;
        
        for (int i = 0; i<A.length; i++){
            int val = A[i];
            int ref = setBit&val;
            int ref2 = (i+1)&setBit;
            if (ref!=0){
                xA^=val;
            }
            else{
                xB ^= val;
            }
            
            if (ref2!=0){
                xA^=(i+1);
            }
            else{
                xB^=(i+1);
            }
        }
        
        int[] ans = new int[2];
        for (int val: A){
            if (val==xA){
                ans[0] = xA;
                ans[1] = xB;
                break;
            }
            else if (val==xB){
                ans[0]=xB;
                ans[1] = xA;
                break;
            }
        }
        return (ans);
        
        
        
    }
    
}

