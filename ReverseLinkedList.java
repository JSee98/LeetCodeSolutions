/**
 * Definition for singly-linked list.
 * 
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
  public ListNode reverseBetween(ListNode head, int left, int right) {
      
      ListNode n = head;
      if (head == null){
          return n;
      }
      int pos = 1;
      ListNode savedParent = null;
      ListNode savedChild = null;
      ListNode start = new ListNode();
      
      while(n!=null){
          if (pos < left){
              savedParent = n;
          }
          if (pos==left){
              start = n;
          }
          if (pos==right+1){
              savedChild = n;
          }
          n = n.next;
          pos++;
      }
      
      int count = 0;
      ListNode prev = new ListNode();
      ListNode ptr = start;
      
      while(count<right-left+1){
          
          ListNode origNxt = ptr.next;
          ptr.next = prev;
          
          prev = ptr;
          ptr = origNxt;
          
          count++;
      }
      
      start.next = savedChild;
      
      if (savedParent!=null){
          savedParent.next = prev;    
      }
      
      if (left == 1){
          return prev;
      }
      return head;
      
  }
}