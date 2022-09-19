class Solution {
  public int findKthLargest(int[] nums, int k) {

      // O(2*N) SPACE AND O(N) TIME
      
      int[] pos = new int[100000];
      int[] neg = new int[100000];
      
      int max = Integer.MIN_VALUE;
      int posCount = 0;
      int negCount = 0;
      for (int val: nums){
          if (val>max){
              max=val;
          }
          if (val>=0){
              pos[val] += 1;
              posCount++;
          }
          else{
              neg[Math.abs(val)] += 1;
              negCount++;
          }
      }
      
      int start = max;
      int end = -1;
      int step = -1;
      int[] toCheck = pos;
      boolean isNeg = false;
      int count = 0;
      if (k>posCount){
          // the answer is negative
          start = 1;
          end = max+1;
          step = 1;
          toCheck = neg;
          isNeg = true;
          count = posCount;
      }
      
      int i = start;
      int ans = Integer.MAX_VALUE;
      
      //System.out.printf("%d, %d, %d, %b\n", start, end, step, isNeg);
      while(i!=end){
          if (toCheck[i]>0){
              count+=toCheck[i];
          }
          if (count >= k){
              ans = i*(isNeg?-1:1);
              break;
          }
          i+=step;
      }
      
      if (ans==Integer.MAX_VALUE){
          System.out.println("NO VALID ANSWER AVAILABLE");
      }
      
      return ans;
      
  }
}